package com.snake42.Essentials;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by satoa on 11/30/2017.
 */

public abstract class State {
    protected com.snake42.Essentials.GameStateManager gsm;

    protected State(com.snake42.Essentials.GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update(float dt);

    public abstract void render();

    public abstract void dispose();


}

