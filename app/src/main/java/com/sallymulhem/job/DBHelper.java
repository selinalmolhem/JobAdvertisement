package com.sallymulhem.job;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "job";
    private static final int DB_VERSION = 2;
    private static final String KUrum_TABLE = "KURUM_ilan";
    public static final String R0W_ID = "id";
    public static final String  ROW_AD= "ad";
    public static final String ROW_TEL = "tel";
    public static final String ROW_ACIKLAMA= "acıklama";
    public static final String ROW_ADRESS= "adress";
    public static final String ROW_OZELİKLER = "ozelıkler";
    public static final String ROW_ZAMMAN = "zaman";
    public static final String ROW_MAAS = "maas";
    //çalışan
    private static final String calısan_TABLE = "calısan_ilan";
    public static final String calısan_ID = "id";
    public static final String calısan_ad = "ad";
    public static final String calısan_bolum = "bolum";
    public static final String calısan_tel = "tel";
    public static final String calısan_yas = "yas";
    public static final String calısan_deneyimler = "deneymler";
    public static final String calısan_kurslar = "kurslar";








    public DBHelper(Context context) {
        super(context, DBNAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users(username TEXT primary key, password TEXT)");
       //MyDB.execSQL("create Table KURUM_ilan(Ad TEXT, Adress TEXT, Acıklama TEXT, tel TEXT, ozelıkler TEXT, zaman TEXT, maas TEXT)");
        db.execSQL("create Table calısan_ilan(Ad TEXT, bolum TEXT, tel TEXT, yas int, deneymler TEXT, kurslar TEXT)");

        // MyDB.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ R0W_ID+" INTEGER primary key, "+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER)");
        db.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER)");


    }
    public void VeriEkle(String Ad,String Adress,String Acıklama,String tel,String ozelıkler,int zaman,int maas){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(ROW_AD,Ad.trim());
        cv.put(ROW_ADRESS,Adress.trim());
        cv.put(ROW_ACIKLAMA,Acıklama.trim());
        cv.put(ROW_TEL,tel.trim());
        cv.put(ROW_OZELİKLER,ozelıkler.trim());
        cv.put(ROW_ZAMMAN,zaman);
        cv.put(ROW_MAAS,maas);
        db.insert(KUrum_TABLE,null, cv);
        db.close();
    }
    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {ROW_AD,ROW_ADRESS,ROW_ACIKLAMA,ROW_TEL,ROW_OZELİKLER,ROW_ZAMMAN,ROW_MAAS};
        Cursor cursor = db.query(KUrum_TABLE , sutunler ,null , null , null , null , null );
        while (cursor.moveToNext()){
            veriler.add("Ad : "+cursor.getString(0)+"\nAdress : "+cursor.getString(1)+"\nAçıklama : "+cursor.getString(2)+"\nTel : "+cursor.getString(3)+"\nİstenlen : "+cursor.getString(4)+"\nZamman : "+cursor.getInt(5)+"\nMaaş : "+cursor.getInt(6));
        }
        /*String query = "SELECT * FROM "+KUrum_TABLE;
       db.rawQuery()*/
        return veriler;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists "+KUrum_TABLE);
        db.execSQL("drop Table if exists "+calısan_TABLE);
        onCreate( db);

    }
    public void VeriEkle1(String Ad,String bolum,String tel,int yas,String deneymler,String kurslar){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(calısan_ad,Ad.trim());
        cv.put(calısan_bolum,bolum.trim());
        cv.put(calısan_tel,tel.trim());
        cv.put(calısan_yas,yas);
        cv.put(calısan_deneyimler,deneymler.trim());
        cv.put(calısan_kurslar,kurslar.trim());
        db.insert(calısan_TABLE,null, cv);
        db.close();
    }
    public List<String> VeriListele1(){
        List<String> veriler1 = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler1 = {calısan_ad,calısan_bolum,calısan_tel,calısan_yas,calısan_deneyimler,calısan_kurslar};
        Cursor cursor = db.query(calısan_TABLE , sutunler1 ,null , null , null , null , null );
        while (cursor.moveToNext()){
            veriler1.add("AD : "+cursor.getString(0)+"\nbolum : "+cursor.getString(1)+"\ntel : "+cursor.getString(2)+"\nyas : "+cursor.getInt(3)+"\ndeneyimler : "+cursor.getString(4)+"\nkurslar : "+cursor.getString(5));
        }
        /*String query = "SELECT * FROM "+KUrum_TABLE;
       db.rawQuery()*/
     //   System.out.println("ufhhhfuufcdkjkjkckccmcöckckkdkld**d*d*d**d**********************d*d**d*d*d*dd*d*d*d*d*d*d*d**f*f*f*f**rr*r**f*f**c**c*d**dd*d*d**d*d*dd**d*dd*d*d**d*d*d**dd**d*d*d**dd**dd**d*d*dd**d*d**d*d*d*d");
        return veriler1;

    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

