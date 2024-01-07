package com.example.ex1201_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button b00, b01, b02, b10, b11, b12, b20, b21, b22;
    private Button btnPlayAgain, btn_restart;
    public String Player1_name, Player2_name ;
    private MediaPlayer PlayerOne_sound, PlayerTwo_sound;
    private MediaPlayer Playing;
    String str_MARU = "◯", str_X="X";
    private  String p00, p01, p02, p10, p11, p12, p20, p21, p22;
    boolean b_turn = true;
    int Total_Count=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b00 = findViewById(R.id.btn1);
        b01 = findViewById(R.id.btn2);
        b02 = findViewById(R.id.btn3);
        b10 = findViewById(R.id.btn5);
        b11 = findViewById(R.id.btn4);
        b12 = findViewById(R.id.btn6);
        b20 = findViewById(R.id.btn9);
        b21 = findViewById(R.id.btn7);
        b22 = findViewById(R.id.btn8);
        btn_restart = findViewById(R.id.button5);
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnPlayAgain = findViewById(R.id.btn);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestartGame();
            }
        });
        Playing = MediaPlayer.create(getApplicationContext(), R.raw.playing_8bit);
        PlayerOne_sound = MediaPlayer.create(getApplicationContext(), R.raw.select01);
        PlayerTwo_sound = MediaPlayer.create(getApplicationContext(), R.raw.select02);

        Playing.start();

    }

    public void onCheck(View view)
    {
//        Toast.makeText(getApplicationContext(), "googog", Toast.LENGTH_SHORT).show();
        Button currentButton = (Button) view;
        if(currentButton.getText().toString().equals(""))
        {
            Total_Count+=1;
            if(b_turn == true){
                currentButton.setText(str_MARU);
                PlayerOne_sound.start();
            }else{
                currentButton.setText(str_X);
                PlayerTwo_sound.start();
            }
            b_turn = !b_turn;
            if(Total_Count > 4)
            {
                p00 = b00.getText().toString();
                p01 = b01.getText().toString();
                p02 = b02.getText().toString();
                p10 = b10.getText().toString();
                p11 = b11.getText().toString();
                p12 = b12.getText().toString();
                p20 = b20.getText().toString();
                p21 = b21.getText().toString();
                p22 = b22.getText().toString();

                if(p00.equals(p01) && p01.equals(p02)&&!p00.equals("")) {
                    ToWinPage(p00);
                } else if (p10.equals(p11) && p11.equals(p12)&&!p10.equals("")) {
                    ToWinPage(p10);
                } else if (p20.equals(p21) && p21.equals(p22)&&!p20.equals("")) {
                    ToWinPage(p20);
                } else if (p00.equals(p10) && p10.equals(p20)&&!p00.equals("")) {
                    ToWinPage(p00);
                } else if (p01.equals(p11) && p11.equals(p21)&&!p01.equals("")) {
                    ToWinPage(p01);
                } else if (p02.equals(p12) && p12.equals(p22)&&!p02.equals("")) {
                    ToWinPage(p02);
                } else if (p00.equals(p11)&& p11.equals(p22)&& !p00.equals("")) {
                    ToWinPage(p00);
                } else if (p02.equals(p11)&& p02.equals(p20)&& !p02.equals("")) {
                    ToWinPage(p02);
                } else if (!p00.equals("")&&!p01.equals("")&&!p02.equals("")&&!p10.equals("")&&!p11.equals("")&&!p12.equals("")&&!p20.equals("")&&!p21.equals("")&&!p22.equals("")){
                    Toast.makeText(getApplicationContext(), "DRAW", Toast.LENGTH_SHORT).show();
                    RestartGame();
                }

            }
        }

    }
    private void RestartGame()
    {
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        Total_Count =0;
        b_turn = true;
        Player1_name = "";
        Player2_name = "";
    }

    private void ToWinPage(String pos_name)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        Bundle recievebundle = this.getIntent().getExtras();
        Player1_name = recievebundle.getString("Player1");
        Player2_name = recievebundle.getString("Player2");
        if(Player1_name.equals(""))
        {
            Player1_name = "X";
        }
        if(Player2_name.equals(""))
        {
            Player2_name = "◯";
        }

        Bundle bundle = new Bundle();
        if(pos_name == "X")
        {
            bundle.putString("Winner", Player1_name);
        }else {
            bundle.putString("Winner", Player2_name);
        }
        intent.putExtras(bundle);
        RestartGame();
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(), "2_destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(getApplicationContext(), "2_onRestart", Toast.LENGTH_SHORT).show();
        Playing.seekTo(0);
        Playing.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(), "2_onPause", Toast.LENGTH_SHORT).show();
        Playing.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(), "2_onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(), "2_onResume", Toast.LENGTH_SHORT).show();
        Playing.seekTo(0);
        Playing.start();
    }
}