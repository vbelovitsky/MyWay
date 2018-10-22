package com.example.user.myway;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class StaffActivity extends AppCompatActivity{
    int scoreNum = 0;
    int positionOfStaff = 0;
    String rightAnswer = "";
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        final int getPosition = getIntent().getIntExtra("positionForStaff",-1);
        final Staff currentStaff = new Staff(this, getPosition);

        sp = getSharedPreferences("Score", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        //region SetStuffInfo
        final ImageView staff = findViewById(R.id.staffImage);
        staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
        final EditText editAnswer = findViewById(R.id.editAnswer);
        final Button previousStaff = findViewById(R.id.previousStaff);
        final Button confirm = findViewById(R.id.confirmStaff);
        final Button newStaff = findViewById(R.id.nextStaff);
        final Button resetScore = findViewById(R.id.reset_score);
        final TextView score = findViewById(R.id.score);
        score.setText(sp.getString("Score"+getPosition,"0"));
        scoreNum = Integer.parseInt(sp.getString(("Score"+getPosition),"0"));
        //endregion

        //region ConfirmStaff
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentStaff.checkCurrentCompletedAnswer(positionOfStaff)) {
                    String answer = editAnswer.getText().toString();
                    if (answer.equals(currentStaff.getAnswer(positionOfStaff))) {
                        currentStaff.setCurrentCompletedAnswer(positionOfStaff);
                        scoreNum = scoreNum + 1;
                        score.setText(String.valueOf(scoreNum));
                        editor.putString("Score"+getPosition, String.valueOf(scoreNum));
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                    }
                    else if (answer.equals(""))
                        Toast.makeText(getApplicationContext(), "Введите ответ", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Неверный ответ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Уже отгадано", Toast.LENGTH_SHORT).show();

            }
        });
        //endregion

        //region PreviousStaff
        previousStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionOfStaff--;
                if (positionOfStaff<0){
                    positionOfStaff = currentStaff.getLength()-1;
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);}
                else {
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);
                }
            }
        });
        //endregion

        //region NewStaff
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

        //region ResetScore
        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreNum=0;
                editor.putString("Score"+getPosition, "0");
                editor.apply();
                score.setText(sp.getString("Score"+getPosition,"0"));
                currentStaff.resetCurrentCompletedAnswers();
            }
        });
        //endregion
    }


}


