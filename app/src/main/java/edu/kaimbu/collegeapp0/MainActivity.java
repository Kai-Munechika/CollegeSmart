package edu.kaimbu.collegeapp0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculatePressed(View view) {
        Intent calculate = new Intent(this, secondPage.class);
        startActivity(calculate);
    }
}
