//Simple Android TabHost and TabWidget Example
package edu.kaimbu.collegeapp0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import static edu.kaimbu.collegeapp0.R.id.tab2;

public class secondPage extends AppCompatActivity {
    TabHost tabHost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        final TabHost.TabSpec spec1 = host.newTabSpec("Five Years");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Five Years");
        host.addTab(spec1);

        //Tab 2
        final TabHost.TabSpec spec2 = host.newTabSpec("Ten Years");
        spec2.setContent(tab2);
        spec2.setIndicator("Ten Years");
        host.addTab(spec2);

        //Tab 3
        final TabHost.TabSpec spec3 = host.newTabSpec("Fifteen Years");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Fifteen Years");
        host.addTab(spec3);



        // naive implementation; will figure out a better way to do this.
        // rent, transport, food, total respectively
        final int[] Boston     = {1200, 140, 640, 1980};
        final int[] Chicago    = { 910, 180, 620, 1710};
        final int[] LosAngeles = {1120, 180, 600, 1900};
        final int[] NewYork    = {1400, 220, 720, 2340};
        final int[] Seattle    = { 980, 180, 530, 1690};

        final Map<String, int[]> data = new HashMap<String, int[]>();
        data.put("Boston"          , Boston);
        data.put("Chicago"         , Chicago);
        data.put("Los Angeles"     , LosAngeles);
        data.put("New York City"   , NewYork);
        data.put("Seattle"         , Seattle);

        // how to access the hashmap: data.get("Boston");


        // these views are used/manipulated immediately upon reaching the second page
        final TextView monthlyincomePostTax = (TextView) findViewById(R.id.incomePostTax);
        final TextView monthlyLoanPayment   = (TextView) findViewById(R.id.monthlyLoanPayment);
        final TextView monthlyBalance1      = (TextView) findViewById(R.id.monthlyBalance1);

        final TextView monthlyincomePostTax_2 = (TextView) findViewById(R.id.incomePostTax_2);
        final TextView monthlyLoanPayment_2   = (TextView) findViewById(R.id.monthlyLoanPayment_2);
        final TextView monthlyBalance1_2      = (TextView) findViewById(R.id.monthlyBalance1_2);

        final TextView monthlyincomePostTax_3 = (TextView) findViewById(R.id.incomePostTax_3);
        final TextView monthlyLoanPayment_3   = (TextView) findViewById(R.id.monthlyLoanPayment_3);
        final TextView monthlyBalance1_3      = (TextView) findViewById(R.id.monthlyBalance1_3);
        // pull data from previous Activity
        Intent intent = getIntent();

        // this double[] holds 0:tuition, 1:finAid, 2:loans, 3:pocketCost, 4:expectedSalary
        double[] userEntries = intent.getDoubleArrayExtra("edu.kaimbu.userEntries");

        // for monthly income post tax
        // avg monthly income post tax = expectedSalary * (1 - 0.01 * income tax) / 12
        /* gotta change this later, tax != 28% for every state/tax bracket */
        monthlyincomePostTax  .setText( String.valueOf( (int) (userEntries[4]*0.72/12) ));
        monthlyincomePostTax_2.setText( String.valueOf( (int) (userEntries[4]*0.72/12) ));
        monthlyincomePostTax_3.setText( String.valueOf( (int) (userEntries[4]*0.72/12) ));

        // for average monthly loan payment
        double rate = 0.07;
        double n    =   12;
        int years   =    5; 		// 10 and 15 for the other tabs
                                      // * 4 to calculate total loans over 4 years
        double loanMath = userEntries[2] * 4 * (rate/n) / ( 1 -  Math.pow( ( 1 +  (rate/n) ) , (-n*years)  ) );

        monthlyLoanPayment.setText( String.valueOf( (int) loanMath));

        years = 10;
        loanMath = userEntries[2] * 4 * (rate/n) / ( 1 -  Math.pow( ( 1 +  (rate/n) ) , (-n*years)  ) );

        monthlyLoanPayment_2.setText( String.valueOf( (int) loanMath));

        years = 15;
        loanMath = userEntries[2] * 4 * (rate/n) / ( 1 -  Math.pow( ( 1 +  (rate/n) ) , (-n*years)  ) );
        monthlyLoanPayment_3.setText( String.valueOf( (int) loanMath));




        // for monthly balance
        // I might change the implementation
        int temp1 = Integer.parseInt(monthlyincomePostTax.getText().toString());
        int temp2 = Integer.parseInt(monthlyLoanPayment.getText()  .toString());

        monthlyBalance1.setText(String.valueOf(temp1 - temp2));

