/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble.score;

import java.util.Scanner;

/**
 *
 * @author alwandy
 */
public class ScrabbleScore {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ScrabbleScoreView view = new ScrabbleScoreView();
        ScrabbleScorePresenter presenter = new ScrabbleScorePresenter(view);
        
        view.setPresenter(presenter);
        view.showInput();
    }
}
