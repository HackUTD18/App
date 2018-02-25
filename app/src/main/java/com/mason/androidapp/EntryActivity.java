package com.mason.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class EntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setup();
        Intent mainIntent = new Intent(this, MainActivity.class);
        this.startActivity(mainIntent);
    }

    private void setup() {
        LookupManager.ref = new LookupManager();
    }
}