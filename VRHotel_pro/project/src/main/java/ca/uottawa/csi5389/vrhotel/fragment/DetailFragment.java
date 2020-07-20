package ca.uottawa.csi5389.vrhotel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ca.uottawa.csi5389.vrhotel.R;

import androidx.fragment.app.Fragment;

/**
 * DetailFragment is the fragment to set up details in the DetailActivity.
 *
 * @param title get the current hotel name.
 * @param text  get the current hotel description.
 */

public class DetailFragment extends Fragment {

    private TextView textViewTitle;
    private String title;
    private TextView textViewContent;
    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment1, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            title = bundle.getString("title");
            text = bundle.getString("text");
        }

        textViewTitle = view.findViewById(R.id.tv_title);
        textViewTitle.setText(title);
        textViewContent = view.findViewById(R.id.tv_desc);
        textViewContent.setText(text);
        return view;
    }

}