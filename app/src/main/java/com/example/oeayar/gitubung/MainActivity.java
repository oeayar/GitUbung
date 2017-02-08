package com.example.oeayar.gitubung;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static LocationManager locationManager = null;
    private final static String TAG = "";
    LinkedList ll = new LinkedList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnanezigen = (Button) findViewById(R.id.btnanzeigen);

        btnanezigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               geklickt();


            }
        });

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE); //Referenz auf den LocationManager erzeugen

    }

    public void geklickt(){
        Intent intent=new Intent(this, Activity2.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) return;
        displayLocation(location);




    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void displayLocation(Location location) {
        Verbindung_DB verbindung=new Verbindung_DB(this);
        SQLiteDatabase db=verbindung.getReadableDatabase();



        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Date date=new Date();

        TextView breite = (TextView) findViewById(R.id.textView);
        breite.setText(String.format("%.4f", latitude));

        TextView lange = (TextView) findViewById(R.id.textView3);
        lange.setText(String.format("%.4f", longitude));

        TextView datum = (TextView) findViewById(R.id.textView2);
        datum.setText(date.toString());


        Cursor rows=db.rawQuery("SELECT Max(id) FROM Werte ", null);
        rows.moveToNext();
        int id;
        if(rows.getCount()!=-1){

            id= rows.getInt(0);
            id++;
        }else{
            id=0;
        }

        db.execSQL(Wertetbl.STMT_INSERT, new String [] { id+"", breite.getText().toString(), lange.getText().toString(), date.toString()});

    }




}

