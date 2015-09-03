package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends Activity {

    Button ButtonA;
    Button ButtonC;
    TextView textB;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        setTitle("Activity B");

        textB = (TextView) findViewById(R.id.textViewB);

        ButtonA = (Button) findViewById(R.id.button5);
        ButtonC = (Button) findViewById(R.id.button6);

        Intent receivedIntent = getIntent();

        if(receivedIntent.hasExtra("ABC")){
            String temp = receivedIntent.getStringExtra("ABC");
            textB.setText("Opened by "+temp);
            message = "Activity B, which was opened by " + temp;
        }
        else{
            textB.setText("No Parent");
            message = "Activity B";
        }

        View.OnClickListener ocl = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityB.this, ActivityA.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        View.OnClickListener ocl2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityB.this, ActivityC.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        ButtonA.setOnClickListener(ocl);
        ButtonC.setOnClickListener(ocl2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
