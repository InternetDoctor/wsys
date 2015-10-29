package com.gdcc.wsyy;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.gdcc.wsyy.R;
import com.gdcc.wsyy.R.id;
import com.gdcc.wsyy.R.layout;

import android.R.integer;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class NearbyMapActivity extends Activity implements LocationSource,AMapLocationListener{
	
	private MapView mapView; 
	private AMap aMap;
	private double longitude;
	private double latitude;

	
	private LocationManagerProxy mAMapLocManager = null;
	private OnLocationChangedListener mlistener;
	private LocationManagerProxy mLocationManagerProxy;
	

   @Override
   protected  void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.search_city);
	
	   mapView =(MapView)findViewById(R.id.search_mymap);
	   mapView.onCreate(savedInstanceState);
	   init();

   }
   
   
   private void init(){
	   if(aMap==null){
		   aMap=mapView.getMap();
		   setUpMap();
	   }
   }
  
   @Override
   protected void onResume(){
	  
	   super.onResume();
	   mapView.onResume();
	   initlocationManager();
   }
   
   @Override
   protected void onPause(){
	   super.onPause();
	   mapView.onPause();
   }
   
   @Override
   protected void onDestroy(){
	  // stopLocation();
	   super.onDestroy();
	   mapView.onDestroy();
   }
   
   private void initlocationManager(){
	   if(mLocationManagerProxy==null){
		   mLocationManagerProxy=LocationManagerProxy.getInstance(this);
		   
		  // LocationManagerProxy.GPS_PROVIDER; 基于GPS定位
		  //LocationManagerProxy.NETWORK_PROVIDER;基于网络定位
		  //LocationProviderProxy.AMapNetwork;混合定位
		   
		   String provider = LocationManagerProxy.GPS_PROVIDER;
		   int minTime = 60*1000;
		   int minDistance = 15;
		   
		   mLocationManagerProxy.requestLocationData(provider, minTime, minDistance, this);
		   mLocationManagerProxy.setGpsEnable(true);
	   }
   }
   
   private void stopLocation(){
	   if(mLocationManagerProxy==null){
		   mLocationManagerProxy.removeUpdates(this);
		   mLocationManagerProxy.destroy();
	   }
	   mLocationManagerProxy = null;
   }
   
   private void setUpMap(){
		/*if(aMap==null){
			   aMap = mapView.getMap();
			   aMap.setLocationSource(this);
			   aMap.setMyLocationEnabled(true);
		   }//启动定位按钮
         */
		
	   aMap.setLocationSource(this);
	   aMap.getUiSettings().setMyLocationButtonEnabled(true);
	   aMap.setMyLocationEnabled(true);
   }
   
   
   protected  void onSavedInstanceState(Bundle outState){
	   super.onSaveInstanceState(outState);
   }

@Override
public void activate(OnLocationChangedListener listener) {
	initlocationManager();
	if(mAMapLocManager==null){
		mlistener = listener;
		mAMapLocManager = LocationManagerProxy.getInstance(this);
		mAMapLocManager.requestLocationData( LocationProviderProxy.AMapNetwork, 5000, 10, this);
	}

}

@Override
public void deactivate() {
	// TODO Auto-generated method stub
	//stopLocation();
}

@Override
public void onLocationChanged(Location arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderDisabled(String arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderEnabled(String arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
	// TODO Auto-generated method stub
	
}

@Override
public void onLocationChanged(AMapLocation location) {
	/*if(location!=null){
		if(location.getAMapException().getErrorCode()==0){
			Toast.makeText(this,"经度："+location.getLatitude()+"纬度："+location.getLongitude(), Toast.LENGTH_LONG).show();
		}
		
	}*/
	
	
	if(location!=null){
		longitude = location.getLongitude();
		latitude = location.getLatitude();
		mlistener.onLocationChanged(location);
		Log.i("TAG", "经度和纬度是"+longitude+","+latitude);
	}
	
}

}
