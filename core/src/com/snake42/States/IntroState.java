package com.snake42.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake42.Assets;
import com.snake42.GameStateManager;
import com.snake42.State;

/**
 * Created by satoa on 11/30/2017.
 */

public class IntroState extends State {

    SpriteBatch spriteBatch;
    String title = "SaLeoProductions", undertilte = "Present NICHT";

    public IntroState(GameStateManager gsm) {
        super(gsm);
        spriteBatch = new SpriteBatch();
        Assets.initBeforeIntro();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        spriteBatch.begin();
        Assets.bold.draw()
        spriteBatch.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
