package com.techhousestudio.demobottomnavigation;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techhousestudio.demobottomnavigation.ui.DashBoardFragment;
import com.techhousestudio.demobottomnavigation.ui.HomeFragment;
import com.techhousestudio.demobottomnavigation.ui.NotificationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // widgets
    private Toolbar toolbar;
    private BottomNavigationView navView;
    private AppBarLayout appBar;
//    boolean[] clickState = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        // set up fragment
        getSupportFragmentManager().beginTransaction().add(R.id.frag_container, HomeFragment.getInstance()).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currentFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        if (!clickState[0]) {
                        currentFragment = HomeFragment.getInstance();
//                            clickState[0] = true;
//                            clickState[1] = false;
//                            clickState[2] = false;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Home Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                    case R.id.navigation_dashboard:
//                        if (!clickState[1]) {
                        currentFragment = DashBoardFragment.getInstance();
                        appBar.setExpanded(false);
//                            clickState[0] = false;
//                            clickState[1] = true;
//                            clickState[2] = false;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Dash Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                    case R.id.navigation_notifications:
//                        if (!clickState[2]) {
                        appBar.setExpanded(false);
                        currentFragment = NotificationFragment.getInstance();
//                            clickState[0] = false;
//                            clickState[1] = false;
//                            clickState[2] = true;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Noti Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                }
                if (currentFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, currentFragment).commit();
                } else {
                    Toast.makeText(getApplicationContext(), "Null Fragment", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navView = findViewById(R.id.nav_view);
        appBar = findViewById(R.id.appbar);

        // fab
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appBar.setExpanded(false,true);
            }
        });
    }


}
