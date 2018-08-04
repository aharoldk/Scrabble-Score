package scrabble.score;


import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alwandy
 */
public class ScrabbleScoreView implements ScrabbleScoreInterface {
    private final Scanner scan = new Scanner(System.in);
    private ScrabbleScorePresenter presenter;
    
    @Override
    public void showScore(int score) {
        System.out.format("\n\n %d", score);
    }   

    public ScrabbleScorePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(ScrabbleScorePresenter presenter) {
        this.presenter = presenter;
    }
    
    @Override
    public void showInput() {
        System.out.println("Sample Input");
        System.out.println("1. Letter");
        System.out.println("2. Word");
        System.out.println("3. Normal");
        
        String input = scan.next();
        
        presenter.checkInput(input);
    }

    @Override
    public void showInputDoubleTriple() {
        System.out.println("Letter/Word");
        System.out.println("1. Double");
        System.out.println("2. Triple");
        
        String input = scan.next();
        
        presenter.checkInput1(input);
    }

    @Override
    public void showInputWord() {
        System.out.print("Your Word : ");
        
        String input = scan.next();
        
        presenter.checkInput2(input);
    }

    @Override
    public void showLine(int length) {
        System.out.println("Your Letter (1 - "+ length +"): ");
        
        String input = scan.next();
        
        presenter.checkLetterScrableScore(input, length);
    }
    
}
