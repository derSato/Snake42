package com.snake42.Objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;

import java.util.ArrayList;

/**
 * Created by Leonard on 30.11.2017.
 */

public class Snake {

    private final int NUMBER_OF_STARTPIECES = 3; //How many parts has the snake at start

    private ArrayList<Vector2> position;
    private Richtung richtung;
    private Color color;

    public Snake(){
        init();
    }

    private void init(){
        richtung = Richtung.RIGHT;
        position = new ArrayList<Vector2>();
        color = Color.RED;
        for (int i = 0; i < NUMBER_OF_STARTPIECES; i++){
            position.add(new Vector2(2+i,2));
        }
    }

    public void update(float delta){

    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        for (Vector2 v : position) {
            shapeRenderer.rect(v.x,v.y,1,1);
        }
    }

    enum Richtung {RIGHT,LEFT,UP,DOWN};
}
