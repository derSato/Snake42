package com.snake42.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake42.Essentials.Assets;
import com.snake42.Essentials.GameStateManager;
import com.snake42.Essentials.State;

/**
 * Created by satoa on 11/30/2017.
 */

public class IntroState extends State {

    SpriteBatch spriteBatch;
    String title = "Present", undertilte = "SaLeoProductions";
    GlyphLayout glyphLayoutTight,glyphLayoutBold;
    float textAlpha;
    boolean isFadingIN,hasLoaded;

    public IntroState(GameStateManager gsm) {
        super(gsm);
        spriteBatch = new SpriteBatch();
        Assets.initBeforeIntro();
        Assets.tight.getData().setScale(0.5f);
        Assets.bold.getData().setScale(1.0f);
        glyphLayoutTight = new GlyphLayout(Assets.tight,title);
        glyphLayoutBold = new GlyphLayout(Assets.bold,undertilte);
        textAlpha = 0;
        isFadingIN = true;
        hasLoaded = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Assets.initBeforeGame();
                hasLoaded = true;
            }
        }).run();

    }

    @Override
    public void update(float dt) {
        if(textAlpha>1)
            isFadingIN = false;
        if(hasLoaded&&(textAlpha<0 || Gdx.input.justTouched()))
            gsm.set(new MenuState(gsm));
        if(!isFadingIN)
            dt*=-1;
        textAlpha+=dt*0.7f;
        Assets.tight.setColor(1,1,1,textAlpha);
        Assets.bold.setColor(1,1,1,textAlpha);
    }

    @Override
    public void render() {
        spriteBatch.begin();
        Assets.tight.draw(spriteBatch,title, Gdx.graphics.getWidth()/2-glyphLayoutTight.width/2,Gdx.graphics.getHeight()/2);
        Assets.bold.draw(spriteBatch,undertilte,Gdx.graphics.getWidth()/2-glyphLayoutBold.width/2,Gdx.graphics.getHeight()/2+glyphLayoutBold.height*1.1f);
        spriteBatch.end();
    }


    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
