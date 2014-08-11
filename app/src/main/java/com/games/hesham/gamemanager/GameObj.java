package com.games.hesham.gamemanager;

/**
 * Created by Hesham on 8/9/2014.
 */
public class GameObj {

    private String imageSource;
    private String console;
    boolean finished;
    public GameObj(String imageSource, String console, boolean finished){
        this.imageSource = imageSource;
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
