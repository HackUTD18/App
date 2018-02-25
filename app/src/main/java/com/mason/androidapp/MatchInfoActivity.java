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
        String iconID;
        ImageView icon;
        String reasonsID;
        TextView reasonView;
        String[] reasons;
        for(int i = 1; i < 6; i++) {
            enemy = enemies[i - 1];

            nameID = "info_enemy_" + i + "_name";
            name = findViewById(getResources().getIdentifier(nameID, "id", getPackageName()));
            name.setText(enemy.getName() + " " + enemy.getTilt());

            iconID = "info_enemy_" + i + "_icon";
            icon = findViewById(getResources().getIdentifier(iconID, "id", getPackageName()));
            icon.setImageResource(R.drawable.icon);

            reasons = enemy.getReasons();
            reasonsID = "info_enemy_" + i + "_reasons";
            reasonView = findViewById(getResources().getIdentifier(reasonsID, "id", getPackageName()));
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < 3; j++) {
                builder.append("  ");
                builder.append(reasons[j]);
                builder.append("\n");
            }
            reasonView.setText(builder.toString());
        }
    }
}