        int temp1_2 = Integer.parseInt(monthlyincomePostTax_2.getText().toString());
        int temp2_2 = Integer.parseInt(monthlyLoanPayment_2.getText()  .toString());

        monthlyBalance1_2.setText(String.valueOf(temp1_2 - temp2_2));

        int temp1_3 = Integer.parseInt(monthlyincomePostTax_3.getText().toString());
        int temp2_3 = Integer.parseInt(monthlyLoanPayment_3.getText()  .toString());

        monthlyBalance1_3.setText(String.valueOf(temp1_3 - temp2_3));

        /*

        just space to divide section

         */


        // these views are used/manipulated when the user selects a different city
        final TextView rentVal      = (TextView) findViewById(R.id.rentVal);
        final TextView transportVal = (TextView) findViewById(R.id.transportVal);
        final TextView foodVal      = (TextView) findViewById(R.id.foodVal);

        final TextView total        = (TextView) findViewById(R.id.total);
        final TextView balance2     = (TextView) findViewById(R.id.monthlyBalance2);
        final TextView difference   = (TextView) findViewById(R.id.difference);
        final Spinner s = (Spinner) findViewById(R.id.spinner);


        final TextView rentVal_2      = (TextView) findViewById(R.id.rentVal_2);
        final TextView transportVal_2 = (TextView) findViewById(R.id.transportVal_2);
        final TextView foodVal_2      = (TextView) findViewById(R.id.foodVal_2);

        final TextView total_2        = (TextView) findViewById(R.id.total_2);
        final TextView balance2_2     = (TextView) findViewById(R.id.monthlyBalance2_2);
        final TextView difference_2   = (TextView) findViewById(R.id.difference_2);
        final Spinner s_2 = (Spinner) findViewById(R.id.spinner_2);


        final TextView rentVal_3      = (TextView) findViewById(R.id.rentVal_3);
        final TextView transportVal_3 = (TextView) findViewById(R.id.transportVal_3);
        final TextView foodVal_3      = (TextView) findViewById(R.id.foodVal_3);

        final TextView total_3        = (TextView) findViewById(R.id.total_3);
        final TextView balance2_3     = (TextView) findViewById(R.id.monthlyBalance2_3);
        final TextView difference_3   = (TextView) findViewById(R.id.difference_3);
        final Spinner s_3 = (Spinner) findViewById(R.id.spinner_3);

        // rentVal.setText(view.toString());

        balance2.setText(monthlyBalance1.getText().toString());
        balance2_2.setText(monthlyBalance1_2.getText().toString());
        balance2_3.setText(monthlyBalance1_3.getText().toString());



        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getSelectedItem().toString();
                rentVal     .setText(String.valueOf(data.get( selectedCity)[0] ));
                transportVal.setText(String.valueOf(data.get( selectedCity)[1] ));
                foodVal     .setText(String.valueOf(data.get( selectedCity)[2] ));

                total.setText(String.valueOf(data.get(selectedCity)[3]));
                //change difference last, after copying balance1 to balance2

                //difference = balance2 - total
                int balanceInt = Integer.parseInt(balance2.getText().toString());
                int totalInt   = Integer.parseInt(total   .getText().toString());
                difference.setText(String.valueOf( balanceInt - totalInt ));

                s_2.setSelection(position);
                s_3.setSelection(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            });

        s_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getSelectedItem().toString();
                rentVal_2     .setText(String.valueOf(data.get( selectedCity)[0] ));
                transportVal_2.setText(String.valueOf(data.get( selectedCity)[1] ));
                foodVal_2     .setText(String.valueOf(data.get( selectedCity)[2] ));

                total_2.setText(String.valueOf(data.get(selectedCity)[3]));
                //change difference last, after copying balance1 to balance2

                //difference = balance2 - total
                int balanceInt = Integer.parseInt(balance2_2.getText().toString());
                int totalInt   = Integer.parseInt(total_2   .getText().toString());
                difference_2.setText(String.valueOf( balanceInt - totalInt ));

                s.setSelection(position);
                s_3.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        s_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getSelectedItem().toString();
                rentVal_3     .setText(String.valueOf(data.get( selectedCity)[0] ));
                transportVal_3.setText(String.valueOf(data.get( selectedCity)[1] ));
                foodVal_3     .setText(String.valueOf(data.get( selectedCity)[2] ));

                total_3.setText(String.valueOf(data.get(selectedCity)[3]));
                //change difference last, after copying balance1 to balance2

                //difference = balance2 - total
                int balanceInt = Integer.parseInt(balance2_3.getText().toString());
                int totalInt   = Integer.parseInt(total_3   .getText().toString());
                difference_3.setText(String.valueOf( balanceInt - totalInt ));

                s.setSelection(position);
                s_2.setSelection(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
    

}