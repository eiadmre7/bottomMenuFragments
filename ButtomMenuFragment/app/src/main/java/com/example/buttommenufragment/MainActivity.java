package com.example.buttommenufragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private DashBoardFrag dashBoardFrag;
    private HomeFrag homeFrag;
    private FrameLayout HomeFrame, dashboardFrame;
    private BottomNavigationView bottomnavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFrame=findViewById(R.id.HomeFrame);
        dashboardFrame=findViewById(R.id.dashboardFrame);
        bottomnavigation=findViewById(R.id.bottomnavigation);
        start();
    }

    private void start() {
        homeFrag = new HomeFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.HomeFrame, homeFrag).commit();
        dashBoardFrag = new DashBoardFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboardFrame, dashBoardFrag).commit();

        // Hide other fragments initially
        dashboardFrame.setVisibility(View.INVISIBLE);

        // Set up bottom navigation view listener
        bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.menu_home) {
                    // Show Home fragment
                    dashboardFrame.setVisibility(View.INVISIBLE);
                    HomeFrame.setVisibility(View.VISIBLE);
                }
                   else  {
                        // Show Dashboard fragment
                        HomeFrame.setVisibility(View.INVISIBLE);
                        dashboardFrame.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });

    }

}