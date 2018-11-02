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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class StaffActivity extends AppCompatActivity{
    int scoreNum = 0;
    int positionOfStaff = 0;
    String rightAnswer = "";
    SharedPreferences sp;
    int wrongAnswersCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        final int getPosition = getIntent().getIntExtra("positionForStaff",-1);
        final int getRecommendedParkPosition = getIntent().getIntExtra("positionForRecommendedPark", -1);
        positionOfStaff = getIntent().getIntExtra("positionFromInfo", 0);
        final Staff currentStaff = new Staff(this, getPosition);

        sp = getSharedPreferences("Score", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        //region SetStuffInfo
        final LinearLayout staffLayout = findViewById(R.id.staff_layout);
        if (currentStaff.checkCurrentCompletedAnswer(positionOfStaff))
            staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
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
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
                        scoreNum = scoreNum + 1;
                        currentStaff.setCurrentCompletedAnswer(positionOfStaff, scoreNum);
                        score.setText(String.valueOf(scoreNum));
                        editor.putString("Score"+getPosition, String.valueOf(scoreNum));
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                    }
                    else if (answer.equals(""))
                        Toast.makeText(getApplicationContext(), "Введите ответ", Toast.LENGTH_SHORT).show();
                    else{
                        wrongAnswersCount++;
                        if (wrongAnswersCount<7)
                            Toast.makeText(getApplicationContext(), "Неверный ответ", Toast.LENGTH_SHORT).show();
                        else{
                            editAnswer.setText(currentStaff.getAnswer(positionOfStaff));
                            Toast.makeText(getApplicationContext(), "Подсказка", Toast.LENGTH_SHORT).show();}
                        }
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
                wrongAnswersCount = 0;
                positionOfStaff--;
                editAnswer.setText("");
                if (positionOfStaff<0){
                    positionOfStaff = currentStaff.getLength()-1;
                    //region LayoutBackgroundChanging
                    if (currentStaff.checkCurrentCompletedAnswer(positionOfStaff))
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
                    else
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestOrange));
                    //endregion
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);}
                else {
                    //region LayoutBackgroundChanging
                    if (currentStaff.checkCurrentCompletedAnswer(positionOfStaff))
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
                    else
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestOrange));
                    //endregion
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
                wrongAnswersCount = 0;
                positionOfStaff++;
                editAnswer.setText("");
                if (positionOfStaff<currentStaff.getLength()){
                    //region LayoutBackgroundChanging
                    if (currentStaff.checkCurrentCompletedAnswer(positionOfStaff))
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
                    else
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestOrange));
                    //endregion
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);}
                else {
                    positionOfStaff = 0;
                    //region LayoutBackgroundChanging
                    if (currentStaff.checkCurrentCompletedAnswer(positionOfStaff))
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestGreen));
                    else
                        staffLayout.setBackgroundColor(getResources().getColor(R.color.colorLightestOrange));
                    //endregion
                    staff.setImageResource(currentStaff.getStaffImage(positionOfStaff));
                    rightAnswer = currentStaff.getAnswer(positionOfStaff);
                }

            }
        });
        //endregion

        //region BackButton
        Button backToPlaceButton = findViewById(R.id.back_button_1);
        backToPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaffActivity.this.finish();
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
                intentRecommend.putExtra("positionForRecommendedPark",getRecommendedParkPosition);
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

        //region InfoButton
        Button infoButton = findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffActivity.this, Information.class);
                intent.putExtra("positionForInfo", positionOfStaff);
                intent.putExtra("positionOfPlaceForInfo", getPosition);
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


