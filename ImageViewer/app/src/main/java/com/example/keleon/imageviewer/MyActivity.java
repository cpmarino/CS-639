package com.example.keleon.imageviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MyActivity extends Activity {

    private ImageView gallery;
    private TextView title;
    int[] image = {R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4};
    String[] name = {"Crow", "Hawk", "Raven", "Eagle"};
    private int currentImage = 0;
    private int currentName = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        gallery = (ImageView)findViewById(R.id.image_view);
        title = (TextView)findViewById(R.id.text_view);
        title.setText(name[currentName]);
        Button prev = (Button)findViewById(R.id.prev);
        if(prev!=null)
            prev.setOnClickListener(mClickListenerPrev);
        Button next = (Button)findViewById(R.id.next);
        if(next!=null)
            next.setOnClickListener(mClickListenerNext);


    }

    private View.OnClickListener mClickListenerPrev = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            currentImage--;
            currentImage = (currentImage + image.length) % image.length;
            currentName--;
            currentName = (currentName + name.length)%name.length;
            gallery.setImageResource(image[currentImage]);
            title.setText(name[currentName]);

        }

    };

    private View.OnClickListener mClickListenerNext = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            currentImage++;
            currentImage = currentImage % image.length;
            currentName++;
            currentName = currentName % name.length;
            gallery.setImageResource(image[currentImage]);
            title.setText(name[currentName]);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
