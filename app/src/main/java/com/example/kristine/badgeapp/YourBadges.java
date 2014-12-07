package com.example.kristine.badgeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class YourBadges extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_badges);

        //Gets the Intent from the AvailableBadges class --> Intent.putExtra("state",0)
        //Switched the visibility if state has been assigned to '0'.
        Intent intent = getIntent();
        int state = Integer.parseInt(intent.getExtras().get("state").toString());

        ImageView image =(ImageView) findViewById(R.id.imgCommunity2);
        TextView name =(TextView) findViewById(R.id.txtViewCommunity);

        if(state == 0) {
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.INVISIBLE);
            name.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_your_badges, menu);
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
