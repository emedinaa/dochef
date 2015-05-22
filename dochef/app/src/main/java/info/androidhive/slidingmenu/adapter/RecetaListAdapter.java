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
import info.androidhive.slidingmenu.model.Movie;
import info.androidhive.slidingmenu.model.Receta;


public class RecetaListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Receta> recetaItems;
	ImageLoader imageLoader = MainApplication.getInstance().getImageLoader();

	public RecetaListAdapter(Activity activity, List<Receta> recetaItems) {
		this.activity = activity;
		this.recetaItems = recetaItems;
	}

	@Override
	public int getCount() {
		return recetaItems.size();
	}

	@Override
	public Object getItem(int location) {
		return recetaItems.get(location);
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
		Receta receta = recetaItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(receta.getImagen(), imageLoader);
		
		// title
		title.setText(receta.getTitulo());
		

		rating.setText(receta.getAutor());
		
		genre.setText("");
		

		year.setText("");

		return convertView;
	}

}