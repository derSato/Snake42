package com.snake42.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake42.Essentials.GameStateManager;
import com.snake42.Essentials.State;

/**
 * Created by satoa on 11/30/2017.
 */

public class MenuState extends State{
    SpriteBatch spriteBatch;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        spriteBatch = new SpriteBatch();
        Gdx.gl.glClearColor(0, 0, 1, 1);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        spriteBatch.begin();

        spriteBatch.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
