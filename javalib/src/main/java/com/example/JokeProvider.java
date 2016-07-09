package com.example;

import java.util.Random;

public class JokeProvider {
    private String[] Joke={"Why did the scientist install a knocker on his door? He wanted to win the No-bell prize!","What did one ocean say to the other ocean? Nothing, they just waved.","Joey: Paper...snow...a ghost!!!" };
    Random random = new Random();

    public JokeProvider(){
    }

    public String getJoke(){
        return Joke[random.nextInt(Joke.length)];
    }
}
