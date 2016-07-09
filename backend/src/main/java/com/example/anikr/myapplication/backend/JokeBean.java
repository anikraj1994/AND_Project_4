package com.example.anikr.myapplication.backend;

import com.example.JokeProvider;

public class JokeBean {
    private JokeProvider joke;

    public JokeBean(){
        joke=new JokeProvider();
    }
    public JokeProvider getJoke() {
        return joke;
    }

    public void setJoke(JokeProvider joke) {
        this.joke = joke;
    }
}
