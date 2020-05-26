package com.example.gaalerie;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    int[] images;
    LayoutInflater inflater;
    Context context;


    public ViewPagerAdapter(Activity activity, int[] images) {
        this.activity = activity;
        this.images = images;
    }

    int[] audio = {
            R.raw.a,
            R.raw.b,
            R.raw.c,
            R.raw.d,
            R.raw.e,
            R.raw.f,

    };

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container, false);
        ImageView image;
        image = itemView.findViewById(R.id.imageView);
        // mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), audio[position]);
        //imageView.setImageResource(list_img[position]);
        image.setImageResource(images[position]);

        //mediaPlayer.start();
        container.addView(itemView,0);
       Log.d("papa", "instantiateItem: " +  itemView.getId() );

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
        //Log.d("papa", "instantiateItem: " + position);
        // mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), audio[position]);
        //  container.removeView((View) object);
    }
}
