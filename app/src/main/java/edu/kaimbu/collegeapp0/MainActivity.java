package edu.kaimbu.collegeapp0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tuitionAmount = (EditText) findViewById(R.id.tuitionAmount);
        final EditText finAidAmount = (EditText) findViewById(R.id.finAidAmount);
        final EditText loansAmount = (EditText) findViewById(R.id.loansAmount);
        final EditText pocketCostAmount = (EditText) findViewById(R.id.pocketCostAmount);
        final EditText expectedSalaryAmount = (EditText) findViewById(R.id.expectedSalaryAmount);

    }

    public void calculatePressed(View view) {
        Intent calculate = new Intent(this, secondPage.class);
        startActivity(calculate);
    }



}
