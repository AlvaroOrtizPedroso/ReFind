package com.example.refind;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class perfinAnunciante extends FragmentActivity implements OnMapReadyCallback {
    /**
     *          Apuntes
     *    En esta Activity creare y mapeare los datos de cada servicio (Se usara la misma activity pero cambiando los datos)
     *    En el metodo onMapReady esta mapeado un ejemplo
     *    Videos para seguir con el mapa
     *      https://www.youtube.com/watch?v=YNM_-cR9QKQ&t=354s
     *      https://www.youtube.com/watch?v=3-84hvpb_zA (El final)
     *      Para las coordenadas igual uso un metodo creado para el proyecto de DAW
     *
     */
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfin_anunciante);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Ataulfo = new LatLng(43.3792172, -3.2171374);
        mMap.addMarker(new MarkerOptions().position(Ataulfo).title("IES Ataulfo Argenta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ataulfo));
    }
}