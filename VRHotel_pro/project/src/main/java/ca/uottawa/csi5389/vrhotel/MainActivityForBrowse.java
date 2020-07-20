package ca.uottawa.csi5389.vrhotel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ca.uottawa.csi5389.vrhotel.adapter.Myadapter;
import ca.uottawa.csi5389.vrhotel.dao.VRItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityForBrowse extends Activity {

    private Context context;
    private ListView lv;
    ArrayList<Map<String, String>> mData = new ArrayList<Map<String, String>>();

    Myadapter mBaseAdapter;

    ArrayList<String> mListTitle = new ArrayList<String>();
    ArrayList<String> mListText = new ArrayList<String>();
    ArrayList<String> mListImage = new ArrayList<String>();

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main_for_browse);
        initView();
    }

    private void getmData(ArrayList<Map<String, String>> mDatas) {

        VRItem vrHotel = new VRItem();
        String[] hotelName = vrHotel.getHotelName();
        String[] hoteDescription = vrHotel.getStringbasicHotelDescription();
        String[] hotelImagegroup = vrHotel.getImagegroupII();
        int i = 0;
        while (i < hotelName.length) {
            mListTitle.add(hotelName[i]);
            mListText.add(hoteDescription[i]);
            mListImage.add(hotelImagegroup[i]);
            Map<String, String> item = new HashMap<String, String>();
            item.put("title", mListTitle.get(i));
            item.put("text", mListText.get(i));
            item.put("image", mListImage.get(i));
            mDatas.add(item);
            i++;
        }
    }

    public void initView() {
        lv = (ListView) findViewById(R.id.list);
        getmData(mData);
        mBaseAdapter = new Myadapter(getApplicationContext(), mData);
        lv.setAdapter(mBaseAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
