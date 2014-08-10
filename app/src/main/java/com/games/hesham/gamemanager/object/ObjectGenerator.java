package com.games.hesham.gamemanager.object;

import java.util.ArrayList;

/**
 * Created by Hesham on 8/9/2014.
 */
public class ObjectGenerator {

    String[] gameConsole = {"Play Station", "XBox One", "PlayStation 4", "Atary", "Wii U"};
    String[] gameName = {"Hesham", "Sally", "Envoy wasted my time", "Distruction of Envoy" };
    String[] imageUrl = {
            "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Wii_U_Console_and_Gamepad.png/120px-Wii_U_Console_and_Gamepad.png",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Wii_U_Console_and_Gamepad.png/120px-Wii_U_Console_and_Gamepad.png",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Wii_U_Console_and_Gamepad.png/120px-Wii_U_Console_and_Gamepad.png",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Wii_U_Console_and_Gamepad.png/120px-Wii_U_Console_and_Gamepad.png"
    };

    public ArrayList<GameObject> generateGameObject(){
        ArrayList<GameObject>  games = new ArrayList<GameObject>();
        for(int i = 0; i<gameName.length; i++){
            int math = 0 + (int)(Math.random()* gameConsole.length-1);
            String consoleName = gameConsole[math];
            String game = gameName[i];
            String imageURL = imageUrl[i];
            GameObject gameObj = new GameObject(game,consoleName,imageURL,false);
            games.add(gameObj);
        }
        return games;
    }

}
