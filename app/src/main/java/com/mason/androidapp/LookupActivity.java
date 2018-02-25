package com.mason.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LookupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);

        final Intent requestIntent = new Intent(this, RequestActivity.class);
        final EditText summonerName = (EditText) findViewById(R.id.summoner_name);
        final Button lookupButton = (Button) findViewById(R.id.lookup_button);
        lookupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LookupManager.ref.setSummonerName(summonerName.getText().toString());
                startActivity(requestIntent);
            }
        });
    }
}