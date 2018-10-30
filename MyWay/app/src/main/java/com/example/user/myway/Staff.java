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
            {R.drawable.tre_a, R.drawable.tre_b, R.drawable.tre_c, R.drawable.tre_d, R.drawable.tre_e, R.drawable.tre_f, R.drawable.tre_g, R.drawable.tre_h, R.drawable.tre_i, R.drawable.tre_j, R.drawable.tre_k, R.drawable.tre_l, R.drawable.tre_m, R.drawable.tre_n, R.drawable.tre_o, R.drawable.tre_p},
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
            {"ЩЕДРИН НОВЫЙ РИМ","БРЮЛЛОВ ВСАДНИЦА","ИВАНОВ ЯВЛЕНИЕ МЕССИИ","СОРОКИН НИЩАЯ ДЕВОЧКА-ИСПАНКА","ПЕРОВ ТРОЙКА","ПЕРОВ ОХОТНИКИ НА ПРИВАЛЕ","ВАСИЛЬЕВ ВОЛЖСКИЕ ЛАГУНЫ","ПУКИРЕВ НЕРАВНЫЙ БРАК","ФЛАВИЦКИЙ КНЯЖНА ТАРАКАНОВА","САВРАСОВ ГРАЧИ ПРИЛЕТЕЛИ","АЙВАЗОВСКИЙ РАДУГА","КРАМСКОЙ НЕИЗВЕСТНАЯ","ШИШКИН УТРО В СОСНОВОМ ЛЕСУ","ВАСНЕЦОВ БОГАТЫРИ","ВЕРЕЩАГИН АПОФЕОЗ ВОЙНЫ","БОГОЛЮБОВ КАТАНИЕ НА НЕВЕ"},
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
