package com.example.user.myway;

import android.app.Application;
import android.content.Context;

public class Recommend extends Application {
    //region Var
    private Context context;

    private int[] cafeImages = {
            R.drawable.caa_festcafe,
            R.drawable.cab_mcdac,
            R.drawable.cac_festcafe,
            R.drawable.cad_teremok,
            R.drawable.cae_burgerking,
            R.drawable.caf_nookcoffee,
            R.drawable.cag_burgerking,
            R.drawable.cah_darvincafe,
            R.drawable.cai_paleomus,
            R.drawable.caj_burgerking,
            R.drawable.cak_burgerking,
            R.drawable.cal_tretiakcafe
    };
    private int[] mapImages = {
            R.drawable.rec_a,
            R.drawable.rec_b,
            R.drawable.rec_c,
            R.drawable.rec_d,
            R.drawable.rec_e,
            R.drawable.rec_f,
            R.drawable.rec_g,
            R.drawable.rec_h,
            R.drawable.rec_i,
            R.drawable.rec_j,
            R.drawable.rec_k,
            R.drawable.rec_l,
    };
    private String [] cafeNames;
    private String [] cafeAddresses;
    private String [] cafeDescs;

    private int cafeImage;
    private int mapImage;
    private String cafeName;
    private String cafeAddress;
    private String cafeDesc;
    //endregion

    public Recommend(Context current, int position){
        this.context = current;

        cafeNames = context.getResources().getStringArray(R.array.cafe_array);
        cafeAddresses = context.getResources().getStringArray(R.array.cafeaddresses_array);
        cafeDescs = context.getResources().getStringArray(R.array.food_array);

        mapImage = mapImages[position];
        cafeImage = cafeImages[position];
        cafeName = cafeNames[position];
        cafeAddress = cafeAddresses[position];
        cafeDesc = cafeDescs[position];
    }

    public int getMapImage(){return mapImage;}
    public int getCafeImage(){return cafeImage;}
    public String getCafeName(){return cafeName; }
    public String getCafeAddress(){return cafeAddress; }
    public String getCafeDesc(){return cafeDesc;}
}
