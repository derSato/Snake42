package com.snake42.States;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;
import com.snake42.Essentials.GameStateManager;
import com.snake42.Essentials.State;
import com.snake42.Objects.Apple;
import com.snake42.Objects.Snake;

import java.util.ArrayList;

/**
 * Created by satoa on 11/30/2017.
 */

public class GameState extends State{

    private boolean doZoom;
    private float DURATION_ONE_TICK = 0.08f;
    private final float ZOOMSPEED = 0.1f;
    float OLDSIZEX,OLDSIZEY;
    boolean gameOver;

    //Objects
    ArrayList<Snake> snakes = new ArrayList<Snake>();
    Apple apple;


    ShapeRenderer shapeRenderer;


    public GameState(GameStateManager gsm) {
        super(gsm);
        doZoom = false;
        gameOver = false;
        snakes.add(new Snake(new int[]{Input.Keys.RIGHT, Input.Keys.LEFT, Input.Keys.UP, Input.Keys.DOWN}, //Player 1
                -5,
                2,
                Snake.Richtung.RIGHT,
                Color.BLUE));
        snakes.add(new Snake(new int[]{Input.Keys.D, Input.Keys.A, Input.Keys.W, Input.Keys.S},             //Player 2
                -5,
                10,
                Snake.Richtung.RIGHT,
                Color.GREEN));
        snakes.add(new Snake(new int[]{Input.Keys.L, Input.Keys.J, Input.Keys.I, Input.Keys.K},             //Player 2
                -5,
                15,
                Snake.Richtung.RIGHT,
                Color.YELLOW));

        apple = new Apple();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(Assets.camera.combined);
        shapeRenderer.setColor(Color.RED);
    }

    float tick = 0;
    @Override
    public void update(float dt) {
        //check if someone pressed a key or clicked something
        checkForInput();

        if ((tick += dt) > DURATION_ONE_TICK){ //Only every tick

            //update all GameOBJECTS
            for (Snake s : snakes) {
                if(s.isAlive())
                    s.update();
            }

            //Collision - detection
            checkForCollision();

            tick = 0;
        }
        if(doZoom){
            OLDSIZEX+=ZOOMSPEED;
            OLDSIZEY+=ZOOMSPEED;
            if(OLDSIZEX>=Assets.AMT_OF_TILES_X){
                OLDSIZEX = Assets.AMT_OF_TILES_X;
                OLDSIZEY = Assets.AMT_OF_TILES_Y;
                doZoom = false;
            }
            Assets.camera.setToOrtho(true,OLDSIZEX,OLDSIZEY);
            Assets.camera.update();
            shapeRenderer.setProjectionMatrix(Assets.camera.combined);
        }
        if(Gdx.input.justTouched()&&gameOver)
            gsm.set(new MenuState(gsm));
    }

    @Override
    public void render() {
        //draw the Objects on the screen
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Snake s : snakes) {
            if(s.isAlive())
                s.render(shapeRenderer);
        }
        apple.render(shapeRenderer);
        shapeRenderer.end();


    }
    public void checkForCollision(){

        for (int i = 0; i < snakes.size(); i++) {
            if(snakes.get(i).isAlive()){
                Vector2 head = snakes.get(i).getPosition().get(snakes.get(i).getPosition().size()-1);
                //COLLISION HEAD APPLE
                if(head.x == apple.getPosition().x && head.y == apple.getPosition().y){
                    apple.newApple();
                    snakes.get(i).increaseSize();
                    doZoom = true;
                    OLDSIZEX = Assets.AMT_OF_TILES_X;
                    OLDSIZEY = Assets.AMT_OF_TILES_Y;
                    Assets.updateGameSize(5);
                    DURATION_ONE_TICK-=0.002f;
                }

                //COLLISION HEAD - BODYPART
                //To check if one Player lost, we check only the head of his snake if it collides with any other snakePart
                for (Snake p : snakes) {
                    if (p.isAlive()){
                        for(Vector2 snakePart : p.getPosition()){
                            if(snakePart != head){
                                if (head.x == snakePart.x && head.y == snakePart.y){
                                    snakes.get(i).setAlive(false);
                                    gameOver = true;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void checkForInput(){ //All Input that happens in GameState is registered here

        for (Snake s : snakes) {
            if(s.isAlive())
                s.input();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){ //Normally key get checked here
            System.out.println("ESC");
        }

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
