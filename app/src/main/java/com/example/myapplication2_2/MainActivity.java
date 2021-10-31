package com.example.myapplication2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.textView);
        edt=findViewById(R.id.editText);
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                edt.setText(savedInstanceState.getString("text"));
                mShowCount.setText(savedInstanceState.getString("count"));
                edt.setVisibility(View.VISIBLE);
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (edt.getVisibility() == View.VISIBLE && mShowCount.getVisibility() == View.VISIBLE ) {
            outState.putBoolean("reply_visible", true);
            outState.putString("text", edt.getText().toString());
            outState.putString("count", mShowCount.getText().toString());

        }
    }
}

