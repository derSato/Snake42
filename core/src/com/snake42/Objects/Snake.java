package com.snake42.Objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;

import java.util.ArrayList;

/**
 * Created by Leonard on 30.11.2017.
 */

public class Snake {

    private final int NUMBER_OF_STARTPIECES = 3; //How many parts has the snake at start
    private final float TIME_FOR_ONE_TICK = 1;

    private ArrayList<Vector2> position;
    private Richtung richtung;

    public Snake(){
        init();
    }

    private void init(){
        richtung = Richtung.RIGHT;
        position = new ArrayList<Vector2>();
        for (int i = 0; i < NUMBER_OF_STARTPIECES; i++){
            position.add(new Vector2(2+i,2));
        }
        timePassed = 0;
    }

    float timePassed;   //Wenn diese Variable den Wert in TIME_FOR_ONE_TICK erreicht hat gibt es einen Tick
    public void update(float delta){
        timePassed+=delta;
        if(timePassed > TIME_FOR_ONE_TICK){
            for (Vector2 v : position) {
                v.x += (Assets.MAX_WIDTH_HEIGHT/Assets.NUMBER_OF_TILES);
            }
            timePassed = 0;
        }

    }

    public void render(ShapeRenderer shapeRenderer){
        for (Vector2 v : position) {
            shapeRenderer.rect(v.x * Assets.MAX_WIDTH_HEIGHT/Assets.NUMBER_OF_TILES,
                                v.y* Assets.MAX_WIDTH_HEIGHT/Assets.NUMBER_OF_TILES,
                                Assets.MAX_WIDTH_HEIGHT/Assets.NUMBER_OF_TILES,
                                Assets.MAX_WIDTH_HEIGHT/Assets.NUMBER_OF_TILES);
        }
    }

    enum Richtung {RIGHT,LEFT,UP,DOWN};
}
