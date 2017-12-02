package com.snake42.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;

import java.util.ArrayList;

/**
 * Created by Leonard on 30.11.2017.
 */

public class Snake {

    private final int NUMBER_OF_STARTPIECES = 20; //How many parts has the snake at start

    private ArrayList<Vector2> position;
    private Richtung richtung;
    private Richtung lastMoveDirection; //to prevent movement into your own snake
    private Color color;
    private boolean alive; //Turns false, if snake crashes

    private int addBodyParts;

    private int[] keyes; //RIGHT LEFT UP DOWN

    public Snake(int[] keyes, int xStart, int yStart, Richtung richtungStart, Color color){
        init(keyes, xStart, yStart, richtungStart, color);
    }

    private void init(int[] keyes, int xStart, int yStart, Richtung richtungStart, Color color){
        this.keyes = keyes;                //Keyes that controll the movement of the snake
        richtung = richtungStart;           //the snake starts to move at this direction
        lastMoveDirection = richtungStart;
        position = new ArrayList<Vector2>();   //the positions of the bodyparts are stored here
        this.color = color;                 //Color of the snake
        for (int i = 0; i < NUMBER_OF_STARTPIECES; i++){   //positions are initilized
            if (richtungStart == Richtung.LEFT){
                position.add(new Vector2(xStart-i,yStart));
            }else{
                position.add(new Vector2(xStart+i,yStart));
            }
        }
        alive = true;
        addBodyParts = 0;
    }


    public void update(){
        //---MOVE-------
        Vector2 temp = new Vector2(position.get(position.size()-1));
        if(addBodyParts <= 0){
            position.remove(0);
        }else{
        //dont remove the last bodypart to increase the size
            addBodyParts--;
        }

        switch(richtung){
            case RIGHT: temp.x +=1;
                lastMoveDirection = Richtung.RIGHT;
                break;
            case LEFT: temp.x -=1;
                lastMoveDirection = Richtung.LEFT;
                break;
            case UP: temp.y -=1;
                lastMoveDirection = Richtung.UP;
                break;
            case DOWN: temp.y +=1;
                lastMoveDirection = Richtung.DOWN;
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
        //-------------

    }

    public void input(){
        if (Gdx.input.isKeyJustPressed(keyes[0]) && lastMoveDirection != Richtung.LEFT){
            richtung = Richtung.RIGHT;
        }
        if (Gdx.input.isKeyJustPressed(keyes[1]) && lastMoveDirection != Richtung.RIGHT){
            richtung = Richtung.LEFT;
        }
        if (Gdx.input.isKeyJustPressed(keyes[2]) && lastMoveDirection != Richtung.DOWN){
            richtung = Richtung.UP;
        }
        if (Gdx.input.isKeyJustPressed(keyes[3]) && lastMoveDirection != Richtung.UP){
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
    public void increaseSize(){
        addBodyParts+=10;
    }

    public ArrayList<Vector2> getPosition() {
        return position;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public enum Richtung {RIGHT,LEFT,UP,DOWN};
}
