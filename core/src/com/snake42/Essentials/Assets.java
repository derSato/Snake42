package com.snake42.Essentials;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by satoa on 11/30/2017.
 */

public class Assets {

    public static final int AMT_OF_TILES_X = 40;
    public static int AMT_OF_TILES_Y;
    public static OrthographicCamera camera;

    public static BitmapFont tight, bold;

    public static void initBeforeIntro() {
        bold = new BitmapFont(Gdx.files.internal("Bold.fnt"));
        tight = new BitmapFont(Gdx.files.internal("Short.fnt"));
    }
    public static void init() {
        AMT_OF_TILES_Y = Gdx.graphics.getHeight()/ (Gdx.graphics.getWidth()/ AMT_OF_TILES_X);
        camera = new OrthographicCamera();
        camera.setToOrtho(true,AMT_OF_TILES_X,AMT_OF_TILES_Y);
        camera.update();
    }
    public static void dispose() {
        bold.dispose();
        tight.dispose();
    }

}
