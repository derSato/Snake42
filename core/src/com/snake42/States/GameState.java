package com.snake42.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake42.Essentials.Assets;
import com.snake42.Essentials.GameStateManager;
import com.snake42.Essentials.State;
import com.snake42.Objects.Snake;

import java.util.ArrayList;

/**
 * Created by satoa on 11/30/2017.
 */

public class GameState extends State{

    ArrayList<Snake> snakes = new ArrayList<Snake>();
    ShapeRenderer shapeRenderer;

    public GameState(GameStateManager gsm) {
        super(gsm);
        snakes.add(new Snake(new int[]{Input.Keys.RIGHT, Input.Keys.LEFT, Input.Keys.UP, Input.Keys.DOWN},
                2,
                2,
                Snake.Richtung.RIGHT,
                Color.BLUE));
        snakes.add(new Snake(new int[]{Input.Keys.D, Input.Keys.A, Input.Keys.W, Input.Keys.S},
                2,
                15,
                Snake.Richtung.LEFT,
                Color.GREEN));
        Gdx.gl.glClearColor(0, 0, 0, 1);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(Assets.camera.combined);
        shapeRenderer.setColor(Color.RED);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        //FIRST check if someone pressed a key or clicked something
        checkForInput();

        //SECOND update all GameOBJECTS
        for (Snake s :
                snakes) {
            s.update(Gdx.graphics.getDeltaTime());
        }

        //THIRD draw everything on the screen
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0,0,1,1);
        shapeRenderer.rect(Assets.AMT_OF_TILES_X-1,0,1,1);
        shapeRenderer.rect(0,Assets.AMT_OF_TILES_Y-1,1,1);
        for (Snake s :
                snakes) {
            s.render(shapeRenderer);
        }
        shapeRenderer.end();


    }

    public void checkForInput(){ //All Input that happens in GameState is registered here

        for (Snake s : snakes) {
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
