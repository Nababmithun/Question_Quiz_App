package com.androidlime.question_quiz_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlime.question_quiz_app.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {


    Button b1, b2, b3, b4;

    TextView t1_question, timeTxt;

    DatabaseReference reference;

    int total = 0;
    int correct = 0;

    int wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.button1);

        b2 = (Button) findViewById(R.id.button2);

        b3 = (Button) findViewById(R.id.button3);

        b4 = (Button) findViewById(R.id.button4);


        t1_question = (TextView) findViewById(R.id.questionTxt);

        timeTxt = (TextView) findViewById(R.id.timeTxt);


        updateQuestion();
        reverseTimer(30,timeTxt);



    }

    private void updateQuestion()
    {


        if (total > 16)
        {

            Intent myintent =new Intent(MainActivity.this,ResultActivity.class);

            myintent.putExtra("total",String.valueOf(total));

            myintent.putExtra("correct",String.valueOf(correct));
            myintent.putExtra("incorrect",String.valueOf(wrong));
            startActivity(myintent);
             }

        else {

            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));


            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    final Question question = dataSnapshot.getValue(Question.class);


                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (b1.getText().toString().equals(question.getAnswer()))

                            {
                                {


                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();

                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {


                                            correct++;
                                            b1.setBackgroundColor(Color.parseColor("#FF17E4DD"));

                                        }
                                    }, 1500);


                                }


                            } else {


                                wrong++;
                                b1.setBackgroundColor(Color.RED);


                                if (b2.getText().toString().equals(question.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);

                                } else if (b3.getText().toString().equals(question.getAnswer())) {


                                    b3.setBackgroundColor(Color.GREEN);


                                } else if (b4.getText().toString().equals(question.getAnswer())) {


                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b2.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b3.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b4.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }


                        }
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (b2.getText().toString().equals(question.getAnswer()))

                            {
                                {


                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();

                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {


                                            correct++;
                                            b2.setBackgroundColor(Color.parseColor("#FF17E4DD"));

                                        }
                                    }, 1500);


                                }


                            } else {


                                wrong++;
                                b2.setBackgroundColor(Color.RED);


                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b3.getText().toString().equals(question.getAnswer())) {


                                    b3.setBackgroundColor(Color.GREEN);


                                } else if (b4.getText().toString().equals(question.getAnswer())) {


                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b2.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b3.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b4.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        updateQuestion();

                                    }
                                }, 1500);


                            }


                        }
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (b3.getText().toString().equals(question.getAnswer()))

                            {
                                {


                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();

                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {


                                            correct++;
                                            b3.setBackgroundColor(Color.parseColor("#FF17E4DD"));

                                        }
                                    }, 1500);


                                }


                            } else {


                                wrong++;
                                b3.setBackgroundColor(Color.RED);


                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b2.getText().toString().equals(question.getAnswer())) {


                                    b2.setBackgroundColor(Color.GREEN);


                                } else if (b4.getText().toString().equals(question.getAnswer())) {


                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b2.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b3.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b4.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        updateQuestion();

                                    }
                                }, 1500);


                            }

                        }
                    });


                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (b4.getText().toString().equals(question.getAnswer()))

                            {
                                {


                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();

                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {


                                            correct++;
                                            b4.setBackgroundColor(Color.parseColor("#FF17E4DD"));

                                        }
                                    }, 1500);


                                }


                            } else {


                                wrong++;
                                b4.setBackgroundColor(Color.RED);


                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b2.getText().toString().equals(question.getAnswer())) {


                                    b2.setBackgroundColor(Color.GREEN);


                                } else if (b3.getText().toString().equals(question.getAnswer())) {


                                    b3.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b2.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b3.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        b4.setBackgroundColor(Color.parseColor("#FF17E4DD"));
                                        updateQuestion();

                                    }
                                }, 1500);


                            }

                        }
                    });

                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();

                }
            });

        }


    }



    public void  reverseTimer(int Seconds,final  TextView tv){

        new CountDownTimer(Seconds*1000+1000,1000)
        {

            public void  onTick(long millisUntilFinished){


                int sceounds=(int)(millisUntilFinished/1000);
                int mintues=sceounds/60;
                sceounds=sceounds%60;
                tv.setText(String.format("%02d",mintues)+":"+String.format("%02d",sceounds));

            }
            public void onFinish()
            {
                tv.setText("Completed");

                Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("total" ,String.valueOf(total));
                intent.putExtra("correct",String.valueOf(correct));
                intent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(intent);

            }


        }.start();



    }
}




