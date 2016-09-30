package com.melanialani.marshmallowui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.melanialani.marshmallowui.Fragments.Accounts;
import com.melanialani.marshmallowui.Fragments.AddAccount;
import com.melanialani.marshmallowui.Fragments.AllPost;
import com.melanialani.marshmallowui.Fragments.Fragment1;
import com.melanialani.marshmallowui.Fragments.Fragment2;
import com.melanialani.marshmallowui.Fragments.RemoveAccount;
import com.melanialani.marshmallowui.Fragments.SinglePost;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null); // make icons "actually" shows in nav drawer
    }

    //region default from template
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_accounts) {
            fragmentClass = Accounts.class;
        } else if (id == R.id.nav_settings) {
            fragmentClass = Fragment2.class;
        }

        // account management
        else if (id == R.id.nav_addAccount) {
            fragmentClass = AddAccount.class;
        } else if (id == R.id.nav_removeAccount) {
            fragmentClass = RemoveAccount.class;
        }

        // statistical overview
        else if (id == R.id.nav_view) {

        } else if (id == R.id.nav_viewOverall) {

        }

        // graphical overview
        else if (id == R.id.nav_trend) {

        } else if (id == R.id.nav_trendOverall) {

        }

        // post
        else if (id == R.id.nav_post) {
            fragmentClass = SinglePost.class;
        } else if (id == R.id.nav_postToAll) {
            fragmentClass = AllPost.class;
        }

        // hashtag management
        else if (id == R.id.nav_createHashtagList) {

        } else if (id == R.id.nav_manageHashtagList) {

        } else if (id == R.id.nav_searchByHashtag) {

        }

        // load target class into fragment
        try {
            fragment = (Fragment) (fragmentClass != null ? fragmentClass.newInstance() : null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // insert fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // call navigation menu into attention
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // highlight selected item that has been done by NavigationView
        item.setChecked(true);

        // set action bar title
        setTitle(item.getTitle());

        // hide navigation menu
        drawer.closeDrawer(GravityCompat.START);

        // done with this shit
        return true;
    }

}
