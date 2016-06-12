package com.example.aman.game1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radiovar1;
    RadioButton radiovar2;
    Button go;
    String str="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiovar1 = (RadioButton) findViewById(R.id.r1);
        radiovar2 = (RadioButton) findViewById(R.id.r2);

        go = (Button) findViewById(R.id.button1);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean radiovar1_checked = radiovar1.isChecked();
                // Check which radio button was clicked

                if(radiovar1_checked == true)
                    str = "easy";
                else str = "hard";

                Intent intent= new Intent(MainActivity.this,MainActivity1.class);
                intent.putExtra("radiochosen",str);
                startActivity(intent);

            }
        });

    }



}
