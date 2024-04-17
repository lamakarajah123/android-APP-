package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectListActivity extends AppCompatActivity {

    private ListView subjectListView;
    private String[] subjects = {"Examples", "Explanation", "Quizzes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        subjectListView = findViewById(R.id.subjectListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);

        subjectListView.setAdapter(adapter);

        subjectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = subjects[position];

                switch (selectedOption) {
                    case "Examples":
                        startActivity(new Intent(SubjectListActivity.this, ExamplesActivity.class));
                        break;
                    case "Explanation":
                        startActivity(new Intent(SubjectListActivity.this, ExplanationActivity.class));
                        break;
                    case "Quizzes":
                        startActivity(new Intent(SubjectListActivity.this, QuizActivity.class));
                        break;
                }
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubjectListActivity.this, MainActivity.class));
            }
        });
    }
}
