package com.example.ex1201_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

//    private VideoView videoView;
    private Button  bt2;
    private TextView textView;

    private EditText name_Player1, name_Player2;
    private MediaPlayer Opening;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        videoView = findViewById(R.id.videoView);
        textView = findViewById(R.id.textView);

        name_Player1 = findViewById(R.id.editTextText3);
        name_Player2 = findViewById(R.id.editTextText5);

        Opening = MediaPlayer.create(getApplicationContext(), R.raw.opening_8bit);
        Opening.start();

        bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle sentplayerName1 = new Bundle();
                sentplayerName1.putString("Player1",name_Player1.getText().toString());
                intent.putExtras(sentplayerName1);

                Bundle sentplayerName2 = new Bundle();
                sentplayerName2.putString("Player2",name_Player2.getText().toString());
                intent.putExtras(sentplayerName2);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Opening.seekTo(0);
        Opening.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Opening.pause();

    }
}