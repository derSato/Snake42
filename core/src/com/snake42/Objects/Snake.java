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
    private final float DURATION_ONE_TICK = 0.1f;

    private ArrayList<Vector2> position;
    private Richtung richtung;
    private Color color;

    public Snake(){
        init();
    }

    private void init(){
        richtung = Richtung.DOWN;
        position = new ArrayList<Vector2>();
        color = Color.RED;
        for (int i = 0; i < NUMBER_OF_STARTPIECES; i++){
            position.add(new Vector2(2+i,2));
        }
    }

    float tick = 0;
    public void update(float delta){
        if ((tick += delta) > DURATION_ONE_TICK){
            //---MOVE-------
            Vector2 temp = new Vector2(position.get(position.size()-1));
            position.remove(0);

            switch(richtung){
                case RIGHT: temp.x +=1;
                    break;
                case LEFT: temp.x -=1;
                    break;
                case UP: temp.y -=1;
                    break;
                case DOWN: temp.y +=1;
            }
            position.add(temp);
            tick = 0;
            //-------------
        }
    }

    public void input(Richtung key){
        richtung = key;
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        for (Vector2 v : position) {
            shapeRenderer.rect(v.x,v.y,1,1);
        }
    }

    public enum Richtung {RIGHT,LEFT,UP,DOWN};
}
