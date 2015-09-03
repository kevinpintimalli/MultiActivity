package edu.temple.multiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class ActivityC extends Activity {

    Button ButtonB;
    Button ButtonA;
    TextView textC;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_c);
        setTitle("Activity C");

        textC = (TextView) findViewById(R.id.textViewC);

        ButtonA = (Button) findViewById(R.id.button3);
        ButtonB = (Button) findViewById(R.id.button4);

        Intent receivedIntent = getIntent();

        if(receivedIntent.hasExtra("ABC")){
            textC.setText("Opened by "+receivedIntent.getStringExtra("ABC"));
            message = "Activity C, which was opened by " + receivedIntent.getStringExtra("ABC");
        }
        else{
            textC.setText("No Parent");
            message = "Activity C";
        }

        View.OnClickListener ocl = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityA.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        View.OnClickListener ocl2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityB.class);

                launchActivityIntent.putExtra("ABC", message);

                startActivity(launchActivityIntent);
            }
        };

        ButtonA.setOnClickListener(ocl);
        ButtonB.setOnClickListener(ocl2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_c, menu);
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
