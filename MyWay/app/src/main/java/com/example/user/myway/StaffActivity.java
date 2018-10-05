package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class StaffActivity extends AppCompatActivity{
    int scoreNum = 0;
    String rightAnswer;
    public int positionOfStaff = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        final int getPosition = getIntent().getIntExtra("positionForStaff",-1);
        final Staff currentStaff = new Staff(this,getPosition);

        //region SetStuffInfo
        final ImageView staff = findViewById(R.id.staffImage);
        staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
        final EditText editAnswer = findViewById(R.id.editAnswer);
        final Button confirm = findViewById(R.id.confirm);
        final TextView score = findViewById(R.id.score);
        score.setText("0");
        //endregion

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

        //region NewStaff
        final Button newStaff = findViewById(R.id.new_staff);
        newStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionOfStaff++;
                if (positionOfStaff<currentStaff.getLength()){
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);}
                else {
                    positionOfStaff = 0;
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);
                }
            }
        });
        //endregion

        //region MoveToRecommendActivity
        final Button nextButton = findViewById(R.id.next_button_1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecommend = new Intent(StaffActivity.this, RecommendActivity.class);
                intentRecommend.putExtra("positionForRecommend",getPosition);
                startActivity(intentRecommend);
            }
        });
        //endregion
    }

}


