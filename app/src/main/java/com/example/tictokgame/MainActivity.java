package com.example.tictokgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    //2 - null 0 - X 1 - O

    int activePlayer = 0;
    int []gameState = {2,2,2,2,2,2,2,2,2};
    int [] [] winPostions = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView)view;
        int tappedImage = Integer.parseInt((img.getTag().toString()));
        if(!gameActive){
            gamereset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage]= activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O Turn - Tap To Play");}

            else{
                activePlayer = 0;
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("X Turn - Tap To Play");
            }
        }
        img.animate().translationYBy(1000f).setDuration(300);
        for (int []winpostion :winPostions){
            if (gameState[winpostion[0]]== gameState[winpostion[1]] &&
                gameState[winpostion[1]] == gameState[winpostion[2]] &&
                gameState[winpostion[0]]!=2) {
                        String winnerstr;
                        gameActive = false;
                        if(gameState[winpostion[0]]==0) {
                            winnerstr = "X WIN'S --Tap To Reset";
                        }
                        else{
                            winnerstr= "O WIN'S --Tap To Rest";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }

        }





    }
    public void gamereset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i =0;i<gameState.length;i++){
            gameState[i] = 2;
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
}