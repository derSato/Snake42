package com.snake42;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake42.States.IntroState;

public class Snake42 extends ApplicationAdapter {

    public static final java.lang.String TITLE = "Snake42";
    private GameStateManager gsm;

    @Override
    public void create() {
        Gdx.gl.glClearColor(0,0, 0, 1);
        gsm = new GameStateManager();
        gsm.push(new IntroState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render();
    }

    @Override
    public void dispose() {
    }
}
