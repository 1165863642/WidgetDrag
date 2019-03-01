package com.example.a11658.textviewdrag;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = 0;
                int y = 0;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getRawX();
                        y = (int) event.getRawX();
                        Toast.makeText(MainActivity.this, "按下", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity.this, "移动", Toast.LENGTH_SHORT).show();
                        int dx = (int) event.getRawX() - x;
                        int dy = (int) event.getRawY() - y;
                        v.layout(v.getLeft() + dx, v.getTop() + dy, v.getRight() + dx, v.getBottom() + dy);
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this, "谈起", Toast.LENGTH_SHORT).show();
                        x = (int) event.getRawX();
                        y = (int) event.getRawY();
                        break;
                }
                return true;
            }
        });
    }
}
