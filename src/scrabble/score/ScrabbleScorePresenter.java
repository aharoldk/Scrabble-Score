/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.score;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *ScrabbleScorePresenter.java:64
 * @author alwandy
 */
public class ScrabbleScorePresenter {

    private ScrabbleScoreView view;
    private HashMap<String, Integer> hashMap;
    private int letterword = 0;
    private int doubletriple = 0;
    private int iposition = 0;
    private String word;
    
    ScrabbleScorePresenter(ScrabbleScoreView view) {
        this.view = view;
        declareHashMap();
    }
    
    public void declareHashMap() {
        hashMap = new HashMap<String, Integer>();
        
        hashMap.put("A", 1);
        hashMap.put("E", 1);
        hashMap.put("I", 1);
        hashMap.put("O", 1);
        hashMap.put("L", 1);
        hashMap.put("N", 1);
        hashMap.put("R", 1);
        hashMap.put("S", 1);
        hashMap.put("T", 1);
        
        hashMap.put("D", 2);
        hashMap.put("G", 2);
        
        hashMap.put("B", 3);
        hashMap.put("C", 3);
        hashMap.put("M", 3);
        hashMap.put("P", 3);
        
        hashMap.put("F", 4);
        hashMap.put("H", 4);
        hashMap.put("V", 4);
        hashMap.put("W", 4);
        hashMap.put("Y", 4);
        
        hashMap.put("K", 5);
        
        hashMap.put("J", 8);
        hashMap.put("X", 8);
        
        hashMap.put("Q", 10);
        hashMap.put("Z", 10);
    }
    
    public void checkInput(String check){
        if(check.equals("1") || check.equals("2")){
           letterword = convertInt(check);
           view.showInputDoubleTriple();
           
        } else if(check.equals("3")){
            letterword = convertInt(check);
            view.showInputWord();
            
        } else {
            System.err.println("Your Input Cannot Defined");
            view.showInput();
        }
    }
    
    public void checkInput1(String check){
        if(!check.equals("1") && !check.equals("2")){
            System.err.println("Your Input Cannot Defined");
            view.showInputDoubleTriple();
            return;
        } 
        
        doubletriple = convertInt(check) + 1;
        view.showInputWord();
        
    }
    
    public void checkInput2(String check){
        if(checkString(check)){
            System.err.println("There's Number in Your Word");
            view.showInputWord();
            return;
        }
        
        int result = 0;
        word = check;
        switch (letterword) {
            case 1:
                view.showLine(word.length() + 1);
                break;
            case 2:
                result = checkNormalScrabbleScore(word) * doubletriple;
                break;
            case 3:
                result = checkNormalScrabbleScore(word);
                break;
            default:
                System.err.println("Your Input Cannot Defined");
                break;
        }
        
        view.showScore(result);
    }
    
    public void checkLetterScrableScore(String position, int length) {
        if(checkInt(position)){
            System.err.println("Check Your Input");
            view.showLine(length);
            return;
        }
        
        iposition = Integer.parseInt(position);
        if(iposition <= 0 || iposition > length){
            System.err.println("Check Your Input");
            view.showLine(length);
            return;
        }
        
        view.showScore(checkNormalScrabbleScore(word));
    }
    
    
    public int checkNormalScrabbleScore(String scrabbleWord) {
        
        int result = 0;
        for(int i = 0; i < scrabbleWord.length(); i++) {
            int resultMap = hashMap.get(String.valueOf(scrabbleWord.charAt(i)).toUpperCase());
            if(iposition > 0 && (iposition - 1) == i){
                resultMap *= doubletriple;
            }
            result += resultMap;
            
            System.err.format("%s %d\n", String.valueOf(scrabbleWord.charAt(i)).toUpperCase(), result);
        }
        
        return result;
    }
    
    public int convertInt(String s){
        return Integer.parseInt(s);
    }
    
    public boolean checkString(String s){
        Pattern p = Pattern.compile( "[0-9]" );
        Matcher m = p.matcher(s);
        
        return m.find();
    }
    
    public boolean checkInt(String s){
        Pattern p = Pattern.compile( "[A-Z]" );
        Matcher m = p.matcher(s);
        
        return m.find();
    }
    
}
