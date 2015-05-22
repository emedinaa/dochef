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

import info.androidhive.slidingmenu.adapter.ConsejoListAdapter;
import info.androidhive.slidingmenu.adapter.RecetaListAdapter;
import info.androidhive.slidingmenu.model.Consejo;
import info.androidhive.slidingmenu.model.Movie;
import info.androidhive.slidingmenu.model.Receta;

public class CommunityFragment extends Fragment {


    private static final String TAG = CommunityFragment.class.getSimpleName();

    // Movies json url
    private static final String url = "http://www.dochef.net/resources/json/consejos.json";
    private ProgressDialog pDialog;
    private List<Consejo> consejoList = new ArrayList<Consejo>();
    private ListView listView;
    private ConsejoListAdapter adapter;


    public CommunityFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_community, container, false);


        listView = (ListView) rootView.findViewById(R.id.listConsejos);
        adapter = new ConsejoListAdapter(getActivity(), consejoList);
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

                                Consejo consejo = new Consejo();
                                consejo.setId((Integer) obj.get("id"));
                                consejo.setTitulo(obj.getString("titulo"));
                                consejo.setAutor(obj.getString("autor"));
                                consejo.setImagen(obj.getString("imagen"));
                                consejo.setDescripcion(obj.getString("descripcion"));


                                // adding movie to movies array
                                consejoList.add(consejo);

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
                Consejo consejo = (Consejo) adapterView.getItemAtPosition(position);
                Intent irDetalleConsejo = new Intent(getActivity(), ConsejoActivity.class);
                irDetalleConsejo.putExtra("consejo", consejo);

                startActivity(irDetalleConsejo);
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
