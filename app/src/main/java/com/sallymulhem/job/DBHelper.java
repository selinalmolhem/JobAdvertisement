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
    public static final String DBNAME = "job";
    public static final int DB_VERSION = 1;
    public static final String KUrum_TABLE = "KURUM_ilan";
    public static final String R0W_ID = "id";
    public static final String  ROW_AD= "ad";
    public static final String ROW_TEL = "tel";
    public static final String ROW_ACIKLAMA= "acıklama";
    public static final String ROW_ADRESS= "adress";
    public static final String ROW_OZELİKLER = "ozelıkler";
    public static final String ROW_ZAMMAN = "zaman";
    public static final String ROW_MAAS = "maas";






    public DBHelper(Context context) {
        super(context, DBNAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table KURUM_ilan(Ad TEXT, Adress TEXT, Acıklama TEXT, tel TEXT, ozelıkler TEXT, zaman TEXT, maas TEXT)");
       // MyDB.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ R0W_ID+" INTEGER primary key, "+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER)");
       // MyDB.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER)");


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
            veriler.add(cursor.getString(0)+"\nAdress : "+cursor.getString(1)+"\nAçıklama : "+cursor.getString(2)+"\nTel : "+cursor.getString(3)+"\nİstelen : "+cursor.getString(4)+"\nZamman : "+cursor.getInt(5)+"\nMaaş : "+cursor.getInt(6));
        }
        /*String query = "SELECT * FROM "+KUrum_TABLE;
       db.rawQuery()*/
        return veriler;
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists "+KUrum_TABLE);
        onCreate( MyDB);

    }
    public Boolean insertcalisan(String isim_soyisim, int Yas ,String Bolum, String Tel ,String aciklama){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("isim_soyisim", isim_soyisim);
        contentValues.put("Yas", Yas);
        contentValues.put("Bolum", Bolum);
        contentValues.put("Tel", Tel);
        contentValues.put("aciklama", aciklama);

        long result = MyDB.insert("calisan", null, contentValues);
        if(result==-1) return false;
        else
            return true;
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

