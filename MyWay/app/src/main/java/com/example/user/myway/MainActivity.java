package com.example.user.myway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listOfPlaces = (ListView)findViewById(R.id.list_of_places);
        CustomAdapter customAdapter = new CustomAdapter();
        listOfPlaces.setAdapter(customAdapter);

        listOfPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id){
                Intent intentPlace = new Intent(MainActivity.this,PlaceActivity.class);
                intentPlace.putExtra("positionForPlace",position);
                startActivity(intentPlace);
            }
        });
    }

    class CustomAdapter extends BaseAdapter{
        final String[] placeNames = getResources().getStringArray(R.array.place_names_array);
        final int[] placeImages = {
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

            ImageView placeImage = (ImageView)convertView.findViewById(R.id.item_image);
            TextView placeName = (TextView)convertView.findViewById(R.id.item_text);

            placeImage.setImageResource(placeImages[position]);
            placeName.setText(placeNames[position]);

            return convertView;
        }
    }

}
