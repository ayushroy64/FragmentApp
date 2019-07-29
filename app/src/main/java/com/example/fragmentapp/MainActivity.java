package com.example.fragmentapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    Button bn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(!status){
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                    bn.setText("LOAD SECOND FRAGMENT");
                    status = true;


                }else{
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container,f2);
                    fragmentTransaction.commit();
                    bn.setText("LOAD FIRST FRAGMENT");
                    status = false;
                }

            }
        });
    }
}
