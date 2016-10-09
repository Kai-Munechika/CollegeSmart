//Simple Android TabHost and TabWidget Example
package edu.kaimbu.collegeapp0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import edu.kaimbu.collegeapp0.R;

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
    }

}