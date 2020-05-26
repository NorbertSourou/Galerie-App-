package com.example.gaalerie;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MediaPlayer mediaPlayer;
    ImageButton btnPrev, btnNext;
    int page = 0;
    int a = 0;
    ViewPagerAdapter viewPagerAdapter;
    int[] audio = {
            R.raw.a,
            R.raw.b,
            R.raw.c,
            R.raw.d,
            R.raw.e,
            R.raw.f,

    };
    private int[] images = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrev = findViewById(R.id.prev);
        btnNext = findViewById(R.id.next);

        btnPrev.setVisibility(View.GONE);
        setupViewPager();
        pageChange();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.stop();
//                }
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), images[a]);
//                mediaPlayer.start();
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

                a++;
                Log.d("aaa", "onClick: " + viewPager.getCurrentItem());
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                Log.d("aaaa", "onClick: " + viewPager.getCurrentItem());
            }
        });
    }

    private void pageChange() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                page = i;
                Log.d("i", "i" + i);
                if (page == 0) {
                    btnPrev.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                } else if (page == (images.length) - 1) {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                } else {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void setupViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
    }
}