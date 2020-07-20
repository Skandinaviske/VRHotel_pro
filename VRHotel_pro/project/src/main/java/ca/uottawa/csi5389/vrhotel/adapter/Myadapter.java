package ca.uottawa.csi5389.vrhotel.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidviewhover.BlurLayout;

import java.util.ArrayList;
import java.util.Map;

import ca.uottawa.csi5389.vrhotel.DetailActivity;
import ca.uottawa.csi5389.vrhotel.R;
import ca.uottawa.csi5389.vrhotel.dao.VRItem;

/**
 * Myadapter will set the images, hotel name and hotel describe for all list views in the MainActivity.
 *
 * @param data       this parameter passes the hotel name, hotel description and images to Myadapter.
 * @param imagegroup the roomNumber is to decide which room's image should be put into the which grid view from the local database.
 */


public class Myadapter extends BaseAdapter {

    private Context context;
    private ArrayList<Map<String, String>> data;
    private Integer[] imagegroup;

    public Myadapter(Context context, ArrayList<Map<String, String>> data) {
        super();
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        final ViewHolder holder;

        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            convertView = inflater.inflate(R.layout.cell, null, true);
            holder = new ViewHolder();
            holder.text = (TextView) convertView
                    .findViewById(R.id.title);

            holder.content = (TextView) convertView
                    .findViewById(R.id.content);

            holder.image = (ImageView) convertView
                    .findViewById(R.id.list_img);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        imagegroup = new VRItem().getImagegroup();

        //holder.image.setImageResource(imagegroup[position]);
        holder.text.setText(data.get(position).get("title"));
        holder.content.setText(data.get(position).get("text"));
        holder.image.setImageResource(Integer.parseInt(data.get(position).get("image")));
        BlurLayout.setGlobalDefaultDuration(450);
        BlurLayout mLayout = (BlurLayout) convertView.findViewById(R.id.blur_layout);

        final View hover = LayoutInflater.from(context).inflate(R.layout.hover, null);

        //share the image from the MainActivity to others by different applications.
        hover.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendIntent.putExtra(Intent.EXTRA_TEXT, data.get(position).get("title"));

                //get the precise image uri of the images.
                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + context.getResources().getResourcePackageName(imagegroup[position])
                        + '/' + context.getResources().getResourceTypeName(imagegroup[position])
                        + '/' + context.getResources().getResourceEntryName(imagegroup[position]));
                sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                sendIntent.setType("image/png");

                Intent new_intent = Intent.createChooser(sendIntent, "Share via");
                new_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(new_intent);
            }
        });

        //go to the DetailActivity.
        hover.findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("title", data.get(position).get("title"));
                i.putExtra("text", new VRItem().getHotelDescription()[VRItem.exchangeNameForId(data.get(position).get("title")) - 1]);
                i.putExtra("number", (position + 1) + "");
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        /**
         * Reference: https://github.com/daimajia/AndroidViewHover
         *
         * Set the send button and go button on the hover.
         */
        mLayout.setHoverView(hover);
        mLayout.setBlurDuration(400);
        mLayout.addChildAppearAnimator(hover, R.id.send, Techniques.FlipInX, 400, 250);
        mLayout.addChildAppearAnimator(hover, R.id.go, Techniques.FlipInX, 400, 500);

        mLayout.addChildDisappearAnimator(hover, R.id.send, Techniques.FlipOutY, 400, 250);
        mLayout.addChildDisappearAnimator(hover, R.id.go, Techniques.FlipOutY, 400, 0);

        mLayout.addChildAppearAnimator(hover, R.id.description, Techniques.FadeInUp);
        mLayout.addChildDisappearAnimator(hover, R.id.description, Techniques.FadeOutDown);

        return convertView;
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView text;
        public TextView content;
    }
}

