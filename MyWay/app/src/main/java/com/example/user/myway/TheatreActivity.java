package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TheatreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);

        final int getTheatrePosition = getIntent().getIntExtra("positionForTheatre", 0);
        final String[] theatresWeb = getResources().getStringArray(R.array.theatres_web_array);
        final String[] theatresAddresses = getResources().getStringArray(R.array.theatres_addresses_array);
        final String[] theatresDesc = getResources().getStringArray(R.array.theatres_descriptions_array);
        final int[] theatresImages = {
                R.drawable.the_a,
                R.drawable.the_b,
                R.drawable.the_c,
                R.drawable.the_d,
                R.drawable.the_e,
                R.drawable.the_f,
                R.drawable.the_g,
                R.drawable.the_h,
                R.drawable.the_i,
        };

        ImageView theatreImage = findViewById(R.id.theatre_image);
        theatreImage.setImageResource(theatresImages[getTheatrePosition]);
        ((TextView)findViewById(R.id.theatre_description)).setText(theatresDesc[getTheatrePosition]);
        ((TextView)findViewById(R.id.theatre_websrc)).setText(theatresWeb[getTheatrePosition]);
        ((TextView)findViewById(R.id.theatre_address)).setText(theatresAddresses[getTheatrePosition]);

        //region BackButton
        Button theatreBackButton = findViewById(R.id.theatre_back_button);
        theatreBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheatreActivity.this.finish();
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
