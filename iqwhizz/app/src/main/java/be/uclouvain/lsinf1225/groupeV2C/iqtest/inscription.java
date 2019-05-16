package be.uclouvain.lsinf1225.groupeV2C.iqtest;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;

import static java.sql.Types.NULL;
// Attention, on ne peut pas passer à l'écran suivant en ayant que sélectionner un avatar.

public class inscription extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText birthyear;
    private EditText locality;
    private static Blob image;
    private Button button;
    private Button avatarButton;
    private TextView usernameError;
    private TextView passwordError;
    private TextView birthyearError;
    private TextView localityError;
    private ImageView imageView;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        birthyear = findViewById(R.id.editText3);
        locality = findViewById(R.id.editText4);
        button = findViewById(R.id.button1);
        usernameError = findViewById(R.id.textView3);
        passwordError = findViewById(R.id.textView5);
        birthyearError = findViewById(R.id.textView7);
        localityError = findViewById(R.id.textView8);
        avatarButton = findViewById(R.id.activity_main_button2);

        imageView = findViewById(R.id.image1);
        avatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userNameInput = username.getText().length();
                int passwordInput = password.getText().length();
                int birthyearInput = birthyear.getText().length();
                int birthyearNumber = 0;
                if (!birthyear.getText().toString().equals("")) {
                    System.out.println("on rentre dans le if de l'inscription");
                    birthyearNumber = Integer.parseInt(birthyear.getText().toString());
                }
                int localityInput = locality.getText().length();
                if (userNameInput < 3 || passwordInput < 6 || birthyearInput != 4 || birthyearNumber > 2019 || birthyearNumber < 1920 ||
                        localityInput < 3 && userNameInput == NULL) {
                    System.out.println("une cond de fausse");
                    if (userNameInput < 3 || userNameInput == NULL) {
                        usernameError.setVisibility(View.VISIBLE);
                    } else {
                        usernameError.setVisibility(View.INVISIBLE);
                    }

                    if (passwordInput < 6 || passwordInput == NULL ) {
                        passwordError.setVisibility(View.VISIBLE);
                    }
                    if (passwordInput > 20 || passwordInput == NULL) {
                        passwordError.setVisibility(View.VISIBLE);
                    } else {
                        passwordError.setVisibility(View.INVISIBLE);
                    }

                    if (birthyearInput != 4 || birthyearNumber > 2019 || birthyearNumber < 1920 || birthyearInput == NULL) {
                        birthyearError.setVisibility(View.VISIBLE);
                    } else {
                        birthyearError.setVisibility(View.INVISIBLE);
                    }

                    if (localityInput < 3 || localityInput == NULL) {
                        localityError.setVisibility(View.VISIBLE);
                    } else {
                        localityError.setVisibility(View.INVISIBLE);
                    }
                } else {
                    DatabaseHelper.insertInfoUser2(username.getText().toString(), password.getText().toString(), Integer.parseInt(birthyear.getText().toString()), locality.getText().toString(),image);
                    DatabaseHelper.testDBUSER();
                    openActivity2();
                }
            }
        });

    }


    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    public void openActivity2() {
        Intent intent = new Intent(this, connexion.class);
        startActivity(intent);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();

            InputStream inputStream;
            try {
                inputStream = getContentResolver().openInputStream(imageUri);
                Bitmap image = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(image);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
            }
            imageView.setImageURI(imageUri);
        }
    }
}