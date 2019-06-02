package com.example.ganeshjanani.myapplication;

import android.content.Intent;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ViewPager vp;
  //  private SliderAdapter adapter;
    private FragmentVpAdapter mFragmentVpAdapter;
    private LinearLayout mDotLayout;
    private TextView[] mDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button4);
        vp= findViewById(R.id.viewpager);
        mFragmentVpAdapter=new FragmentVpAdapter(getSupportFragmentManager());
      //  adapter= new SliderAdapter(this);

        mDotLayout= findViewById(R.id.dotslayout);
           mFragmentVpAdapter.addFragmets();
        vp.setAdapter(mFragmentVpAdapter);
        addDotsIndicator(0);

        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              Intent i= new Intent(getApplicationContext(),tabclass.class);
              v.getContext().startActivity(i);
           }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//               addDotsIndicator(position);
//
//               if(position==mDots.length-1)
//               {  btn.setEnabled(true);
//                   btn.setVisibility(View.VISIBLE);
//               }else
//                   btn.setVisibility(View.INVISIBLE);

           }

           @Override
           public void onPageSelected(int position) {
              addDotsIndicator(position);

              if(position==mDots.length-1)
              {  btn.setEnabled(true);
                  btn.setVisibility(View.VISIBLE);
              }else
                  btn.setVisibility(View.INVISIBLE);
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }

    private void addDotsIndicator(int position) {

        mDots= new TextView[3];
        mDotLayout.removeAllViews();


        for(int i=0;i<mDots.length;i++){

                 mDots[i]=new TextView(this);
                 mDots[i].setText(Html.fromHtml("&#8226;"));
                 mDots[i].setTextSize(35);
                 mDots[i].setTextColor(getResources().getColor(R.color.colorTranparentWhite));
                 mDotLayout.addView(mDots[i]);
       }
            Log.d("position" ,"postion is " + position + "and " + mDots.length);

                 if(mDots.length>0) {

                     mDots[position].setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
                 }



    }

}