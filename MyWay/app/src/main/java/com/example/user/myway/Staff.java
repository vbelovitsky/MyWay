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
            //region gim
            {       R.drawable.gim_a,
                    R.drawable.gim_b,
                    R.drawable.gim_c,
                    R.drawable.gim_d,
                    R.drawable.gim_e,
                    R.drawable.gim_f,
                    R.drawable.gim_g,
                    R.drawable.gim_h,
                    R.drawable.gim_i,
                    R.drawable.gim_j,
                    R.drawable.gim_k,
                    R.drawable.gim_l,
                    R.drawable.gim_m,
                    R.drawable.gim_n,
                    R.drawable.gim_o,
                    R.drawable.gim_p,
                    R.drawable.gim_q,
                    R.drawable.gim_r,
                    R.drawable.gim_s,
                    R.drawable.gim_t,
                    R.drawable.gim_u,
                    R.drawable.gim_v,
                    R.drawable.gim_w,},
            //endregion
            //region tre
            {R.drawable.tre_a,
                    R.drawable.tre_b,
                    R.drawable.tre_c,
                    R.drawable.tre_d,
                    R.drawable.tre_e,
                    R.drawable.tre_f,
                    R.drawable.tre_g,
                    R.drawable.tre_h,
                    R.drawable.tre_i,
                    R.drawable.tre_j,
                    R.drawable.tre_k,
                    R.drawable.tre_l,
                    R.drawable.tre_m,
                    R.drawable.tre_n,
                    R.drawable.tre_o,
                    R.drawable.tre_p},
            //endregion
            //region kre
            {R.drawable.kre_a,
                    R.drawable.kre_b,
                    R.drawable.kre_c,
                    R.drawable.kre_d,
                    R.drawable.kre_e,
                    R.drawable.kre_f,
                    R.drawable.kre_g,},
            //endregion
            //region pus
            {R.drawable.pus_a,
                    R.drawable.pus_b,
                    R.drawable.pus_c,
                    R.drawable.pus_d,
                    R.drawable.pus_e,
                    R.drawable.pus_f,
                    R.drawable.pus_g,
                    R.drawable.pus_h,
                    R.drawable.pus_i,
                    R.drawable.pus_j,
                    R.drawable.pus_k,
                    R.drawable.pus_l,
                    R.drawable.pus_m,
                    R.drawable.pus_n,
                    R.drawable.pus_o,
                    R.drawable.pus_p,
                    R.drawable.pus_q,
                    R.drawable.pus_r,
                    R.drawable.pus_s,
                    R.drawable.pus_t,
                    R.drawable.pus_u,
                    R.drawable.pus_v,},
            //endregion
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.sabre, R.drawable.bowl},
            //region rus
            {R.drawable.rus_a,
                    R.drawable.rus_b,
                    R.drawable.rus_c,
                    R.drawable.rus_d,
                    R.drawable.rus_e,
                    R.drawable.rus_f,
                    R.drawable.rus_g,
                    R.drawable.rus_h,
                    R.drawable.rus_i,
                    R.drawable.rus_j,
                    R.drawable.rus_k,
                    R.drawable.rus_l,},
            //endregion
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.sabre, R.drawable.bowl},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.sabre, R.drawable.bowl},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.sabre, R.drawable.bowl},
            {R.drawable.crown, R.drawable.helmet, R.drawable.map, R.drawable.skull, R.drawable.sword, R.drawable.trophy, R.drawable.shield, R.drawable.picture, R.drawable.sabre, R.drawable.bowl},
            //region zoo
            {R.drawable.zoo_a,
                    R.drawable.zoo_b,
                    R.drawable.zoo_c,
                    R.drawable.zoo_d,
                    R.drawable.zoo_e,
                    R.drawable.zoo_f,
                    R.drawable.zoo_g,
                    R.drawable.zoo_h,
                    R.drawable.zoo_i,
                    R.drawable.zoo_j,
                    R.drawable.zoo_k,
                    R.drawable.zoo_l,
                    R.drawable.zoo_m,
                    R.drawable.zoo_n,},
            //endregion
            //region nov
            {R.drawable.nov_a,
                    R.drawable.nov_b,
                    R.drawable.nov_c,
                    R.drawable.nov_d,
                    R.drawable.nov_e,
                    R.drawable.nov_f,
                    R.drawable.nov_g,
                    R.drawable.nov_h,
                    R.drawable.nov_i,}
            //endregion
    };

    private  String [][] answersArray = {
            //region agim
            {"ИДОЛ",
                    "ДОЛЬМЕН КОЛИХО",
                    "ФИГУРКИ ЛОШАДЕЙ И ГРИФОНА",
                    "ПЛАСТИНА С ИЗОБРАЖЕНИЯМИ ЖИВОТНЫХ",
                    "ЗЕРКАЛО",
                    "БУСЫ",
                    "КОЛЬЦО",
                    "ГУННСКИЙ КОТЕЛ",
                    "МИСКА ДВОЙНАЯ",
                    "ФЛАКОН ДЛЯ ДУХОВ",
                    "ПАПКА",
                    "ЕВАНГЕЛИЕ В ОКЛАДЕ",
                    "ПРЕДМЕТЫ ВООРУЖЕНИЯ, СНАРЯЖЕНИЕ КОНЯ И ВСАДНИКА",
                    "РЕКОНСТРУКЦИЯ ПОЯСА",
                    "ПРЕДМЕТЫ ВООРУЖЕНИЯ РУССКОГО ВОИНА",
                    "КУБОК-ПЕТУХ",
                    "ЦАРСКИЕ ВРАТА","СУНДУК-ПОДГОЛОВОК",
                    "МИТРА",
                    "КИРАСА ОФИЦЕРСКАЯ ЛЕЙБ-ГВАРДИИ КОННОГО ПОЛКА",
                    "ЧАСЫ-РОТАТОР",
                    "БОГОМАТЕРЬ",
                    "КАРЕТА ДЕТСКАЯ"},
            //endregion
            //region atre
            {"ЩЕДРИН НОВЫЙ РИМ",
                    "БРЮЛЛОВ ВСАДНИЦА",
                    "ИВАНОВ ЯВЛЕНИЕ МЕССИИ",
                    "СОРОКИН НИЩАЯ ДЕВОЧКА-ИСПАНКА",
                    "ПЕРОВ ТРОЙКА",
                    "ПЕРОВ ОХОТНИКИ НА ПРИВАЛЕ",
                    "ВАСИЛЬЕВ ВОЛЖСКИЕ ЛАГУНЫ",
                    "ПУКИРЕВ НЕРАВНЫЙ БРАК",
                    "ФЛАВИЦКИЙ КНЯЖНА ТАРАКАНОВА",
                    "САВРАСОВ ГРАЧИ ПРИЛЕТЕЛИ",
                    "АЙВАЗОВСКИЙ РАДУГА",
                    "КРАМСКОЙ НЕИЗВЕСТНАЯ",
                    "ШИШКИН УТРО В СОСНОВОМ ЛЕСУ",
                    "ВАСНЕЦОВ БОГАТЫРИ",
                    "ВЕРЕЩАГИН АПОФЕОЗ ВОЙНЫ",
                    "БОГОЛЮБОВ КАТАНИЕ НА НЕВЕ"},
            //endregion
            //region akre
            {"ОРУЖЕЙНАЯ ПАЛАТА",
                    "ПАТРИАРШИЕ ПАЛАТЫ С ЦЕРКОВЬЮ ДВЕНАДЦАТИ АПОСТОЛОВ",
                    "КОЛОКОЛЬНЯ ИВАНА ВЕЛИКОГО",
                    "АРХАНГЕЛЬСКИЙ СОБОР",
                    "ЦАРЬ-ПУШКА",
                    "ЦАРЬ-КОЛОКОЛ",
                    "АРТИЛЛЕРИЙСКИЕ ОРУДИЯ",},
            //endregion
            //region apus
            {"ЭСХИЛ",
                    "ДЕЛЬФИЙСКИЙ ВОЗНИЧИЙ",
                    "МИРОН ДИСКОБОЛ",
                    "ГЕСТИЯ",
                    "ТАНЦОВЩИЦА ИЗ ГЕРКУЛАНУМА",
                    "БЕГУЩАЯ НИКА",
                    "МИКЕЛАНДЖЕЛО БУОНАРРОТИ МАДОННА ИЗ БРЮГГЕ",
                    "МИКЕЛАНДЖЕЛО БУОНАРРОТИ БРУТ",
                    "ДОНАТЕЛЛО АМУР-АТИС",
                    "ЛУКА ДЕЛЛА РОББИЯ ГРОБНИЦА ЕПИСКОПА БЕНОЦЦО ФЕДЕРИГИ",
                    "ДОНАТЕЛЛО ПРОРОК ИЕРЕМИЯ",
                    "АНТОНИО РОССЕЛЛИНО ЮНЫЙ ИОАНН КРЕСТИТЕЛЬ",
                    "БЕНЕДЕТТО ДА МАЙАНО МАДОННА С МЛАДЕНЦЕМ",
                    "ЦЕРКОВЬ",
                    "ТУЛЛИО ЛОМБАРДИ ГРОБНИЦА ГВИДАРЕЛЛО ГВИДАРЕЛЛИ",
                    "ПОРТРЕТ КАРАКАЛЛЫ",
                    "СТАТУЯ АВГУСТА ИЗ ПРИМА ПОРТА",
                    "ЮБЕР РОБЕР САРКОФАГ",
                    "ЖАН-МАРК НАТТЬЕ БИТВА ПРИ ЛЕСНОЙ",
                    "СИМОН ВУЭ БЛАГОВЕЩЕНИЕ",
                    "ЖАН-БАТИСТ МОННУАЙЕ ЦВЕТЫ",
                    "НИКОЛА ПУССЕН РИНАЛЬДО И АРМИДА",},
            //endregion
            {"ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ"},
            //region arus
            {"ТАРХОВ МАМИНА КОМНАТА УТРОМ",
                    "КЛОДТ ЗАРОСШИЙ ПРУД",
                    "ЖУКОВСКИЙ ИНТЕРЬЕР КОМНАТЫ",
                    "ДУБОВСКОЙ НА ЛАГО МАДЖОРЕ",
                    "ИСУПОВ ЗИМНЕЕ СОЛНЦЕ",
                    "ПЕТРОВИЧЕВ ГРОТ В КУСКОВО",
                    "ПИМЕНОВ МОКРЫЕ АФИШИ",
                    "КОНЧАЛОВСКИЙ ВСЯКИЕ ЦВЕТЫ",
                    "БОГДАНОВ-БЕЛЬСКИЙ ЛЕТО",
                    "КУЗНЕЦОВ ПОРТРЕТ МАРУСИ",
                    "РАБИН ПЕЙЗАЖ В ПРИЛУКАХ",
                    "КОРОВИН ЮЖНЫЙ ПЕЙЗАЖ",},
            //endregion
            {"ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ"},
            {"ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ"},
            {"ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ"},
            {"ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ","ТЕСТ"},
            //region azoo
            {"ЛАМА",
                    "КАПИБАРА",
                    "ВИКУНЬЯ",
                    "ЧЕРНЫЙ ЛЕБЕДЬ",
                    "КАЗУАР",
                    "ОБЫКНОВЕННЫЙ ПАВЛИН",
                    "БЕЛОПЛЕЧИЙ ОРЛАН",
                    "БЕЛОГОЛОВЫЙ ОРЛАН",
                    "ГЕПАРД",
                    "ЕВРАЗИЙСКАЯ РЫСЬ",
                    "ОВЦЕБЫК",
                    "ШИЛОКЛЮВКА",
                    "ДАМАН БРЮСА",
                    "ЛОШАДЬ ПРЖЕВАЛЬСКОГО",},
            //endregion
            //region anov
            {"КЛЮН ПРОБЕГАЮЩИЙ ПЕЙЗАЖ",
                    "МАЛЕВИЧ ЧЕРНЫЙ СУПРЕМАТИЧЕСКИЙ КВАДРАТ",
                    "КАНДИНСКИЙ КОМПОЗИЦИЯ VII",
                    "ЛЕНТУЛОВ ЗВОН",
                    "ПЕТРОВ-ВОДКИН КУПАНИЕ КРАСНОГО КОНЯ",
                    "РЕДЬКО ВОССТАНИЕ",
                    "ДЕЙНЕКА БУДУЩИЕ ЛЕТЧИКИ",
                    "ЧЕЛИЩЕВ ФЕНОМЕН",
                    "РОГИНСКИЙ КОММУНАЛЬНАЯ КУХНЯ",
            }
            //endregion
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
