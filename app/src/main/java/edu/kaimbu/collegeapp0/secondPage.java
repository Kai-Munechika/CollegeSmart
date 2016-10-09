//Simple Android TabHost and TabWidget Example
package edu.kaimbu.collegeapp0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;

public class secondPage extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Five Years");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Five Years");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Ten Years");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Ten Years");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Fifteen Years");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Fifteen Years");
        host.addTab(spec);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}