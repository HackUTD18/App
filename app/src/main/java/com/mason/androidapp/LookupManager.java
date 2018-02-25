package com.mason.androidapp;


import org.json.JSONArray;
import org.json.JSONObject;

public class LookupManager {

    public static LookupManager ref;
    private String summonerName;
    private Enemy[] enemies;

    public LookupManager() {
        this.enemies = new Enemy[5];
    }


    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getSummonerName() {
        return this.summonerName;
    }

    public void handleResponse(String response) {
        JSONArray json;
        try {
            json = new JSONArray(response);
            JSONObject enemy;
            for(int i = 0; i < 5; i++) {
                enemy = json.getJSONObject(i);
                String name = enemy.getString("name");
                int champ = enemy.getInt("champion");
                int tilt = enemy.getInt("tilt");
                JSONArray reasonsJSON = enemy.getJSONArray("reasons");
                String[] reasons = new String[] {reasonsJSON.getString(0), reasonsJSON.getString(1), reasonsJSON.getString(2)};
                this.enemies[i] = new Enemy(name, champ, tilt, reasons);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Enemy[] getEnemies() {
        return enemies;
    }
}
