package com.example.vidgaze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.vidgaze.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    CategoriesFragment categoriesFragment = new CategoriesFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView  = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

      //  BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.notification);
     //   badgeDrawable.setVisible(true);
      //  badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.nav_library:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,libraryFragment).commit();
                        return true;
                    case R.id.nav_subscriptions:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,subscriptionsFragment).commit();
                        return true;
                    case R.id.nav_categories:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,categoriesFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }
}

/*
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CategoriesFragment());


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_library:
                        fragment = new LibraryFragment();
                        break;
                    case R.id.nav_categories:
                        fragment = new CategoriesFragment();
                        break;
                    case R.id.nav_subscriptions:
                        fragment = new SubscriptionsFragment();
                        break;
                }
                loadFragments(fragment);
                return true;
            }
        });
       // loadFragments(new HomeFragment());
        /*
            Fragment fragment = null;
            switch () {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.nav_library:
                    fragment = new LibraryFragment();
                    break;
                case R.id.nav_categories:
                    fragment = new CategoriesFragment();
                    break;
                case R.id.nav_subscriptions:
                    fragment = new SubscriptionsFragment();
                    break;
            }

        loadFragments(fragment);*//*
    }




    private boolean loadFragments(Fragment fragment) {
        if (fragment == null) {
            return false;
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
            return true;
        }
    }
}*/