package com.Player;

import java.util.ArrayList;

public abstract class Player {

    private String name; // => converted to private or access to it via getters and setters
    protected ArrayList<Integer> guesses = new ArrayList<>(); // Protected = Cannot be access via instance object
    // Any subclass that inherits this class has the protected field inherited as a field variable

    public abstract int makeGuess();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Integer> getGuesses(){
        return this.guesses;
    }

}
