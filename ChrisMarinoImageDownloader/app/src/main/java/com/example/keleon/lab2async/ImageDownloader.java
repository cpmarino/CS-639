package com.example.keleon.lab2async;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Keleon on 10/15/14.
 */
public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private Context mContext;
    private View rootView;

    public  ImageDownloader(Context context, View rootView)
    {
        this.mContext = context;
        this.rootView = rootView;
    }

    @Override
    protected Bitmap doInBackground(String... params)
    {
        try
        {
            URL url = new URL(params[0]);
            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
            if(httpCon.getResponseCode() !=200)
                throw new Exception("Failed to Connect");
            InputStream is = httpCon.getInputStream();
            return BitmapFactory.decodeStream(is);
        }
        catch (Exception e){
            Log.e("Image", "Failed to Load Image", e);
        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        ImageView iv = (ImageView)rootView.findViewById(R.id.remote_image);
        if (iv!= null && img != null)
            iv.setImageBitmap(img);

    }



    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

}
