package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class connexion extends AppCompatActivity {
    public static EditText user;
    public static EditText pass;
    public static String users;
    public static String passw;
    private Button men;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        user=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        this.men = (Button) findViewById(R.id.men);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = user.getText().toString();
                passw = pass.getText().toString();
                if(DatabaseHelper.con(users,passw)){
                    Intent signin = new Intent(getApplicationContext(), menu.class);
                    startActivity(signin);
                }
            }
        });

        this.signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(), inscription.class);
                startActivity(signup);
            }
        });
    }
}

//LES DIFFERENTES TAILLES D ECRAN SUR CONNEXION SCREEN BON pas encore ajoutées ici


