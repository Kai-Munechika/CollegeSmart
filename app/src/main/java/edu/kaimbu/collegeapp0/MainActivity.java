package edu.kaimbu.collegeapp0;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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

        final String tuitionAmountString        = ((EditText) findViewById(tuitionAmount)).getText().toString();
        final String finAidAmountString         = ((EditText) findViewById(finAidAmount)).getText().toString();
        final String loansAmountString          = ((EditText) findViewById(loansAmount)).getText().toString();
        final String pocketCostAmountString     = ((EditText) findViewById(pocketCostAmount)).getText().toString();
        final String expectedSalaryAmountString = ((EditText) findViewById(expectedSalaryAmount)).getText().toString();

        if (tuitionAmountString.length()               > 0
                && finAidAmountString.length()         > 0
                && loansAmountString.length()          > 0
                && pocketCostAmountString.length()     > 0
                && expectedSalaryAmountString.length() > 0) {

            final double tuitionAmountDouble        = Double.parseDouble(tuitionAmountString);
            final double findAidAmountDouble        = Double.parseDouble(finAidAmountString);
            final double loansAmountDouble            = Double.parseDouble(loansAmountString);
            final double pocketCostAmountDouble = Double.parseDouble(pocketCostAmountString);
            final double expectedSalaryAmountDouble = Double.parseDouble(expectedSalaryAmountString);

            final double difference = tuitionAmountDouble - findAidAmountDouble - loansAmountDouble - pocketCostAmountDouble;

            if ( difference > 0) {

                //dialog

                AlertDialog.Builder test = new AlertDialog.Builder(this);
                test.setMessage("You're missing $" + difference + " from your tuition budget");

                test.setPositiveButton("Adjust Pocket Cost", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //use a snackbar to show that the previous value was changed to the new value
                        EditText temp = (EditText) findViewById(R.id.pocketCostAmount);
                        String textBefore = temp.getText().toString();
                        temp.setText(String.valueOf(pocketCostAmountDouble + difference));
                        Snackbar.make(findViewById(R.id.activity_main), "Changed $" + textBefore + " to $"
                                + temp.getText().toString(), Snackbar.LENGTH_LONG).show();

                    }
                });
                test.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });

                AlertDialog test2 = test.create();
                test2.show();
            }

            else if ( difference < 0 ) {
                AlertDialog.Builder test = new AlertDialog.Builder(this);
                test.setMessage("You have $" + -difference + " extra in tuition funds! Continue?");

                test.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double[] userEntries = new double[]{tuitionAmountDouble, findAidAmountDouble,
                                loansAmountDouble, pocketCostAmountDouble, expectedSalaryAmountDouble};

                        Intent calculate = new Intent(getBaseContext(), secondPage.class);
                        calculate.putExtra("edu.kaimbu.userEntries", userEntries);
                        startActivity(calculate);
                    }
                });
                test.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog test2 = test.create();
                test2.show();
            }

            else {

                double[] userEntries = new double[]{tuitionAmountDouble, findAidAmountDouble,
                        loansAmountDouble, pocketCostAmountDouble, expectedSalaryAmountDouble};

                Intent calculate = new Intent(this, secondPage.class);
                calculate.putExtra("edu.kaimbu.userEntries", userEntries);
                startActivity(calculate);
            }
        }
        else {
//            Context context = getApplicationContext();
            CharSequence text = "You must answer all fields.";
//            int duration = Toast.LENGTH_SHORT;
//            Toast.makeText(context, text, duration).show();

            Snackbar.make(findViewById(R.id.activity_main), text, Snackbar.LENGTH_SHORT).show();

        }
    }



}
