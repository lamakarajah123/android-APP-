package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplanationActivity extends AppCompatActivity {

    private TextView explanationTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);

        // Initialize views
        explanationTextView = findViewById(R.id.explanationTextView);
        backButton = findViewById(R.id.backButton);

        displayJavaexplanation();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExplanationActivity.this, SubjectListActivity.class));
            }
        });
    }


    private void displayJavaexplanation() {
        StringBuilder explanationBuilder = new StringBuilder();

        // Add examples of Java code
        explanationBuilder.append("Explanation of examples:\n\n");
        explanationBuilder.append("1.Java Math \n");
        explanationBuilder.append(" The Java Math class has many methods that allows you to perform mathematical tasks on numbers.\n\n");
        explanationBuilder.append("2. Java Comments\n");
        explanationBuilder.append("Comments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code\n\n");
        explanationBuilder.append("3. Java Variables\n");
        explanationBuilder.append("In Java, there are different types of variables, for example:\n" +
                "\n" +
                "String - stores text, such as \"Hello\". String values are surrounded by double quotes\n" +
                "int - stores integers (whole numbers), without decimals, such as 123 or -123\n" +
                "float - stores floating point numbers, with decimals, such as 19.99 or -19.99\n" +
                "char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes\n" +
                "boolean - stores values with two states: true or false");
        explanationTextView.setText(explanationBuilder.toString());
    }
}
