package com.example.user.myway;

import android.app.Application;
import android.content.Context;

public class Park extends Application {
        private Context context;

        private String[] parksDescArray;
        private  String[] parksWebArray;
        private String[] parksAddressesArray;
        private int[] parksImagesArray = {
                R.drawable.par_a,
                R.drawable.par_b,
                R.drawable.par_c,
                R.drawable.par_d,
                R.drawable.par_e,
                R.drawable.par_f,
                R.drawable.par_g,
                R.drawable.par_h,
                R.drawable.par_i,
        };
        private String parkDesc = "";
        private String parkWeb = "";
        private String parkAddress = "";
        private int parkImage = 0;

        public Park(Context current, int position){
            this.context = current;

            parksDescArray = context.getResources().getStringArray(R.array.parks_descriptions_array);
            parksWebArray = context.getResources().getStringArray(R.array.parks_web_array);
            parksAddressesArray = context.getResources().getStringArray(R.array.parks_addresses_array);

            parkImage = parksImagesArray[position];
            parkDesc = parksDescArray[position];
            parkWeb = parksWebArray[position];
            parkAddress = parksAddressesArray[position];
        }

        public int getParkImage() {return parkImage;}

        public String getParkDesc() {return parkDesc;}

        public String getParkWeb() {return parkWeb;}

        public String getParkAddress() {return parkAddress;}
}
