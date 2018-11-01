package com.example.user.myway;

import android.app.Application;
import android.content.Context;

public class Place extends Application {

    //region Var
    private Context context;

    private String[] webArray;
    private String[] numbersArray;
    private String[] addressesArray;
    private String[] hoursArray;
    private String[] descriptionsArray;
    private String[] ticketsArray;
    private int[] imagesArray =
                   {R.drawable.aaa_historymuseum,
                    R.drawable.aab_tretyakovgallery,
                    R.drawable.aac_kremlin,
                    R.drawable.aad_pushkinmuseum,
                    R.drawable.aae_eastmuseum,
                    R.drawable.aaf_russianimpressionismmuseum,
                    R.drawable.aag_fersmanminmuseum,
                    R.drawable.aah_darvinmuseum,
                    R.drawable.aai_paleontologmuseum,
                    R.drawable.aaj_planetarium,
                    R.drawable.aak_zoo,
                    R.drawable.aal_tretiakkrymval
                    };

    private String web = "";
    private String number = "";
    private String address = "";
    private String hours = "";
    private String description = "";
    private String ticket = "";
    private int image = 0;
    //endregion

    public Place(Context current, int position){
        this.context = current;

        webArray = context.getResources().getStringArray(R.array.websrc_array);
        numbersArray = context.getResources().getStringArray(R.array.numbers_array);
        addressesArray = context.getResources().getStringArray(R.array.addresses_array);
        hoursArray = context.getResources().getStringArray(R.array.hours_array);
        descriptionsArray = context.getResources().getStringArray(R.array.descriptions_array);
        ticketsArray = context.getResources().getStringArray(R.array.tickets_array);

        image = imagesArray[position];
        web = webArray[position];
        address = addressesArray[position];
        number = numbersArray[position];
        hours = hoursArray[position];
        ticket = ticketsArray[position];
        description = descriptionsArray[position];
    }

    public int getImage(){
        return image;
    }
    public String getDescription(){
        return description;
    }
    public String getWeb(){
        return web;
    }
    public String getNumber(){
        return number;
    }
    public String getAddress() {
        return address;
    }
    public String getHours() {
        return hours;
    }
    public String getTicket(){return ticket;}
}
