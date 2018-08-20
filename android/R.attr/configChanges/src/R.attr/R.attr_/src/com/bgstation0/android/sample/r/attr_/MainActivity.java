package com.bgstation0.android.sample.r.attr_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // "onCreate"に来たらトースト表示.
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();	// "onCreate"と表示.
        
    }
    
}
