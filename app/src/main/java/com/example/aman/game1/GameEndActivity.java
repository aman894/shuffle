package com.example.aman.game1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GameEndActivity extends AppCompatActivity {
    TextView tvScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        Intent intent = getIntent();
        String score = intent.getStringExtra("SCORE");
        Log.w("SCORE::",score);
        tvScore = (TextView)findViewById(R.id.tvScore);
        tvScore.setText("Score: "+score);



    }
}
