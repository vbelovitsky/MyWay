package com.example.user.myway;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        //region OptionsButton
        final Button optionsButton = findViewById(R.id.options);
        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsIntent = new Intent(MainActivity.this, Options.class);
                startActivity(optionsIntent);
            }
        });
        //endregion

        final ListView listOfPlaces = findViewById(R.id.list_of_places);
        CustomAdapter customAdapter = new CustomAdapter(this);
        listOfPlaces.setAdapter(customAdapter);

        final TextView progress = findViewById(R.id.progress);
        progress.setText(customAdapter.progressCount(this));


        listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intentPlace = new Intent(MainActivity.this, PlaceActivity.class);
                intentPlace.putExtra("positionForPlace", position);
                startActivity(intentPlace);
            }
        });

    }


    //region MuseumsAdapter
    class CustomAdapter extends BaseAdapter{

        //region Var
        private Staff staff = new Staff();
        private SharedPreferences spscores;
        private String[] placeNames = getResources().getStringArray(R.array.place_names_array);
        private String[]placeScores = new String[placeNames.length];
        private int[] placeImages = {
                R.drawable.baa_historymuseum,
                R.drawable.bab_tretyakovgallery,
                R.drawable.bac_kremlin,
                R.drawable.bad_pushkinmuseum,
                R.drawable.bae_eastmuseum,
                R.drawable.baf_rusimpmuseum,
                R.drawable.bag_minmuseum,
                R.drawable.bah_darwinmuseum,
                R.drawable.bai_paleomuseum,
                R.drawable.baj_planetarium,
                R.drawable.bak_zoo,
                R.drawable.bal_tretyakovval

        };

        CustomAdapter(Context context){
            for (int i = 0; i<placeNames.length; i++) {
                spscores = context.getSharedPreferences("SavedAnswers" + i, MODE_PRIVATE);
                placeScores[i] = spscores.getString("SavedScore", "0");
            }
        }

        public String progressCount(Context context){
            int progressSum = 0;
            for (int i = 0; i<placeNames.length; i++) {
                spscores = context.getSharedPreferences("SavedAnswers" + i, MODE_PRIVATE);
                progressSum += Integer.parseInt(spscores.getString("SavedScore", "0"));
            }
            return String.valueOf(progressSum);
        }

        //endregion
        @Override
        public int getCount() {
            return placeImages.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.main_custom_item, null);

            ImageView placeImage = convertView.findViewById(R.id.item_image);
            TextView placeName = convertView.findViewById(R.id.item_text);
            TextView placeScore = convertView.findViewById(R.id.item_scores);

            placeImage.setImageResource(placeImages[position]);
            placeName.setText(placeNames[position]);
            placeScore.setText(placeScores[position]+"/"+String.valueOf(staff.getStaffImagesArrayLength(position)));

            return convertView;
        }
    }
    //endregion

}
