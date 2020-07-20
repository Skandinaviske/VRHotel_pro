package ca.uottawa.csi5389.vrhotel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.api.widget.Widget;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import ca.uottawa.csi5389.vrhotel.R;
import ca.uottawa.csi5389.vrhotel.UnityLauncher;
import ca.uottawa.csi5389.vrhotel.adapter.ImageAdapter;

import androidx.fragment.app.Fragment;
import ca.uottawa.csi5389.vrhotel.dao.VRItem;

/**
 * GalleryFragment is the fragment to set up the grid images in the DetailActivity.
 *
 * @param positionId get the hotel id from the current activity.
 */

public class GalleryFragment extends Fragment {

    private int positionId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment3, container, false);//用view保存shoppingcar.xml布局，大家可以

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            positionId = Integer.parseInt(bundle.getString("key"));
        }
        GridView gridview = view.findViewById(R.id.gridview);
        ImageAdapter imageAdapter = (new ImageAdapter(getActivity(), positionId, 1));
        gridview.setAdapter(imageAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UnityLauncher.goToUnityUsingID(positionId, position, getActivity());
            }
        });

        GridView gridview2 = view.findViewById(R.id.gridview2);
        ImageAdapter imageAdapter2 = (new ImageAdapter(getActivity(), positionId, 2));
        gridview2.setAdapter(imageAdapter2);
        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] imgid = returnId(positionId, 2);
                previewImages(imgid, 2);
            }
        });

        GridView gridview3 = view.findViewById(R.id.gridview3);
        ImageAdapter imageAdapter3 = (new ImageAdapter(getActivity(), positionId, 3));
        gridview3.setAdapter(imageAdapter3);
        gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] imgid = returnId(positionId, 3);
                previewImages(imgid, 3);
            }
        });

        GridView gridview4 = view.findViewById(R.id.gridview4);
        ImageAdapter imageAdapter4 = (new ImageAdapter(getActivity(), positionId, 4));
        gridview4.setAdapter(imageAdapter4);
        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] imgid = returnId(positionId, 4);
                previewImages(imgid, 4);
            }
        });

        return view;
    }


    private void previewImages(String[] imgid, int positionId) {
        ArrayList<String> imageList = new ArrayList<>();
        Collections.addAll(imageList, imgid);
        String title = "";
        if (positionId == 2) {
            title = "Room and Bathroom";
        } else if (positionId == 3) {
            title = "Lobby";
        } else if (positionId == 4) {
            title = "Dining";
        }

        //Reference: https://github.com/yanzhenjie/Album
        Album.gallery(this)
                .checkedList(imageList) // List of image to view: ArrayList<String>.
                .checkable(false)
                .widget(
                        Widget.newDarkBuilder(getActivity())
                                .title(title)
                                .build()
                )
                .onResult(new Action<ArrayList<String>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<String> result) {

                    }
                })
                .start();
    }

    //This is the function to get the images' url by different hotels and rooms.
    private String[] returnId(int position, int roomNumber) {

        String[] result = {};
        if (position == 1) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel2Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel2Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel2Dining1();
                    break;
                default:
            }
        } else if (position == 2) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel2Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel2Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel2Dining1();
                    break;
                default:
            }
        } else if (position == 3) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel3Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel3Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel3Dining1();
                    break;
                default:
            }
        } else if (position == 4) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel4Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel4Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel4Dining1();
                    break;
                default:
            }
        } else if (position == 5) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel5Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel5Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel5Dining1();
                    break;
                default:
            }
        } else if (position == 6) {
            switch (roomNumber) {
                case 2:
                    result = new VRItem().getImageforHotel6Room();
                    break;
                case 3:
                    result = new VRItem().getImageforHotel6Lobby1();
                    break;
                case 4:
                    result = new VRItem().getImageforHotel6Dining1();
                    break;
                default:
            }
        }
        return result;
    }
}