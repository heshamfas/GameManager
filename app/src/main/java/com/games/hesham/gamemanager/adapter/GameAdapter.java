package com.games.hesham.gamemanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.games.hesham.gamemanager.R;
import com.games.hesham.gamemanager.object.GameObject;

import java.util.ArrayList;

/**
 * Created by Hesham on 8/9/2014.
 */

public class GameAdapter extends BaseAdapter {
    ArrayList<GameObject> gameList = null;
    Context context;
    LayoutInflater inflater;

    public GameAdapter(Context c ,ArrayList<GameObject> gameList){
        this.gameList = (ArrayList<GameObject>) gameList;
        this.context = c;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View gameView, ViewGroup parent) {

        GameObject currentGameObject = gameList.get(position);

        GameViewHolder gameViewHolder;
        if(gameView == null){
            gameView =  inflater.inflate(R.layout.list_item,null);
            gameViewHolder = new GameViewHolder();
            gameViewHolder.consoleNameTV = (TextView)gameView.findViewById(R.id.console_nameTV);
            gameViewHolder.gameImage = (ImageView)gameView.findViewById(R.id.game_imageIV);
            gameViewHolder.gameNameTV = (TextView)gameView.findViewById(R.id.game_nameTV);
            gameViewHolder.gameFinished = (CheckBox)gameView.findViewById(R.id.game_finishedCB);
            gameViewHolder.gameRating = (RatingBar)gameView.findViewById(R.id.game_ratingRB);
            gameView.setTag(gameViewHolder);
        }else{
            gameViewHolder = (GameViewHolder)gameView.getTag();
        }
        gameViewHolder.consoleNameTV.setText(currentGameObject.getConsole());
        gameViewHolder.gameNameTV.setText(currentGameObject.getGame());
        gameViewHolder.gameFinished.setChecked(currentGameObject.isFinished());
        gameViewHolder.gameRating.setRating(5);
        // gameViewHolder.gameImage.setImageBitmap();

        //gameViewHolder.gameImage = currentGameObject.get
        return gameView;
    }

    private static class GameViewHolder {
        TextView consoleNameTV;
        TextView gameNameTV;
        CheckBox gameFinished;
        ImageView gameImage;
        RatingBar gameRating;
    }

}

