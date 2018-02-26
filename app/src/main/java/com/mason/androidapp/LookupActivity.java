package com.mason.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class LookupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);

        final Intent requestIntent = new Intent(this, RequestActivity.class);
        final EditText summonerName = findViewById(R.id.summoner_name);
        final ImageButton enemyTeam = findViewById(R.id.enemy_team);
        final ImageButton allyTeam = findViewById(R.id.my_team);
        enemyTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LookupManager.ref.setSummonerName("oteam" + summonerName.getText().toString().replaceAll(" ", ""));
                startActivity(requestIntent);
            }
        });
        allyTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LookupManager.ref.setSummonerName("mteam" + summonerName.getText().toString().replaceAll(" ", ""));
                startActivity(requestIntent);
            }
        });
    }
}