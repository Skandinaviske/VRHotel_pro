package ca.uottawa.csi5389.vrhotel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.uottawa.csi5389.vrhotel.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ca.uottawa.csi5389.vrhotel.dao.VRItem;

import java.util.Map;

import androidx.fragment.app.Fragment;

/**
 * GalleryFragment is the fragment to set up the grid images in the DetailActivity.
 *
 * @param googleMap  the parameter is used to set the Google maps.
 * @param positionId the hotel id.
 */

//Reference: https://stackoverflow.com/questions/22032815/how-to-get-google-maps-object-inside-a-fragment
public class LocationFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    private int positionId;
    private TextView textViewAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        //Get the position id from the current activity.
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            positionId = Integer.parseInt(bundle.getString("key"));
        }

        textViewAddress = rootView.findViewById(R.id.text_address);
        textViewAddress.setText(new VRItem().getStringHotelAddress()[positionId - 1]);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                Map<Integer, Integer[]> temLat = new VRItem().getMapHotelLatitudeandLongitude();
                LatLng sydney = new LatLng(temLat.get(positionId)[0], temLat.get(positionId)[1]);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}