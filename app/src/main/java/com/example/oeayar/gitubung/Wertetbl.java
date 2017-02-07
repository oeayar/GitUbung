package com.example.oeayar.gitubung;

/**
 * Created by ozgeayar on 07.02.17.
 */

public class Wertetbl {
    public static final String TABLE_NAME="Werte";

    public static final String Breite="breite";
    public static final String ID="id";
    public static final String Länge="länge";
    public static final String Datum="datum";

  //  public static final String [] ALL_COLUMNS=new String[]{Breite + Länge + Datum};

    public static final String SQL_DROP= "DROP TABLE IF EXISTS" + TABLE_NAME;


    public static final String SQL_CREATE=
            "CREATE TABLE " + TABLE_NAME +
                    "("+
                    ID + " INTEGER PRIMARY KEY, "+
                    Breite+ " DOUBLE NOT NULL, "+
                    Länge + " DOUBLE NOT NULL, "+
                    Datum +" VARCHAR2 NOT NULL "+
            ")";


    public static final String STMT_INSERT=
            "INSERT INTO " + TABLE_NAME +
                    "( "+ ID +", "+ Breite + ", " +Länge + ", " +Datum + ") " +
                    "VALUES(?,?,?,?)";

}
