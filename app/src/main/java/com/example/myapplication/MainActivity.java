package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Player player;
    private int currentNumberLevel;
    private TextView textView;
    private Button leftButton;
    private Button rightButton;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;

    private List<Level> list = Arrays.asList(
            /*0*/    new Level("Дворник Олег украл кораллы у царя, но вернул их. Что с ним делать?", new int[] {0, -10, 0}, new int[] {0, 10, 0}),
            /*0*/    new Level("Ваш помощник убил вашего кота. Что с ним делать? ", new int[] {0, -5, 0}, new int[] {0, 10, 0}),
            /*0*/    new Level("После войны с татаро монголами к нам перешло 100 военнопленных. Что с ними делать?", new int[] {20, 0, 10}, new int[] {0, 10, 0}),
            /*0*/    new Level("Ваш давний неприятель вторгся в нашу страну со своим войском, но был окружён и взят в плен. Что сним делать?", new int[] {20, -10, 20}, new int[] {0, 10, 0}),
            /*0*/    new Level("Овечка пастуха Егорыча случайно сломала двери в казарму. Что делать с пастухом?", new int[] {0, 10, 0}, new int[] {10, -20, 0}),
            /*0*/    new Level("Враг народа, купец Илья был пойман при попытке поджечь лес. Что с ним делать? ", new int[] {0, -20, 0}, new int[] {0, 20, 0}),
            /*0*/    new Level("Один из жителей заболел неизвестной болезнью. Что с ним делать?", new int[] {0, 5, 0}, new int[] {-20, -20, -10}),
            /*0*/    new Level("Портной сшил вашу мантию неправильно. Что с ним делать?", new int[] {-5, 0, 0}, new int[] {-10, -10, 0}),
            /*0*/    new Level("Плотник Ефрим решил не платить налог за его жилище. Что с ним делать?", new int[] {-10, -10, -10}, new int[] {0, 10, 10}),
            /*0*/    new Level("Доктор, который живёт у ворот в город, секретно лечил у себя в подвале вражеских воинов. Что сним делать?", new int[] {0, -5, -5}, new int[] {0, 10, 5}),
            /*0*/    new Level("Котик", new int[] {0, 100, 0}, new int[] {-5, -100, 10}),
            /*0*/    new Level("Шут пришел с идеей создания мира!5", new int[] {0, 10, 0}, new int[] {-5, -10, 10}),
            /*0*/    new Level("Шут пришел с идеей создания мира!5", new int[] {0, 10, 0}, new int[] {-5, -10, 10}),
            /*0*/    new Level("Шут пришел с идеей создания мира!5", new int[] {0, 10, 0}, new int[] {-5, -10, 10}),
            /*1*/    new Level("Level 2", new int[] {0, 10, 0}, new int[] {-5, -10, 10}),
            /*2*/    new Level("Level 3", new int[] {10, -10, 0}, new int[] {-50, -10, 0}),
            /*3*/    new Level("Level 4", new int[] {0, -5, 10}, new int[] {100, 0, 10})
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.levelText);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);

        player = new Player("Player1", new int[] {50, 50, 50});
        currentNumberLevel = 0;
        Level startLevel = list.get(currentNumberLevel);
        textView.setText(startLevel.text);
        progressBar1.setProgress(50);
        progressBar2.setProgress(50);
        progressBar3.setProgress(50);
        leftButton.setOnClickListener(leftButtonListener());
        rightButton.setOnClickListener(rightButtonListener());
    }

    public View.OnClickListener rightButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Level currentLevel = list.get(currentNumberLevel);
                final int[] rightDelta = currentLevel.deltaNo;

                int newProgress = progressBar1.getProgress() + rightDelta[0];
                progressBar1.setProgress(newProgress);

                newProgress = progressBar2.getProgress() + rightDelta[1];
                progressBar2.setProgress(newProgress);

                newProgress = progressBar3.getProgress() + rightDelta[2];
                progressBar3.setProgress(newProgress);
                currentNumberLevel++;

                if((progressBar1.getProgress() <= 0 || progressBar1.getProgress() >= 100)
                        || (progressBar2.getProgress() <= 0 || progressBar2.getProgress() >= 100)
                        || (progressBar3.getProgress() <= 0 || progressBar3.getProgress() >= 100)) {
                    gameOver();
                }

                if(currentNumberLevel < list.size()) {
                    final Level nextLevel = list.get(currentNumberLevel);
                    textView.setText(nextLevel.text);
                } else {
                    gameOver();
                }


            }
        };
    }

//    private void apply(int[] attributes) {
//        player.applyAttribute(attributes);
//        index++;
//        final Level nextLevel = list.get(index);
//        textView.setText(nextLevel.text);
//}

    public View.OnClickListener leftButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Level currentLevel = list.get(currentNumberLevel);
                final int[] delta = currentLevel.deltaYes;

                int newProgress = progressBar1.getProgress() + delta[0];
                progressBar1.setProgress(newProgress);

                newProgress = progressBar2.getProgress() + delta[1];
                progressBar2.setProgress(newProgress);

                newProgress = progressBar3.getProgress() + delta[2];
                progressBar3.setProgress(newProgress);
                currentNumberLevel++;

                if((progressBar1.getProgress() <= 0 || progressBar1.getProgress() >= 100)
                        || (progressBar2.getProgress() <= 0 || progressBar2.getProgress() >= 100)
                        || (progressBar3.getProgress() <= 0 || progressBar3.getProgress() >= 100)) {
                    gameOver();
                }

                if(currentNumberLevel < list.size()) {
                    final Level nextLevel = list.get(currentNumberLevel);
                    textView.setText(nextLevel.text);
                } else {
                    gameOver();
                }
            }
        };
    }

    public void gameOver() {
        Toast.makeText(MainActivity.this, "GameOver", Toast.LENGTH_LONG).show();
        finish();
    }
}