package com.example.glb_gz.multipackageapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView app_info_tv;
    LinearLayout view_ll;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        app_info_tv = (TextView) findViewById(R.id.app_info_tv);
        view_ll = findViewById(R.id.view_ll);

        //测试各个属性的提取,如 boolean ,string ,dimen,color 等等
        app_info_tv.setText(getResources().getString(R.string.my_app_name)+"  isCramerApp? "+getResources().getBoolean(R.bool.is_cramer_app));
        view_ll.setBackgroundColor(getResources().getColor(R.color.app_background_color));

        Log.i("TEST","isCramerApp? "+getResources().getBoolean(R.bool.is_cramer_app));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
