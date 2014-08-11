package com.games.hesham.gamemanager.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.games.hesham.gamemanager.ActivityType;
import com.games.hesham.gamemanager.GameManager;
import com.games.hesham.gamemanager.R;
import com.games.hesham.gamemanager.object.GameObject;

import java.util.ArrayList;

/**
 * Created by Hesham on 8/9/2014.
 */

public class GameAdapter extends BaseAdapter implements ListAdapter    {
    ArrayList<GameObject> gameList = null;
    Context context;
    ActivityType activityType;
    LayoutInflater inflater;
    ImageLoader imageLoader = GameManager.getImageLoader();


    public GameAdapter(Context c ,ArrayList<GameObject> gameList, ActivityType activityType){
        super();
        this.gameList = (ArrayList<GameObject>) gameList;
        this.context = c;
        this.activityType = activityType;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
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
        gameViewHolder.gameRating.setEnabled(true);
        gameViewHolder.gameRating.setRating(1 + (int)Math.random()*5);
        if(activityType == ActivityType.LIST){
            gameViewHolder.gameFinished.setVisibility(View.VISIBLE);
        }else{
            gameViewHolder.gameRating.setVisibility(View.VISIBLE);
        }
        String imageUrl = gameList.get(position).getImageSource();
            // gameViewHolder.gameImage.setImageBitmap();
        imageLoader.get(imageUrl, ImageLoader.getImageListener(gameViewHolder.gameImage, R.drawable.ic_launcher, R.drawable.ic_launcher));
        //gameViewHolder.gameImage = currentGameObject.get
        return gameView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return gameList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    private static class GameViewHolder {
        TextView consoleNameTV;
        TextView gameNameTV;
        CheckBox gameFinished;
        ImageView gameImage;
        RatingBar gameRating;
    }

}

