package com.example.aman.game1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by harsh on 11/6/16.
 */
public class MainActivity1 extends AppCompatActivity implements View.OnClickListener{

    String newmsg;
    Button b1,b2,b3,b4;
    String answerWord="";
    int wordCount = 0;
    int score = 0;
    String [] words = {"CATS","DOGS","PIGS","SWAN","RATS","GOAT"};
    int ctr = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Intent intentExtras = getIntent();
        String extras = intentExtras.getStringExtra("radiochosen");
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        showCards(words);
    }



    public static String scramble( Random random, String inputString ) {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle,
        for( int i=0 ; i<a.length ; i++ ) {
            int j = random.nextInt(a.length-1);
            // Swap letters
            char temp = a[i]; a[i] = a[j];  a[j] = temp;
        }

        return new String( a );
    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;
        answerWord = answerWord + b.getText();
        Log.w("Answer::",answerWord);
        b.setVisibility(View.INVISIBLE);
        ctr++;
        Log.w("ctr value",String.valueOf(ctr));
        Log.w("word count value",String.valueOf(wordCount));
        if(ctr == 4){
            if(rightAnswer()){
                score++;
                wordCount++;
                if(wordCount == words.length){
                    wordCount = 0;
                }
                Toast.makeText(MainActivity1.this,"Correct Answer",Toast.LENGTH_SHORT).show();
                showCards(words);
            }
            else{
                Toast.makeText(MainActivity1.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity1.this,GameEndActivity.class);
                intent.putExtra("SCORE",String.valueOf(wordCount));
                startActivity(intent);
            }
            ctr=0;
        }
    }

    private boolean rightAnswer() {
        Log.w("wc right answer",String.valueOf(wordCount));
        if(answerWord.equals(words[wordCount]))
            return true;
        return false;
    }

    private void showCards(String [] words) {
        answerWord="";
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);

        Random r = new Random();
        String sword = scramble( r, words[wordCount] );



        char a_char = sword.charAt(0);
        b1.setText(String.valueOf(a_char));
        a_char = sword.charAt(1);
        b2.setText(String.valueOf(a_char));
        a_char = sword.charAt(2);
        b3.setText(String.valueOf(a_char));
        a_char = sword.charAt(3);
        b4.setText(String.valueOf(a_char));

    }
}
