package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import info.androidhive.slidingmenu.model.Consejo;
import info.androidhive.slidingmenu.model.Receta;


public class ConsejoActivity extends Activity {

    ImageLoader imageLoader = MainApplication.getInstance().getImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consejo_detail);


        if (imageLoader == null)
            imageLoader = MainApplication.getInstance().getImageLoader();

        Intent intent = getIntent();
        Consejo consejo = (Consejo) intent.getSerializableExtra("consejo");


        NetworkImageView consejoImagen = (NetworkImageView) findViewById(R.id.consejoImagen);
        consejoImagen.setImageUrl(consejo.getImagen(), imageLoader);

        TextView titulo = (TextView) findViewById(R.id.tituloConsejo);
        titulo.setText(consejo.getTitulo());


        TextView descripcion = (TextView) findViewById(R.id.descripcionConsejo);
        descripcion.setText(consejo.getDescripcion());



    }

}
