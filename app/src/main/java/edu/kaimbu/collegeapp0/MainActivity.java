package edu.kaimbu.collegeapp0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static edu.kaimbu.collegeapp0.R.id.expectedSalaryAmount;
import static edu.kaimbu.collegeapp0.R.id.finAidAmount;
import static edu.kaimbu.collegeapp0.R.id.loansAmount;
import static edu.kaimbu.collegeapp0.R.id.pocketCostAmount;
import static edu.kaimbu.collegeapp0.R.id.tuitionAmount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculatePressed(View view) {

        final String tuitionAmountString = ((EditText) findViewById(tuitionAmount)).getText().toString();
        final String finAidAmountString = ((EditText) findViewById(finAidAmount)).getText().toString();
        final String loansAmountString = ((EditText) findViewById(loansAmount)).getText().toString();
        final String pocketCostAmountString = ((EditText) findViewById(pocketCostAmount)).getText().toString();
        final String expectedSalaryAmountString = ((EditText) findViewById(expectedSalaryAmount)).getText().toString();

        if (tuitionAmountString.length()               > 0
                && finAidAmountString.length()         > 0
                && loansAmountString.length()          > 0
                && pocketCostAmountString.length()     > 0
                && expectedSalaryAmountString.length() > 0) {

            double tuitionAmountDouble        = Double.parseDouble(tuitionAmountString);
            double findAidAmountDouble        = Double.parseDouble(finAidAmountString);
            double loansAmountDouble          = Double.parseDouble(loansAmountString);
            double pocketCostAmountDouble     = Double.parseDouble(pocketCostAmountString);
            double expectedSalaryAmountDouble = Double.parseDouble(expectedSalaryAmountString);

            double[] userEntries = new double[]{tuitionAmountDouble, findAidAmountDouble,
                    loansAmountDouble, pocketCostAmountDouble, expectedSalaryAmountDouble};

            Intent calculate = new Intent(this, secondPage.class);
            calculate.putExtra("edu.kaimbu.userEntries", userEntries);
            startActivity(calculate);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "You must answer all fields.";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
        }
    }



}
