package com.bb.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Second_Activity extends AppCompatActivity {

    private EditText mReply;

    private ImageView imageView;

    public static final String EXTRA_REPLY = "com.bb.messanger.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);

        imageView = findViewById(R.id.imageView);
        loadImage();

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textMessage);

        textView.setText(message);


    }

    private void loadImage(){
        int image = R.drawable.slowpoke;
        Glide.with(this).load(image).into(imageView);
    }

    public void returnReply(View view){
        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();

        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK,replyIntent);

        finish();
    }

}
