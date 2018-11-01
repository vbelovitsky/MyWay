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
        final CustomAdapter customAdapter = new CustomAdapter(this);
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

        //region MuseumsButton
        Button museumsButton = findViewById(R.id.museums);
        museumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfPlaces.setAdapter(customAdapter);
                listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Intent intentPlace = new Intent(MainActivity.this, PlaceActivity.class);
                        intentPlace.putExtra("positionForPlace", position);
                        startActivity(intentPlace);
                    }
                });
            }
        });
        //endregion

        //region ParksButton
        Button parksButton = findViewById(R.id.parks);
        parksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParksAdapter parksAdapter = new ParksAdapter();
                listOfPlaces.setAdapter(parksAdapter);
                listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Intent intentPark = new Intent(MainActivity.this, ParkActivity.class);
                        intentPark.putExtra("positionForPark", position);
                        startActivity(intentPark);
                    }
                });
            }
        });
        //endregion

        //region TheatresButton
        Button theatresButton = findViewById(R.id.theatres);
        theatresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheatresAdapter theatresAdapter = new TheatresAdapter();
                listOfPlaces.setAdapter(theatresAdapter);
                listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Intent intentTheatre = new Intent(MainActivity.this, TheatreActivity.class);
                        intentTheatre.putExtra("positionForTheatre", position);
                        startActivity(intentTheatre);
                    }
                });
            }
        });
        //endregion
    }

    //region MuseumsAdapter
    class CustomAdapter extends BaseAdapter{

        //region Var
        private Staff staff = new Staff();
        private SharedPreferences spscores;
        private String[] placeNames = getResources().getStringArray(R.array.place_names_array);
        private String[] placeScores = new String[placeNames.length];
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
        public int getCount() {return placeImages.length;}
        @Override
        public Object getItem(int position) {return null;}
        @Override
        public long getItemId(int position) {return 0;}
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

    //region ParksAdapter
    class ParksAdapter extends  BaseAdapter{

        private  String[] parksNames = getResources().getStringArray(R.array.parks_names_array);
        private int[] parksImages = {
                R.drawable.park_sa,
                R.drawable.park_sb,
                R.drawable.park_sc,
                R.drawable.park_sd,
                R.drawable.park_se,
                R.drawable.park_sf,
                R.drawable.park_sg,
                R.drawable.park_sh,
                R.drawable.park_si,};
        @Override
        public int getCount() {return parksNames.length;}

        @Override
        public Object getItem(int position) {return null;}

        @Override
        public long getItemId(int position) {return 0;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.parks_custom_item, null);
            TextView parkName = convertView.findViewById(R.id.park_item_text);
            ImageView parkImage = convertView.findViewById(R.id.park_item_image);

            parkName.setText(parksNames[position]);
            parkImage.setImageResource(parksImages[position]);
            return convertView;
        }
    }
    //endregion

    //region TheatresAdapter
    class TheatresAdapter extends BaseAdapter{
        private String[] theatresNames = getResources().getStringArray(R.array.theatres_name_array);
        private  int[] theatresImages = {
                R.drawable.the_sa,
                R.drawable.the_sb,
                R.drawable.the_sc,
                R.drawable.the_sd,
                R.drawable.the_se,
                R.drawable.the_sf,
                R.drawable.the_sg,
                R.drawable.the_sh,
                R.drawable.the_si,
        };
        @Override
        public int getCount() {return theatresNames.length;}

        @Override
        public Object getItem(int position) {return null;}

        @Override
        public long getItemId(int position) {return 0;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.theatres_custom_item, null);
            TextView theatreName = convertView.findViewById(R.id.theatre_item_text);
            ImageView theatreImage = convertView.findViewById(R.id.theatre_item_image);

            theatreName.setText(theatresNames[position]);
            theatreImage.setImageResource(theatresImages[position]);
            return convertView;
        }
    }
    //endregion


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }


}
