package com.snake42.States;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        snake.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
