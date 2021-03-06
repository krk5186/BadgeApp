package com.example.kristine.badgeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvailableBadgesPg2 extends Activity {
int[] statusArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges_pg2);
        Intent intent = getIntent();
        statusArray = intent.getIntArrayExtra("status_Array");
        //finding views by their IDs
        final Button btnAddHonor = (Button) findViewById(R.id.btnAddHonorSociety);
        final Button btnAddAbroad = (Button) findViewById(R.id.btnAddAbroad);
        Button btnAddGraduation = (Button) findViewById(R.id.btnAddGraduation);
        Button btnMyBadges = (Button) findViewById(R.id.btnMyBadges);
        Button btn = (Button) findViewById(R.id.btnBackAvailableBdg2);
        //setting on click listeners for the buttons
        btnMyBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMyBadgesPress(view);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBackAvailableBdg2(view);
            }
        });
        btnAddHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddHonorPress(view);
            }
        });
        btnAddAbroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddAbroadPress(view);
            }
        });
        btnAddGraduation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddGraduationPress(view);
            }
        });
    }
    //called when the back button is pressed by the user
    public void btnMyBadgesPress(View view){
        Intent intentMyBadges = new Intent (this, YourBadges2.class);
        intentMyBadges.putExtra("status_Array",statusArray);
        startActivity(intentMyBadges);
    }
    public void btnBackAvailableBdg2 (View view) {

        Intent intentMyBadges = new Intent (this, AvailableBadges.class);
        intentMyBadges.putExtra("status_Array",statusArray);
        startActivity(intentMyBadges);
    }
    public void btnAddHonorPress (View view){
        Intent intent = new Intent(this, YourBadges2.class);
        statusArray[3]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    public void btnAddAbroadPress (View view){
        Intent intent = new Intent(this, YourBadges2.class);
        statusArray[4]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    public void btnAddGraduationPress(View view){
        Intent intent = new Intent(this, YourBadges2.class);
        statusArray[5]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_available_badges_pg2, menu);
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
