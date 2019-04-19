package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    private TextView categories;
    DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.categories = (TextView) findViewById(R.id.categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat = new Intent(getApplicationContext(), category.class);
                startActivity(cat);
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar

        // implement setNavigationOnClickListener event
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dLayout.openDrawer(Gravity.RIGHT);
            }
        });
        setNavigationDrawer(); // call method

    }

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
// Display menu item's title by using a Toast.
        if (id == R.id.action_settings) {
            dLayout.openDrawer(Gravity.RIGHT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
        // implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment frag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
                // check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.first) {
                    frag = new FirstFragment();
                } else if (itemId == R.id.second) {
                    frag = new SecondFragment();
                } else if (itemId == R.id.third) {
                    frag = new ThirdFragment();
                }
                // display a toast message with menu item's title
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });
    }
}
