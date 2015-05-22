package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.slidingmenu.adapter.PlanListAdapter;
import info.androidhive.slidingmenu.adapter.RecetaListAdapter;
import info.androidhive.slidingmenu.model.Consejo;
import info.androidhive.slidingmenu.model.Movie;
import info.androidhive.slidingmenu.model.Plan;

public class PagesFragment extends Fragment {


    private static final String TAG = PagesFragment.class.getSimpleName();

    // Movies json url
    private static final String url = "http://www.dochef.net/resources/json/planes.json";
    private ProgressDialog pDialog;
    private List<Plan> planList = new ArrayList<Plan>();
    private ListView listView;
    private PlanListAdapter adapter;



    public PagesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);

        listView = (ListView) rootView.findViewById(R.id.listPlanes);
        adapter = new PlanListAdapter(getActivity(), planList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        getActivity().getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));


        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {


                                JSONObject obj = response.getJSONObject(i);

                                Plan plan = new Plan();
                                plan.setId((Integer) obj.get("id"));
                                plan.setTitulo(obj.getString("titulo"));
                                plan.setAutor(obj.getString("autor"));
                                plan.setImagen(obj.getString("imagen"));
                                plan.setDescripion(obj.getString("descripcion"));

                                // adding movie to movies array
                                planList.add(plan);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(movieReq);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // CursorAdapter returns a cursor at the correct position for getItem(), or null
                // if it cannot seek to that position.
                Plan plan = (Plan) adapterView.getItemAtPosition(position);
                Intent irDetallePlan = new Intent(getActivity(), PlanActivity.class);
                irDetallePlan.putExtra("plan", plan);

                startActivity(irDetallePlan);
            }
        });


        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}

