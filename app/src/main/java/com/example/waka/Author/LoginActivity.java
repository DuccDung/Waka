package com.example.waka.Author;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.waka.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtIntentRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        makeStatusBarTransparent();
        applyTopPadding();

        txtIntentRegister = findViewById(R.id.txt_intent_register);
        txtIntentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void makeStatusBarTransparent() {
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }


    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.box_open_book_activity);

        if (contentContainer != null) {
            int statusBarHeight = getStatusBarHeight();
            contentContainer.setPadding(0, statusBarHeight, 0, 0);
        }
    }


    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}