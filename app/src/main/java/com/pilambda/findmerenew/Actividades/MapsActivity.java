package com.pilambda.findmerenew.Actividades;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pilambda.findmerenew.Model.MyCoordinates;
import com.pilambda.findmerenew.R;

/**
 * @author Kevin Alexis
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String CORDENADAS_JSON = "coordenadasJson";
    MyCoordinates myCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (getIntent().hasExtra(CORDENADAS_JSON)){
            myCoordinates = (MyCoordinates) getIntent().getSerializableExtra(CORDENADAS_JSON);
        }

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double latitud = 19.436270;
        double longitud = -99.212196;
        LatLng coordenadaPrueba = new LatLng(latitud,longitud);
        mMap.addMarker(new MarkerOptions().position(coordenadaPrueba).title("Esta es una prueba"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadaPrueba,15));

        if (myCoordinates != null){
            LatLng myCurrentLocation = new LatLng(myCoordinates.getLatitud(), myCoordinates.getLongitud());
            mMap.addMarker(new MarkerOptions().position(myCurrentLocation).title("Hola Esime!!!"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myCurrentLocation,15));

        }
    }
}
