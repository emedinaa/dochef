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
import info.androidhive.slidingmenu.model.Plan;


public class PlanActivity extends Activity {

    ImageLoader imageLoader = MainApplication.getInstance().getImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_detail);


        if (imageLoader == null)
            imageLoader = MainApplication.getInstance().getImageLoader();

        Intent intent = getIntent();
        Plan plan = (Plan) intent.getSerializableExtra("plan");


        NetworkImageView planImagen = (NetworkImageView) findViewById(R.id.planImagen);
        planImagen.setImageUrl(plan.getImagen(), imageLoader);

        TextView titulo = (TextView) findViewById(R.id.tituloPlan);
        titulo.setText(plan.getTitulo());


        TextView descripcion = (TextView) findViewById(R.id.descripcionPlan);
        descripcion.setText(plan.getDescripion());



    }

}
