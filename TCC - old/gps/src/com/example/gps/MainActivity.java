package com.example.gps;

import prakash.work.trackmobile.R;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity{

TextView longi;
TextView lat;
TextView tv;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    longi=(TextView) findViewById(R.id.longi);
    lat=(TextView) findViewById(R.id.lat);
    tv=(TextView) findViewById(R.id.tv);

    LocationListener ll=new myLocationListener();
    LocationManager lm=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);


  }
  class myLocationListener implements LocationListener{

    public void onLocationChanged(Location arg0) {
        if(arg0 != null)
        {
            try{

            tv.setText("Working");
            double plongi=arg0.getLongitude();
            double plat=arg0.getLatitude();

            longi.setText(Double.toString(plongi));
            lat.setText(Double.toString(plat));
            }
            catch(Exception e)
            {
                Log.e("Error", "Error1");
            }
        }

    }

    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub
                }

    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub

    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub

    }

}
}
