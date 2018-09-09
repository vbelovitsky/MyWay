package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class StaffActivity extends AppCompatActivity{
    int scoreNum = 0;
    String rightAnswer;
    public int positionOfStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        final int getPosition = getIntent().getIntExtra("positionForStaff",-1);
        final Staff currentStaff = new Staff(this,getPosition);
        final Random rand = new Random();

        final ImageView staff = findViewById(R.id.staffImage);
        positionOfStaff = rand.nextInt(23);
        staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));

        final EditText editAnswer = findViewById(R.id.editAnswer);



        final ImageButton confirm = findViewById(R.id.confirm);
        confirm.setImageResource(R.drawable.confirm);

        final TextView score = findViewById(R.id.score);
        score.setText("0");

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = editAnswer.getText().toString();
                rightAnswer = currentStaff.getAnswer(positionOfStaff);
                if (answer.equals(rightAnswer)){
                    scoreNum = scoreNum+1;
                    String temp = String.valueOf(scoreNum);
                    score.setText(temp);
                }
            }
        });

        final ImageButton newStaff = findViewById(R.id.new_staff);
        newStaff.setImageResource(R.drawable.restart_arrow);
        newStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionOfStaff = rand.nextInt(23);
                staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                rightAnswer = currentStaff.getAnswer(positionOfStaff);
            }
        });

        final ImageButton nextButton = findViewById(R.id.next_button_1);
        nextButton.setImageResource(R.drawable.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecommmend = new Intent(StaffActivity.this, RecommendActivity.class);
                intentRecommmend.putExtra("positionForRecommend",getPosition);
                startActivity(intentRecommmend);
            }
        });

    }

}


