package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        final int getInfoPosition = getIntent().getIntExtra("positionForInfo", 0);
        final int getInfoPlacePosition = getIntent().getIntExtra("positionOfPlaceForInfo", 0);

        //region BackButton
        Button infoBackButton = findViewById(R.id.info_back_button);
        infoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, StaffActivity.class);
                intent.putExtra("positionFromInfo", getInfoPosition);
                intent.putExtra("positionForStaff", getInfoPlacePosition);
                startActivity(intent);
            }
        });
        //endregion
    }
}
