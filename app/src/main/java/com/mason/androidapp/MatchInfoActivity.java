package com.mason.androidapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MatchInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_info);

        Enemy[] enemies = LookupManager.ref.getEnemies();
        Enemy enemy;
        String nameID;
        TextView name;
        String tiltID;
        TextView tilt;
        String iconID;
        ImageView icon;
        for (int i = 1; i < 6; i++) {
            enemy = enemies[i - 1];

            nameID = "info_enemy_" + i + "_name";
            name = findViewById(getResources().getIdentifier(nameID, "id", getPackageName()));
            name.setText(enemy.getName());

            tiltID = "info_enemy_" + i + "_tilt";
            tilt = findViewById(getResources().getIdentifier(tiltID, "id", getPackageName()));
            tilt.setText(String.valueOf(enemy.getTilt()) + "%");

            iconID = "info_enemy_" + i + "_icon";
            icon = findViewById(getResources().getIdentifier(iconID, "id", getPackageName()));
            icon.setImageResource(getResources().getIdentifier("a" + enemy.getChamp(), "drawable", getPackageName()));
        }
    }
}
