package info.androidhive.slidingmenu;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.Locale;

import info.androidhive.slidingmenu.model.UsuarioBean;
import info.androidhive.slidingmenu.util.LruBitmapCache;


public class MainApplication extends Application  {

    public static final String TAG = MainApplication.class.getSimpleName();

    private UsuarioBean userInSession;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static MainApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Locale.setDefault(new Locale("es","PE"));
        mInstance = this;

    }
    public static synchronized MainApplication getInstance() {
        return mInstance;
    }


    public void setUserInSession(UsuarioBean userInSession) {
        this.userInSession = userInSession;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
