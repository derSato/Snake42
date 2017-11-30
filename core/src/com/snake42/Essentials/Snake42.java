package com.snake42.Essentials;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.snake42.States.IntroState;

public class Snake42 extends ApplicationAdapter {

    public static final java.lang.String TITLE = "Snake42";
    private com.snake42.Essentials.GameStateManager gsm;


    @Override
    public void create() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        gsm = new com.snake42.Essentials.GameStateManager();
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
