package com.snake42.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake42.Essentials.Assets;
import com.snake42.Essentials.GameStateManager;
import com.snake42.Essentials.State;
import com.snake42.Objects.Snake;

/**
 * Created by satoa on 11/30/2017.
 */

public class GameState extends State{

    Snake snake;
    ShapeRenderer shapeRenderer;

    public GameState(GameStateManager gsm) {
        super(gsm);
        snake = new Snake();
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
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0,0,1,1);
        shapeRenderer.rect(Assets.AMT_OF_TILES_X-1,0,1,1);
        shapeRenderer.rect(0,Assets.AMT_OF_TILES_Y-1,1,1);

        //snake.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
