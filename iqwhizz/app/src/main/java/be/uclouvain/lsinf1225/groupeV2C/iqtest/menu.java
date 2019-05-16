package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Blob;

public class menu extends AppCompatActivity {

    private TextView categories;
    private TextView completetest;
    private TextView quicktest;
    private TextView flashtest;
    private TextView Myresult;
    private menu addfriends;
    private ImageView headphot;
    private Blob im;
    private ImageView head;
    private int sound=1;
    DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.addfriends=this;
        this.categories = (TextView) findViewById(R.id.categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat = new Intent(getApplicationContext(), category.class);
                startActivity(cat);
            }
        });

        this.completetest = (TextView) findViewById(R.id.completetest);
        completetest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compl = new Intent(getApplicationContext(), Rules.class);
                startActivity(compl);
            }
        });

        this.quicktest= (TextView) findViewById(R.id.quicktest);
        quicktest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quick = new Intent(getApplicationContext(), rulesquick.class);
                startActivity(quick);
            }
        });

        this.flashtest = (TextView) findViewById(R.id.flashtest);
        flashtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flash = new Intent(getApplicationContext(), rulesflash.class);
                startActivity(flash);
            }
        });
        this.Myresult = (TextView) findViewById(R.id.myscores);
        Myresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent score = new Intent(getApplicationContext(), My_Result.class);
                startActivity(score);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.menu));
        toolbar.setNavigationIcon(R.drawable.log_out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        headphot=(ImageView)im;
        if(headphot!=null){
            head=findViewById(R.id.imageView);
            // A MODIFIER !!!!
        }
        setNavigationDrawer(); // call method

    }

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        //menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.lan);

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
                    Intent addfriend = new Intent(getApplicationContext(), addfriend.class);
                    startActivity(addfriend);
                } else if (itemId == R.id.second) {
                    Intent friend = new Intent(getApplicationContext(), friends.class);
                    startActivity(friend);
                } else if (itemId == R.id.third) {
                    Intent ranking = new Intent(getApplicationContext(), ranking.class);
                    startActivity(ranking);
                } else if (itemId == R.id.cinquo) {
                    if (sound==1){
                        MainActivity.ring.pause();
                        sound=0;
                    }
                    else{
                        MainActivity.ring.start();
                        sound=1;
                    }
                }
                else if (itemId == R.id.seix) {
                    Intent signup = new Intent(getApplicationContext(), inscription.class);
                    startActivity(signup);
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
