package com.example.user.myway;

import android.app.Application;
import android.content.Context;

public class Staff extends Application {
    private Context context;

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

    public Staff(Context current, int position){
        this.context = current;
        currentImages = staffImages[position];
        currentAnswers = answersArray[position];
    }

    public int getStaffImage(int position){
        return currentImages[position];
    }
    public String getAnswer(int position){return currentAnswers[position];}






}
