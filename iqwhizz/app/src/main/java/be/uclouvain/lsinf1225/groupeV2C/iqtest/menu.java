package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    private TextView categories;

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
    }


}
