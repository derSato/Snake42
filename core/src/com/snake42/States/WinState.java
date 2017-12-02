package com.snake42.States;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.snake42.Essentials.Assets;
import com.snake42.Essentials.GameStateManager;

/**
 * Created by Leonard on 02.12.2017.
 */

public class WinState extends MenuState {
    int winner;

    public WinState(GameStateManager gsm, int winner){
        super(gsm);
        this.winner = winner+1; //The Number starts at 1, instead of 0
    }
    @Override
    public void render() {
        spriteBatch.begin();
        Assets.tight.draw(spriteBatch,"d",Assets.AMT_OF_TILES_X/2 - 10, 10);
        spriteBatch.end();
    }
}
