package com.mason.androidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RequestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        String summonerName = LookupManager.ref.getSummonerName();

        String url = getString(R.string.host) + "/name/" + summonerName;
        System.out.println("HTTP GET: " + url);
        RequestQueue queue = Volley.newRequestQueue(this);

        Context context = getApplicationContext();
        CharSequence player_error = "Cannot find that player!";
        CharSequence server_down = "Our servers are down! Try again later.";
        int duration = Toast.LENGTH_LONG;
        final Toast error_player = Toast.makeText(context, player_error, duration);
        final Toast error_server = Toast.makeText(context, server_down, duration);

        final Intent infoIntent = new Intent(this, MatchInfoActivity.class);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("\"Player Error\"\n")) {
                    System.out.println("Player Errored! Going Back.");
                    error_player.show();
                    finish();
                } else {
                    LookupManager.ref.handleResponse(response);
                    System.out.println(response);
                    startActivity(infoIntent);
                    finish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                error_server.show();
                finish();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 10, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}
