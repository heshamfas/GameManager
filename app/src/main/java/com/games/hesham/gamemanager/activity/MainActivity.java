package com.games.hesham.gamemanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.games.hesham.gamemanager.R;


public class MainActivity extends Activity implements View.OnClickListener{
    Button mNavGameListBtn, mNavGameRatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mNavGameListBtn = (Button)findViewById(R.id.navi_game_listBtn);
        mNavGameRatingBtn = (Button)findViewById(R.id.navi_game_rateBtn);
        mNavGameRatingBtn.setOnClickListener(this);
        mNavGameListBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.navi_game_listBtn:
               intent = new Intent(this , ListGamesActivity.class);
               startActivity(intent);
               break;
            case R.id.navi_game_rateBtn:
                intent = new Intent(this, RateGameActivity.class);
                startActivity(intent);
                break;
        }
    }
}
