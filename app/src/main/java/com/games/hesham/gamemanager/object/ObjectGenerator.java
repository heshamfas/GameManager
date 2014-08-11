package com.games.hesham.gamemanager.object;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Hesham on 8/9/2014.
 */
public class ObjectGenerator {

   static final String[] gameConsole = {"Play Station", "XBox One", "PlayStation 4", "Atary", "Wii U"};
    static final String[] gameName = {
            "Metal Gear Rising Revengeance",
            "Dead Space 3",
            "Aliens: Colonial Marines",
            "Crysis 3" ,
            "Rayman Legends",
            "One Piece: Pirate – Warriors launch trailer",
            "Transformers Prime Wii U Rivalries Trailer",
            "Assassin’s Creed III Connor Story Trailer"
    };
   static final String[] imageUrl = {
           "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2013/05/the-last-of-us-video-game.jpg",
            "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2013/04/Injustice-Gods-Among-Us-video-game.jpg",
            "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/10/halo-4.jpg",
            "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/09/World-Of-Warcraft-Mists-Of-Pandaria.jpg",
           "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/10/Featured_Halo4.jpg",
           "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/08/cs1.jpg",
           "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/07/feature-sleeping-dogs-artwork-600x300.jpg",
           "http://publisher.dailymotion.com/watchlist/wp-content/uploads/2012/05/heroesofruin.jpg"

    };

    public static  ArrayList<GameObject> generateGameObject(){
        ArrayList<GameObject>  games = new ArrayList<GameObject>();
        for(int i = 0; i<gameName.length; i++){
            int math = (int)(Math.random()* gameConsole.length-1);
            String consoleName = gameConsole[math];
            String game = gameName[i];
            String imageURL = imageUrl[i];
            double finished = ((Math.random()));
            long lFinished = Math.round(finished);
            boolean gameFinished  = (int)lFinished == 0?false:true;
            Log.d(ObjectGenerator.class.getSimpleName() ," GameFinished is :"+ gameFinished);
            GameObject gameObj = new GameObject(game,consoleName,imageURL,gameFinished);
            games.add(gameObj);
        }
        return games;
    }

}
