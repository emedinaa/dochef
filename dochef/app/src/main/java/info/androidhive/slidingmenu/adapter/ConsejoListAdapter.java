package info.androidhive.slidingmenu.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import info.androidhive.slidingmenu.MainApplication;
import info.androidhive.slidingmenu.R;
import info.androidhive.slidingmenu.model.Consejo;
import info.androidhive.slidingmenu.model.Receta;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class ConsejoListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Consejo> consejoItems;
    ImageLoader imageLoader = MainApplication.getInstance().getImageLoader();

    public ConsejoListAdapter(Activity activity, List<Consejo> consejoItems) {
        this.activity = activity;
        this.consejoItems = consejoItems;
    }

    @Override
    public int getCount() {
        return consejoItems.size();
    }

    @Override
    public Object getItem(int location) {
        return consejoItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = MainApplication.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Consejo consejo = consejoItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(consejo.getImagen(), imageLoader);

        // title
        title.setText(consejo.getTitulo());


        rating.setText(consejo.getAutor());

        genre.setText("");


        year.setText("");

        return convertView;
    }

}