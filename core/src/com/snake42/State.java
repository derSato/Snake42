package com.snake42;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by satoa on 11/30/2017.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public abstract void update(float dt);

    public abstract void render();

    public abstract void handleInput();

    public abstract void dispose();


}

