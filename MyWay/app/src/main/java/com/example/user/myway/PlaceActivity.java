package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        final int getPosition = getIntent().getIntExtra("positionForPlace",-1);
        final Place currentPlace = new Place(this);
        currentPlace.setRes(getPosition);



        ImageView placeImage = findViewById(R.id.place_image);
        placeImage.setImageResource(currentPlace.getImage());

        ((TextView)findViewById(R.id.place_description)).setText(currentPlace.getDescription());
        ((TextView)findViewById(R.id.websrc)).setText(currentPlace.getWeb());
        ((TextView)findViewById(R.id.address)).setText(currentPlace.getAddress());
        ((TextView)findViewById(R.id.number)).setText(currentPlace.getNumber());
        ((TextView)findViewById(R.id.hours)).setText(currentPlace.getHours());

        ImageButton nextButton = findViewById(R.id.next_button);
        nextButton.setImageResource(R.drawable.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStaff = new Intent(PlaceActivity.this, StaffActivity.class);
                intentStaff.putExtra("positionForStaff",getPosition);
                startActivity(intentStaff);
            }
        });

    }
}
