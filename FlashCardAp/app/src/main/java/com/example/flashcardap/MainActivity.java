package com.example.flashcardap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView flashCardQuestion;
    private TextView flashcardAnswer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView toggle_choices_visibility=findViewById(R.id.toggle_choices_visibility);
        ImageView showIcon=findViewById(R.id.showIcon);
        final Boolean[] toggle = {false};


        flashCardQuestion= findViewById(R.id.flashcard_question);
        flashcardAnswer= findViewById(R.id.flashcard_answer);
        TextView firstOption=findViewById(R.id.First_Option);
        TextView secondOption=findViewById(R.id.Second_Option);
        TextView thirdOption=findViewById(R.id.Third_Option);

        ImageView addbutton= findViewById(R.id.addbutton);




        flashCardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashCardQuestion.setVisibility(View.INVISIBLE);
                flashcardAnswer.setVisibility(View.VISIBLE);
            }
        });
        flashcardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashCardQuestion.setVisibility(View.VISIBLE);
                flashcardAnswer.setVisibility(View.INVISIBLE);

            }
        });
        firstOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstOption.setBackgroundColor(getResources().getColor(R.color.red));
                thirdOption.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        thirdOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdOption.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        secondOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondOption.setBackgroundColor(getResources().getColor(R.color.red));
                thirdOption.setBackgroundColor(getResources().getColor(R.color.green));


            }
        });
        toggle_choices_visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle[0] =false;
                Log.d("success", String.valueOf(toggle[0]));
                showIcon.setVisibility(View.VISIBLE);
                toggle_choices_visibility.setVisibility(View.INVISIBLE);
                firstOption.setVisibility(View.INVISIBLE);
                secondOption.setVisibility(View.INVISIBLE);
                thirdOption.setVisibility(View.INVISIBLE);



            }
        });
        showIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle[0] =true;
                Log.d("success", String.valueOf(toggle[0]));
                showIcon.setVisibility(View.INVISIBLE);
                toggle_choices_visibility.setVisibility(View.VISIBLE);
                firstOption.setVisibility(View.VISIBLE);
                secondOption.setVisibility(View.VISIBLE);
                thirdOption.setVisibility(View.VISIBLE);







            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_activity();
            }
        });
    }
    public void add_activity()
    {
        Intent intent= new Intent(MainActivity.this,AddCardActivity.class);
        MainActivity.this.startActivityForResult(intent,100);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==RESULT_OK)
        {
            String question_data= data.getExtras().getString("Question");
            String answer_data= data.getExtras().getString("Answer");
            flashCardQuestion.setText(question_data);
            flashcardAnswer.setText(answer_data);



            System.out.println(question_data);
            System.out.println(answer_data);
        }
    }
}