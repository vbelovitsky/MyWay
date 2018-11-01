package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ParkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        final int getParkPosition = getIntent().getIntExtra("positionForPark", 0);
        final String[] parksWeb = getResources().getStringArray(R.array.parks_web_array);
        final int[] parksImages = {
                R.drawable.par_a,
                R.drawable.par_b,
                R.drawable.par_c,
                R.drawable.par_d,
                R.drawable.par_e,
                R.drawable.par_f,
                R.drawable.par_g,
                R.drawable.par_h,
                R.drawable.par_i,
        };

        ImageView parkImage = findViewById(R.id.park_image);
        parkImage.setImageResource(parksImages[getParkPosition]);
        ((TextView)findViewById(R.id.park_websrc)).setText(parksWeb[getParkPosition]);

        //region BackButton
        Button parkBackButton = findViewById(R.id.park_back_button);
        parkBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParkActivity.this.finish();
            }
        });
        //endregion

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

}
