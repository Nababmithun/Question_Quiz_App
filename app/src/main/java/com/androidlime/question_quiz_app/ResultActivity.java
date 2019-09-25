package com.androidlime.question_quiz_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);




        textView1= (TextView) findViewById(R.id.text2);

        textView1= (TextView) findViewById(R.id.text4);


        textView1= (TextView) findViewById(R.id.text6);


        Intent i=getIntent();
        String questions=i.getStringExtra("total");
        String correct=i.getStringExtra("correct");

        String wrong=i.getStringExtra("incorrect");



        textView1.setText(questions);
        textView2.setText(correct);

        textView3.setText(wrong);



    }
}
