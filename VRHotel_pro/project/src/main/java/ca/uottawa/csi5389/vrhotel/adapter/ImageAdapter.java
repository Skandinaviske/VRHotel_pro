package ca.uottawa.csi5389.vrhotel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ca.uottawa.csi5389.vrhotel.dao.VRItem;

import java.io.IOException;
import java.io.InputStream;

/**
 * The imageAdapter will set the images for all grid views.
 *
 * @param positionId get hotelId which you choose in the MainActivity.
 * @param roomNumber the roomNumber is to decide which room's image should be put into the which grid view.
 */


public class ImageAdapter extends BaseAdapter {
    private Context context;
    private String[] list;
    private int positionId;
    private int roomNumber;

    public ImageAdapter(Context c, int positionId, int roomNumber) {
        context = c;
        this.positionId = positionId;
        this.roomNumber = roomNumber;
        try {
            list = context.getAssets().list(new VRItem().getHotelList(positionId, roomNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //---returns the number of images---
    public int getCount() {
        if (list.length < 9)
            return list.length;
        else
            return 9;
    }

    //---returns the item---
    public Object getItem(int position) {
        return null;
    }

    //---returns the ID of an item---
    public long getItemId(int position) {
        return 0;
    }

    //---returns an ImageView view---
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ImageView img;

        if (convertView == null) {
            img = new ImageView(context);
            GridView grid = (GridView) parent;
            int size = grid.getRequestedColumnWidth();
            img.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, size));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setPadding(0, 0, 0, 0);
        } else {
            img = (ImageView) convertView;
        }
        try {
            InputStream ims = context.getAssets().open(new VRItem().getHotelList(positionId, roomNumber) + "/" + list[position]);
            Bitmap bitmap = BitmapFactory.decodeStream(ims);
            img.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
