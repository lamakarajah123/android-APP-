package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExamplesActivity extends AppCompatActivity {

    private TextView examplesTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);

        examplesTextView = findViewById(R.id.examplesTextView);
        backButton = findViewById(R.id.backButton);

        displayJavaExamples();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamplesActivity.this, SubjectListActivity.class));
            }
        });
    }


    private void displayJavaExamples() {
        StringBuilder examplesBuilder = new StringBuilder();

        examplesBuilder.append("Examples of Java Code:\n\n");
        examplesBuilder.append("1.Java Math \n");
        examplesBuilder.append(" Math.max(5, 10);\n\n");
        examplesBuilder.append("2. Java Comments\n");
        examplesBuilder.append("// This is a comment\n" +
                "System.out.println(\"Hello World\");\n\n");
        examplesBuilder.append("3. Java Variables\n");
        examplesBuilder.append("String name = \"lama\";\n" +
                "System.out.println(name);\n\n");
        examplesTextView.setText(examplesBuilder.toString());
    }
}
