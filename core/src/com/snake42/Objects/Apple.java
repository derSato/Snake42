package com.snake42.Objects;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.snake42.Essentials.Assets;

/**
 * Created by Leonard on 02.12.2017.
 */

public class Apple {
    private final Color color = Color.RED;

    private Vector2 position;

    public Apple(){
        position = new Vector2();
        newApple();
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        shapeRenderer.rect(position.x,position.y,1,1);
    }

    public void newApple(){
        position.x = (int) (Math.random()* Assets.AMT_OF_TILES_X);
        position.y = (int) (Math.random()* Assets.AMT_OF_TILES_Y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
