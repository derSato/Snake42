package com.snake42;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by satoa on 11/30/2017.
 */

public class Assets {

    public static final int NUMBER_OF_TILES = 40;
    public static final int MAX_WIDTH_HEIGHT = 900;

    public static BitmapFont tight, bold;

    public static void init() {
        tight = new BitmapFont(Gdx.files.internal("Short.fnt"));
        bold = new BitmapFont(Gdx.files.internal("Bold.fnt"));
    }

}
