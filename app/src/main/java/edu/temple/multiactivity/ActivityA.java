package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends Activity {

    Button ButtonC;
    Button ButtonB;
    TextView textA;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        setTitle("Activity A");

        textA = (TextView) findViewById(R.id.textViewA);

        ButtonC = (Button) findViewById(R.id.button);
        ButtonB = (Button) findViewById(R.id.button2);


        Intent receivedIntent = getIntent();

        if(receivedIntent.hasExtra("ABC")){
            textA.setText("Opened by "+receivedIntent.getStringExtra("ABC"));
            message = "Activity A, which was opened by " + receivedIntent.getStringExtra("ABC");
        }
        else{
            textA.setText("No Parent");
            message = "Activity A";
        }

        View.OnClickListener ocl = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityA.this, ActivityC.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        View.OnClickListener ocl2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityA.this, ActivityB.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        ButtonC.setOnClickListener(ocl);
        ButtonB.setOnClickListener(ocl2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
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
