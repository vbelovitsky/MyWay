package com.example.user.myway;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;


public class Staff extends Application {
    private Context context;
    SharedPreferences savedAnswers;
    SharedPreferences.Editor editorAnswers;
    //region Var
    private int [][] staffImages = {
            {       R.drawable.crown,
                    R.drawable.helmet,
                    R.drawable.map,
                    R.drawable.skull,
                    R.drawable.sword,
                    R.drawable.trophy,
                    R.drawable.shield,
                    R.drawable.picture,
                    R.drawable.bible,
                    R.drawable.jesus,
                    R.drawable.sabre,
                    R.drawable.bowl,
                    R.drawable.goldpot,
                    R.drawable.chess,
                    R.drawable.coins,
                    R.drawable.vase,
                    R.drawable.tallvase,
                    R.drawable.rosevase,
                    R.drawable.writing,
                    R.drawable.liza,
                    R.drawable.pocket,
                    R.drawable.treasure,
                    R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.bible, R.drawable.jesus, R.drawable.sabre, R.drawable.bowl, R.drawable.goldpot, R.drawable.chess, R.drawable.coins, R.drawable.vase, R.drawable.tallvase, R.drawable.rosevase, R.drawable.writing, R.drawable.liza, R.drawable.pocket, R.drawable.treasure, R.drawable.diamond},
    };

    private  String [][] answersArray = {
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
            {"crown","helmet","map","skull","sword","trophy","shield","picture","bible","jesus","sabre","bowl","goldpot","chess","coins","vase","tallvase","rosevase","writing","liza","pocket","treasure","diamond"},
    };

    private int [] currentImages;
    private String [] currentAnswers;
    private ArrayList<String> currentCompletedAnswers;
//endregion

    public Staff(Context current, int position){
        this.context = current;

        savedAnswers = context.getSharedPreferences("SavedAnswers"+position, MODE_PRIVATE);
        editorAnswers = savedAnswers.edit();

        currentImages = staffImages[position];
        currentAnswers = answersArray[position];
    }
    public Staff(){

    }
    public int getStaffImagesArrayLength(int position){
        return staffImages[position].length;
    }

    public int getStaffImage(int position){return currentImages[position];}
    public String getAnswer(int position){return currentAnswers[position];}
    public int getLength(){return currentImages.length;}

    public void setCurrentCompletedAnswer(int pos, int score){
        editorAnswers.putString("SavedAnswer"+pos, "YES");
        editorAnswers.putString("SavedScore", String.valueOf(score));
        editorAnswers.apply();
    }

    public Boolean checkCurrentCompletedAnswer(int pos){
        if (savedAnswers.getString("SavedAnswer"+pos, "NO").equals("YES")) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    public void resetCurrentCompletedAnswers(){
        for (int pos = 0; pos<currentAnswers.length; pos++)
            editorAnswers.putString("SavedAnswer"+pos, "NO");
        editorAnswers.putString("SavedScore", "0");
        editorAnswers.apply();
    }


}
