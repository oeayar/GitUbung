package com.example.oeayar.gitubung;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ozgeayar on 01.02.17.
 */

public class Verbindung_DB extends SQLiteOpenHelper {

    private final static String TAG= "Datenbank";
    private final static String DB_NAME="daten.db";
    private final static int DB_VERSION=2;

    public Verbindung_DB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(TAG, "Verbindung Datenbank Konstruktur");
    }



    public Verbindung_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);

    }

    public Verbindung_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "-------> onCreate Verbindung Datenbank");
        db.execSQL(Wertetbl.SQL_CREATE);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "-------> onUpgrade Datenbank Verbindung: Version "+ oldVersion+ "--->"+newVersion);
        db.execSQL(Wertetbl.SQL_DROP);
        onCreate(db);
    }
}
