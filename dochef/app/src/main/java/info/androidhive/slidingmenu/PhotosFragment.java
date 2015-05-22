package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
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

import info.androidhive.slidingmenu.adapter.RecetaListAdapter;
import info.androidhive.slidingmenu.model.Receta;

public class PhotosFragment extends Fragment {

    private static final String TAG = PhotosFragment.class.getSimpleName();

    // Movies json url
    private static final String url = "http://www.dochef.net/resources/json/recetas.json";
    private ProgressDialog pDialog;
    private List<Receta> recetaList = new ArrayList<Receta>();
    private ListView listView;
    private RecetaListAdapter adapter;


	public PhotosFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        listView = (ListView) rootView.findViewById(R.id.listRecetas);
        adapter = new RecetaListAdapter(getActivity(), recetaList);
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

                                Receta receta = new Receta();
                                receta.setId((Integer) obj.get("id"));
                                receta.setTitulo(obj.getString("titulo"));
                                receta.setAutor(obj.getString("autor"));
                                receta.setImagen(obj.getString("imagen"));
                                receta.setDescripcion(obj.getString("descripcion"));
                                receta.setIngredientes(obj.getString("ingredientes"));
                                receta.setPreparacion(obj.getString("preparacion"));

                                // adding movie to movies array
                                recetaList.add(receta);

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
                Receta receta = (Receta) adapterView.getItemAtPosition(position);
                Intent irDetalleReceta = new Intent(getActivity(), RecetaActivity.class);
                irDetalleReceta.putExtra("receta", receta);

                startActivity(irDetalleReceta);
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
