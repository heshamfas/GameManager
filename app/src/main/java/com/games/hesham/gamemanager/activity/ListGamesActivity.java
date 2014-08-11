package com.games.hesham.gamemanager.activity;

import com.games.hesham.gamemanager.ActionItemClickedListener;
import com.games.hesham.gamemanager.ActivityType;
import com.games.hesham.gamemanager.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ListGamesActivity extends Activity {
    public static ActivityType activityType = ActivityType.LIST;
    public static ActionItemClickedListener menuListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
    }

public static void addActionItemClickListener(ActionItemClickedListener listener){
    menuListener = listener;
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add) {
            menuListener.onActionItemClicked(item);
            return true;
        }else if(id == R.id.action_back){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }




}
