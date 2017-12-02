package com.snake42.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;

import java.util.ArrayList;

/**
 * Created by Leonard on 30.11.2017.
 */

public class Snake {

    private final int NUMBER_OF_STARTPIECES = 30; //How many parts has the snake at start
    private final float DURATION_ONE_TICK = 0.1f;

    private ArrayList<Vector2> position;
    private Richtung richtung;
    private Color color;

    private int[] keyes; //RIGHT LEFT UP DOWN

    public Snake(int[] keyes, int xStart, int yStart, Richtung richtungStart, Color color){
        init(keyes, xStart, yStart, richtungStart, color);
    }

    private void init(int[] keyes, int xStart, int yStart, Richtung richtungStart, Color color){
        this.keyes = keyes;                //Keyes that controll the movement of the snake
        richtung = richtungStart;           //the snake starts to move at this direction
        position = new ArrayList<Vector2>();   //the positions of the bodyparts are stored here
        this.color = color;                 //Color of the snake
        for (int i = 0; i < NUMBER_OF_STARTPIECES; i++){   //positions are initilized
            if (richtungStart == Richtung.LEFT){
                position.add(new Vector2(xStart-i,yStart));
            }else{
                position.add(new Vector2(xStart+i,yStart));
            }
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
            //check if snake is out of boundaries
            if (temp.x > Assets.AMT_OF_TILES_X-1)
                temp.x = 0;
            if (temp.x < 0)
                temp.x = Assets.AMT_OF_TILES_X-1;
            if (temp.y > Assets.AMT_OF_TILES_Y-1)
                temp.y = 0;
            if (temp.y < 0)
                temp.y = Assets.AMT_OF_TILES_Y-1;
            position.add(temp);
            tick = 0;
            //-------------
        }
    }

    public void input(){
        if (Gdx.input.isKeyJustPressed(keyes[0])){
            richtung = Richtung.RIGHT;
        }
        if (Gdx.input.isKeyJustPressed(keyes[1])){
            richtung = Richtung.LEFT;
        }
        if (Gdx.input.isKeyJustPressed(keyes[2])){
            richtung = Richtung.UP;
        }
        if (Gdx.input.isKeyJustPressed(keyes[3])){
            richtung = Richtung.DOWN;
        }
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        for (int i = 0; i < position.size(); i++) {
            shapeRenderer.rect(position.get(i).x,position.get(i).y,1,1);
            if (i == position.size()-1) {
                shapeRenderer.setColor(Color.BLACK);
                if(richtung == Richtung.UP || richtung == Richtung.DOWN){
                    shapeRenderer.rect(position.get(i).x+0.2f,position.get(i).y+0.4f,0.2f,0.2f);
                    shapeRenderer.rect(position.get(i).x+0.6f,position.get(i).y+0.4f,0.2f,0.2f);
                }else{
                    shapeRenderer.rect(position.get(i).x+0.4f,position.get(i).y+0.2f,0.2f,0.2f);
                    shapeRenderer.rect(position.get(i).x+0.4f,position.get(i).y+0.6f,0.2f,0.2f);
                }
            }
        }
    }

    public enum Richtung {RIGHT,LEFT,UP,DOWN};
}
