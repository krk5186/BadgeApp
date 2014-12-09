package com.example.kristine.badgeapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvailableBadges extends Activity {
    int[] statusArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges);

        Intent intent = getIntent();
        statusArray = intent.getIntArrayExtra("status_Array");
        //Finding the views by their ID
        Button btnMyBdg = (Button) findViewById(R.id.btnMyBadges_Avail);
        Button btnNext = (Button) findViewById(R.id.btnNextAvailableBdg);
        Button btnCommunity = (Button) findViewById(R.id.btnAddCommunity);
        Button btnAcademic = (Button) findViewById(R.id.btnAddAcademicAward);
        Button btnDean = (Button) findViewById(R.id.btnAddDeansList);
        //Setting on click listeners for the buttons
        btnMyBdg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGoToMyBadges(view);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNextAvailableBdg(view);
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddCommunity(view);
            }
        });
        btnAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddAcademic(view);
            }
        });
        btnDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddDean(view);
            }
        });
        }


    //called when the user presses the add button for the Community badge
    public void btnAddCommunity (View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[0]=1;
        intent.putExtra("status_Array",statusArray);
        //intent.putExtra("state",0);
        startActivity(intent);
    }
    public void btnAddAcademic (View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[1]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    public void btnAddDean(View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[2]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    //called when the user selects the My Badges button
    public void btnGoToMyBadges(View view){
        Intent intentMyBadges = new Intent (this, YourBadges.class);
        intentMyBadges.putExtra("status_Array",statusArray);
        startActivity(intentMyBadges);
    }
    //called when the user selects the next button to switch to the second "My Badges" page
    public void btnNextAvailableBdg (View view) {

        Intent intent = new Intent(this, AvailableBadgesPg2.class);
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
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
