package com.example.user.myway;

import android.content.Intent;
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

        final int[] fImages = {
            R.drawable.caa_festcafe,
                R.drawable.cab_mcdac,
                R.drawable.cac_festcafe,
                R.drawable.cad_teremok,
                R.drawable.cae_burgerking,
                R.drawable.caf_nookcoffee,
                R.drawable.cag_burgerking,
                R.drawable.cah_darvincafe,
                R.drawable.cai_paleomus,
                R.drawable.caj_burgerking,
                R.drawable.cak_burgerking,
                R.drawable.cal_tretiakcafe
        };
        final String [] fName = getResources().getStringArray(R.array.cafe_array);
        final String [] fAddress = getResources().getStringArray(R.array.cafeaddresses_array);
        final String [] fDesc = getResources().getStringArray(R.array.food_array);

        ImageView foodImage = findViewById(R.id.food_image);
        foodImage.setImageResource(fImages[getPosition]);
        TextView foodName = findViewById(R.id.food_name);
        foodName.setText(fName[getPosition]);
        TextView foodAddress = findViewById(R.id.food_address);
        foodAddress.setText(fAddress[getPosition]);
        TextView foodDesc = findViewById(R.id.food_desc);
        foodDesc.setText(fDesc[getPosition]);

        Button btn = findViewById(R.id.go_to_menu);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
