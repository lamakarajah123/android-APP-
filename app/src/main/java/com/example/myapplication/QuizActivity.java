package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button submitBtn;
    private Button backButton;
    private TextView feedbackTextView;

    private int correctAnswer = R.id.option1RadioButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sharedPreferences = getSharedPreferences("quiz_preferences", MODE_PRIVATE);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        submitBtn = findViewById(R.id.submitBtn);
        feedbackTextView = findViewById(R.id.feedbackTextView);
        backButton = findViewById(R.id.backButton);

        questionTextView.setText("What is a correct syntax to output \"Hello World\" in Java?");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answerRadioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    if (selectedId == correctAnswer) {
                        feedbackTextView.setText("Correct!");
                        // Increment user score
                        int userScore = sharedPreferences.getInt("quiz_score", 0);
                        userScore++;
                        // Save updated score
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("quiz_score", userScore);
                        editor.apply();
                    } else {
                        feedbackTextView.setText("Incorrect! The correct answer is A) System.out.print(\"Hello World\");");
                    }
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to SubjectListActivity
                Intent intent = new Intent(QuizActivity.this, SubjectListActivity.class);
                startActivity(intent);
            }
        });
    }
}
