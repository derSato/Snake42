package com.snake42.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Leonard on 30.11.2017.
 */

public class Snake {

    private final int NUMBER_OF_STARTPIECES = 3; //How many parts has the snake at start

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
    }

    public void update(float delta){

    }

    public void render(ShapeRenderer shapeRenderer){
        for (Vector2 v : position) {

        }
    }

    enum Richtung {RIGHT,LEFT,UP,DOWN};
}
