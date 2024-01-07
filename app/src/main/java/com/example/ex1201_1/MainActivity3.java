package com.example.ex1201_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private MediaPlayer Winner_sound;
    private String Winner;
    private TextView txt_winner;

    private Button btn_PlayAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Winner_sound = MediaPlayer.create(getApplicationContext(), R.raw.winner);
        Winner_sound.start();
        txt_winner = findViewById(R.id.textView2);
        btn_PlayAgain = findViewById(R.id.button);
        btn_PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = this.getIntent().getExtras();
        Winner = bundle.getString("Winner");
        txt_winner.setText("THE WINNER IS\n"+Winner+"!!!!!");


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}