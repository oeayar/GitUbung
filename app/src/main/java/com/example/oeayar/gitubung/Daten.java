package com.example.oeayar.gitubung;

import java.util.Date;

/**
 * Created by ozgeayar on 07.02.17.
 */

public class Daten {

    double breite;
    double länge;
    String datum;

    public Daten() {
    }

    public Daten(double breite, double länge, String datum) {
        this.breite = breite;
        this.länge = länge;
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Daten{" +
                "breite=" + breite +
                ", länge=" + länge +
                ", datum='" + datum + '\'' +
                '}';
    }
}
