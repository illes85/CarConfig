package com.example.carselector;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

int priceDuster = 9990, priceEngine = 0, priceDrive = 0, clickCounterEngine = 1, clickCounterDrive = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final MediaPlayer music1 = MediaPlayer.create(this, R.raw.car_music_01);
        final Button buttonMusic = findViewById(R.id.button_music);
        TextView textviewPrice = findViewById(R.id.textview_price);


        textviewPrice.setText("Price: " + priceDuster + "€");

        music1.start();
        music1.setLooping(true);

        ViewPager viewPager = findViewById(R.id.view_pager);
        final ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        buttonMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music1.isPlaying() == true)
                {
                    music1.pause();
                    buttonMusic.setText("Music OFF");
                    buttonMusic.setTextColor(Color.parseColor("#78909C"));
                } else
                {
                    music1.start();
                    buttonMusic.setText("Music ON");
                    buttonMusic.setTextColor(Color.parseColor("#263238"));
                }
            }
        });

        Toast.makeText(this, "Swipe RIGHT and LEFT", Toast.LENGTH_LONG).show();

    }


    public void changeModel(View view)
    {
        final MediaPlayer soundFuzzy = MediaPlayer.create(this, R.raw.fuzzy_beep);
        soundFuzzy.start();
    }

    public void notImplemented(View view)
    {
        Toast.makeText(this, "This feature is not implemented yet", Toast.LENGTH_LONG).show();
    }

    public void changeEngine(View view)
    {
        // gas 90hp  // diesel 90hp  // diesel 110hp

        TextView textviewPrice = findViewById(R.id.textview_price);
        TextView textviewEngine = findViewById(R.id.textview_engine);
        final MediaPlayer soundChange = MediaPlayer.create(this, R.raw.button_click);
        soundChange.start();

        switch (clickCounterEngine)
        {
            case 1:
                textviewEngine.setText("ENGINE:\ndiesel 90hp");
                priceEngine = priceEngine + 800;
                textviewPrice.setText("Price: " + ( priceDuster + priceEngine + priceDrive) + " €");
                clickCounterEngine++;
                break;
            case 2:
                textviewEngine.setText("ENGINE:\ndiesel 110hp");
                priceEngine = priceEngine + 1080;
                textviewPrice.setText("Price: " + ( priceDuster + priceEngine + priceDrive) + " €");
                clickCounterEngine++;
                break;
            case 3:
                textviewEngine.setText("ENGINE:\ngas 90hp");
                priceEngine = 0;
                textviewPrice.setText("Price: " + ( priceDuster + priceEngine + priceDrive) + " €");
                clickCounterEngine = 1;
                break;
        }
    }

    public void changeDrive(View view)   // 4 x 4   // 4 x 2
    {
        TextView textviewPrice = findViewById(R.id.textview_price);
        TextView textviewDrive = findViewById(R.id.textview_drive);
        final MediaPlayer soundChange = MediaPlayer.create(this, R.raw.button_click);
        soundChange.start();

        switch (clickCounterDrive)
        {
            case 1:
                textviewDrive.setText("DRIVE\n4 x 4");
                priceDrive = priceDrive + 1130;
                textviewPrice.setText("Price: " + ( priceDuster + priceEngine + priceDrive) + " €");
                clickCounterDrive++;
                break;
            case 2:
                textviewDrive.setText("DRIVE\n4 x 2");
                priceDrive = 0;
                textviewPrice.setText("Price: " + ( priceDuster + priceEngine + priceDrive) + " €");
                clickCounterDrive = 1;
                break;
        }
    }
}
