package com.example.kristine.badgeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class YourBadges extends Activity {
    int[] statusArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_badges);

        //Gets the Intent from the AvailableBadges class --> Intent.putIntExtra("state",0)
        Intent intent = getIntent();
        statusArray = intent.getIntArrayExtra("status_Array");
        //int state = intent.getIntExtra("state",1);

        //finding views by their IDs
        Button btnBack = (Button) findViewById(R.id.btnBack);
        final Button btnNext = (Button) findViewById(R.id.btnNext);
        ImageView image =(ImageView) findViewById(R.id.imgCommunity2);
        TextView name =(TextView) findViewById(R.id.txtViewCommunity);

        if (statusArray[0]==1){
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        if (statusArray[1]==1){
            image = (ImageView) findViewById(R.id.imgAcademicAward2);
            name = (TextView) findViewById(R.id.txtViewAcademicAward);
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        if(statusArray[2]==1){
            image = (ImageView) findViewById(R.id.imgDeansList2);
            name = (TextView) findViewById(R.id.txtViewDeanList);
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        //on click listeners for buttons
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGoBack(view);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNextBadge(view);
            }
        });

    }
    //called when the back button is pressed by the user
    public void btnGoBack (View view){
        Intent intentAvailableBadges = new Intent(this,AvailableBadges.class);
        intentAvailableBadges.putExtra("status_Array",statusArray);
        startActivity(intentAvailableBadges);

    }

    public void btnNextBadge (View view){
        Intent intentAvailableBadges = new Intent(this,YourBadges2.class);
        intentAvailableBadges.putExtra("status_Array",statusArray);
        startActivity(intentAvailableBadges);
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
