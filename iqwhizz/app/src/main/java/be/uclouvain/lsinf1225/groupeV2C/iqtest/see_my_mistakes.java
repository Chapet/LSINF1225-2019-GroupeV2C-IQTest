package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class see_my_mistakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_mistakes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Add_a_friend));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
