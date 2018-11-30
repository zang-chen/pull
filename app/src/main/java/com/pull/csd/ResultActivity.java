package com.pull.csd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null) {
            String token = intent.getStringExtra("token");
            if (token != null) {
                textView.setText("结果页面接收到的token值:" + token);
            }
        }

    }
}
