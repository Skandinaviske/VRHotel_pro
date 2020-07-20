package ca.uottawa.csi5389.vrhotel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import ca.uottawa.csi5389.vrhotel.adapter.Myadapter;
import ca.uottawa.csi5389.vrhotel.dao.VRItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * MainActivity is the activity to show the basic information of the hotels.
 */

public class MainActivity extends Activity {

    private ListView lv;
    ArrayList<Map<String, String>> mData = new ArrayList<Map<String, String>>();

    Myadapter mBaseAdapter;

    ArrayList<String> mListTitle = new ArrayList<String>();
    ArrayList<String> mListText = new ArrayList<String>();
    ArrayList<String> mListImage = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set_eSearch_TextChanged();//Set Search Listener
        set_ivDeleteText_OnClick();//Set Listener for X
        initView();
    }

    //get match datas from the list view (initialize the search data).
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

    EditText eSearch;
    ImageView ivDeleteText;
    Handler myhandler = new Handler();

    //Set up the dynamic search listener.
    //Reference: https://blog.csdn.net/zheng_jiao/article/details/51473051
    private void set_eSearch_TextChanged() {
        eSearch = (EditText) findViewById(R.id.etSearch);
        eSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if (s.length() == 0) {
                    ivDeleteText.setVisibility(View.GONE);
                    myhandler.post(eChanged);
                } else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                    myhandler.post(eChanged);
                }
            }
        });
    }

    Runnable eChanged = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            // based on http://www.jeepxie.net/article/542356.html
            String data = eSearch.getText().toString();
            mData.clear();
            getmDataSub(mData, data);
            mBaseAdapter.notifyDataSetChanged();
        }
    };

    //Set delete button listener.
    private void set_ivDeleteText_OnClick() {
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        ivDeleteText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                eSearch.setText("");
            }
        });
    }

    //Get the match data.
    private void getmDataSub(ArrayList<Map<String, String>> mDataSubs, String data) {
        int length = mListTitle.size();
        for (int i = 0; i < length; ++i) {
            if (mListTitle.get(i).toLowerCase().contains(data.toLowerCase()) || mListText.get(i).toLowerCase().contains(data.toLowerCase())) {
                Map<String, String> item = new HashMap<String, String>();
                item.put("title", mListTitle.get(i));
                item.put("text", mListText.get(i));
                item.put("image", mListImage.get(i));
                mDataSubs.add(item);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
