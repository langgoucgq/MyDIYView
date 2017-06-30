package com.example.kyoungcai.mydiyview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.example.kyoungcai.mydiyview.myview.MyLayout;

public  class MainActivity extends AppCompatActivity {

    private MyLayout myLayout;
    private SeekBar mySeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        Log.i("cky","cky111");

        initEvent();
    }

    private void initEvent() {
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                myLayout.showSliceView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initView() {
        myLayout= (MyLayout) findViewById(R.id.mylayout);
        mySeekBar= (SeekBar) findViewById(R.id.my_seekbar);

    }
}
