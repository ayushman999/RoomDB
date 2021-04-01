package com.ayushman999.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.ayushman999.roomdb.REPLY";

    private EditText mEditWordView;
    ArrayList<String> datalist=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        EditText array=findViewById(R.id.array_edit);
        final Button button = findViewById(R.id.button_save);
        final Button add=findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datalist.add(array.getText().toString().trim());
            }
        });
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditWordView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditWordView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                replyIntent.putExtra("array",datalist);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}