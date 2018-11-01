package com.example.user.myway;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //region BackButton
        Button backFromOptions = findViewById(R.id.backFromOptions);
        backFromOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Options.this.finish();
            }
        });
        //endregion

        //region DeleteButton
        Button delete = findViewById(R.id.deleteAll);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = getResources().getStringArray(R.array.place_names_array).length;

                for (int i = 0; i<temp-1; i++){
                    Staff staff = new Staff(Options.this,i);
                    staff.resetCurrentCompletedAnswers();
                }
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
