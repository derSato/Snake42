package com.snake42.Essentials;

import java.util.Stack;

/**
 * Created by satoa on 11/30/2017.
 */

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State s) {
        states.push(s);
    }

    public void pop() {
        states.peek().dispose();
        states.pop();
    }

    public void set(State s) {
        pop();
        states.push(s);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render() {
        states.peek().render();
    }
}
