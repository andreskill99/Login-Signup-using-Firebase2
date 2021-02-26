package com.example.shiva.try1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class DashboardActivity extends AppCompatActivity {

    String EmailHolder;
    String GoogleHolder;
    TextView Email;
    Button LogOUT ;
    Button Google;
    Button Facebook;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseUser mUser;
    //@SuppressLint("SetTextI18n")
    public static final String TAG="LOGIN";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       Email = (TextView)findViewById(R.id.textView1 );

        LogOUT = (Button)findViewById(R.id.button1);


        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(login.userEmail);


        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        // Adding click listener to Log Out button.

        EmailHolder = intent.getStringExtra(login.userEmail);

        Toast.makeText( this, " Bienvenido: " + " Usuario "+ EmailHolder  , Toast.LENGTH_SHORT).show();


        LogOUT.setOnClickListener(new View.OnClickListener() {
           // @Override
            public void onClick(View v) {


                mAuth.getInstance().signOut();
                startActivity(new Intent(DashboardActivity.this, login.class));

                //Finishing current DashBoard activity on button click.
               finish();





                Toast.makeText(DashboardActivity.this,"Cierre de sesión exitoso", Toast.LENGTH_LONG).show();
                //Intent intent=new Intent(DashboardActivity.this,login.class);
                //startActivity(intent);
               /*if (v.getId() == R.id.button1) {
                    AuthUI.getInstance()
                            .signOut(this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    // user is now signed out
                                    startActivity(new Intent(DashboardActivity.this, login.class));
                                    finish();
                                }
                            });
                }*/

            }
        });

    }


}