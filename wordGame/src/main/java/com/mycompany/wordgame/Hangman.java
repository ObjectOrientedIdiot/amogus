/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordgame;

import java.util.ArrayList;

public class Hangman {
    
    private String answer;
    private Character[] current;
    ArrayList<Character> guessedChars = new ArrayList<>();
    private int guesses = 0;
    private int guessLimit = 0;
    private boolean win=false;

    public void guess(char g){
        if(guessedChars.contains(g)){ //disallows duplicate guesses
            System.out.println("Duplicate guess");
            return;
        } else {
            guessedChars.add(g);
        }
        int cPos = answer.indexOf(g); //position of character
        if(cPos==-1){
            System.out.println("Wrong");
        } else {
            regGuess(g, -1);
        }
        updateGuessCounter();
    }
    
    public void guessWord(String s){
        if(s.equals(answer)){
//           current = answer.toCharArray();
        }
        updateGuessCounter();
    }
    
    private void updateGuessCounter(){
        guesses++;
        if(guesses >= guessLimit){
            //end game
        }
    }

    private void regGuess(char c, int start){//puts guessed char in current for display
        int currentPos = answer.indexOf(String.valueOf(c), start);
        if(currentPos != -1){
            current[currentPos] = c;
            regGuess(c, currentPos+1);
        }
    }

    public String toString(){
        String out = "";
        for(int i=0; i<current.length; i++){
            if(current[i]==null){
                out+="_";
            }else {
                out+=current[i];
            }
        }
        return out;
    }
    
    public int getGuesses(){
        return guesses;
    }
    
    public int getGuessLimit(){
        return guessLimit;
    }
    
    public Hangman(String word, int guessLimit){
        this.answer = word;
        this.current = new Character[word.length()];
        this.guesses = 0;
        this.guessLimit = guessLimit;

        regGuess(' ', -1);
    }

}