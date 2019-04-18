package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class connexion extends AppCompatActivity {

    private Button men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.men = (Button) findViewById(R.id.men);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(), menu.class);
                startActivity(signup);
                finish();
            }
        });
    }
}


//LES DIFFERENTES TAILLES D ECRAN SUR CONNEXION SCREEN BON pas encore ajoutées ici


