package ca.uottawa.csi5389.vrhotel;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * LauncherActivity is the launcher activity.
 */

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setPaintFlags(btnSearch.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  // from https://stackoverflow.com/questions/31718707/how-to-underline-text-of-button-in-android
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, MainActivityForBrowse.class);
                startActivity(intent);
            }
        });

        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, AttributionActivity.class);
                startActivity(intent);
            }
        });

    }
}
