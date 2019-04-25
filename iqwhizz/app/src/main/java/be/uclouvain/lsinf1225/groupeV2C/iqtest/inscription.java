package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class inscription extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText birthyear;
    private EditText locality;
    private Button button;
    private TextView usernameError;
    private TextView passwordError;
    private TextView birthyearError;
    private TextView localityError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.sign_up));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // implement setNavigationOnClickListener event
        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        birthyear = findViewById(R.id.editText3);
        locality = findViewById(R.id.editText4);
        button = findViewById(R.id.button1);
        usernameError = findViewById(R.id.textView3);
        passwordError = findViewById(R.id.textView5);
        birthyearError = findViewById(R.id.textView7);
        localityError = findViewById(R.id.textView8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userNameInput = username.getText().length();
                int passwordInput = password.getText().length();
                int birthyearInput = birthyear.getText().length();
                int localityInput = locality.getText().length();
                if(userNameInput < 3 || passwordInput <= 0 || birthyearInput != 4){
                    if(userNameInput < 3 || localityInput < 3){ //diviser en 2 et ne mettre l'erreur que là ou il y en a une
                        usernameError.setVisibility(View.VISIBLE);
                    }
                    else{
                        usernameError.setVisibility(View.INVISIBLE);
                    }

                    if(passwordInput <=0){ //il faudrait que le mot de passe soit de minimum de longueur 6 ce serait mieux
                        passwordError.setVisibility(View.VISIBLE);
                    }
                    else{
                        passwordError.setVisibility(View.INVISIBLE);
                    }

                    if(birthyearInput != 4){  //si c'est plus grand que 2019 aussi (ou que today pour generaliser)
                        birthyearError.setVisibility(View.VISIBLE);
                    }
                    else{
                        birthyearError.setVisibility(View.INVISIBLE);
                    }

                    if(localityInput <= 4){ //pq pas une selection de pays mais ca c est si on a le time
                        localityError.setVisibility(View.VISIBLE);
                    }
                    else{
                        localityError.setVisibility(View.INVISIBLE);
                    }
                }
                else{
                    openActivity2();
                }
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
        finish();
    }
}
