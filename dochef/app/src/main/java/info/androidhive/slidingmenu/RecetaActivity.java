package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import info.androidhive.slidingmenu.model.Receta;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class RecetaActivity extends Activity {

    ImageLoader imageLoader = MainApplication.getInstance().getImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receta_detail);


        if (imageLoader == null)
            imageLoader = MainApplication.getInstance().getImageLoader();

        Intent intent = getIntent();
        Receta receta = (Receta) intent.getSerializableExtra("receta");


        NetworkImageView recetaImagen = (NetworkImageView) findViewById(R.id.recetaImagen);
        recetaImagen.setImageUrl(receta.getImagen(), imageLoader);

        TextView titulo = (TextView) findViewById(R.id.tituloReceta);
        titulo.setText(receta.getTitulo());


        TextView descripcion = (TextView) findViewById(R.id.descripcionReceta);
        descripcion.setText(receta.getDescripcion());

        TextView ingredientes = (TextView) findViewById(R.id.ingredientes);
        ingredientes.setText(receta.getIngredientes());

        TextView preparacion = (TextView) findViewById(R.id.preparacion);
        preparacion.setText(receta.getPreparacion());


    }

}
