package edu.kaimbu.collegeapp0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by KaiM on 10/29/16.
 */

public class qa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_answer);

        TextView rent = (TextView) findViewById(R.id.howRentIsCalculated);

        String rentText = "Average rent is <b>not</b> the average rent of a one bedroom apartment in those locations. Rather, it is the calculated average rent that an individual pays to live in that city. Most recent college grads will split rent of an apartment among roommates and that number is the one listed as average rent.";

        rent.setText(Html.fromHtml(rentText));


    }
}