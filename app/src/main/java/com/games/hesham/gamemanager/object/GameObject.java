package com.games.hesham.gamemanager.object;

/**
 * Created by Hesham on 8/10/2014.
 */
public class GameObject {

    private String imageSource;
    private String game;
    private String console;
    boolean finished;
    public GameObject( String game, String console,String imageSource, boolean finished){
        this.imageSource = imageSource;
        this.game = game;
        this.console = console;
        this.finished = finished;
    }
    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
