package com.example.user.myway;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        final int getPosition = getIntent().getIntExtra("positionForRecommend",-1);
        final int getRecommendedParkPosition = getIntent().getIntExtra("positionForRecommendedPark", -1);
        final Recommend currentRecommend = new Recommend(this, getPosition);
        final Park currentpark = new Park(this, getRecommendedParkPosition);


        //region SetCafeInfo
        ImageView foodImage = findViewById(R.id.food_image);
        foodImage.setImageResource(currentRecommend.getCafeImage());
        TextView foodName = findViewById(R.id.food_name);
        foodName.setText(currentRecommend.getCafeName());
        TextView foodAddress = findViewById(R.id.food_address);
        foodAddress.setText(currentRecommend.getCafeAddress());
        TextView foodDesc = findViewById(R.id.food_desc);
        foodDesc.setText(currentRecommend.getCafeDesc());
        //endregion

        ImageView recoMapImage = findViewById(R.id.minimap);
        recoMapImage.setImageResource(currentRecommend.getMapImage());
        ImageView recoParkImage = findViewById(R.id.reco_park_image);
        recoParkImage.setImageResource(currentpark.getParkImage());
        ((TextView)findViewById(R.id.reco_park_desc)).setText(currentpark.getParkDesc());
        ((TextView)findViewById(R.id.reco_park_web)).setText(currentpark.getParkWeb());
        ((TextView)findViewById(R.id.reco_park_address)).setText(currentpark.getParkAddress());

        //region MoveToMainActivity
        final Button nextButton = findViewById(R.id.go_to_menu);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this,MainActivity.class);
                startActivity(intent);
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
