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

        Park park = new Park(this, getParkPosition);

        ImageView parkImage = findViewById(R.id.park_image);
        parkImage.setImageResource(park.getParkImage());
        ((TextView)findViewById(R.id.park_websrc)).setText(park.getParkWeb());
        ((TextView)findViewById(R.id.park_address)).setText(park.getParkAddress());

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
