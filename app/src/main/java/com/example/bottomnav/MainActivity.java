package com.example.bottomnav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements NotiFragment.OnFragmentInteractionListener{
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                   fragment = new HomeFragment();
                    break;

                case R.id.navigation_dashboard:
                    fragment = new DashFragment();
                    break;

                case R.id.navigation_notifications:
                    fragment = new NotiFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
