package Feburary;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Hangman {
	public static String calcString(String Word,String guesses) {
		for (int i = 0;i<Word.length();i++) {
			if (!guesses.contains(String.valueOf(Word.charAt(i)))) {
				Word = Word.replace(Word.charAt(i), '-');
			}
		}
		
		
		return Word;
	}
	public static void main(String[] args) throws FileNotFoundException {
	//Scanner scanner = new Scanner(new File("C:\Users\moshi\OneDrive\Documents.alpha.txt"));
	Scanner r = new Scanner (System.in);
	//String[] words = new String[370000];
	//for (int i = 0;i<370000;i++) {
	//	String word = scanner.nextLine();
		//words[i] = word;
//	}
	
	int WrongCount = 0;
	String CurrentGuess = " ";
	String guesses = "";
	int RandomNumber = (int) (Math.random()*(370000-0) + 0);
	String word = "Stupid";
	boolean begining = true;
	while (!word.equals(CurrentGuess) ){
		if (begining) {
			System.out.println(" -------");
			System.out.println(" |     |");		
			System.out.println();
			System.out.println();
			System.out.println(calcString(word,guesses));
			begining = false;
		}
	System.out.println("Enter letter :");	
	String s = r.next();
	guesses += s.charAt(0);
    if (!word.contains(s)) {
    	WrongCount++;
    }
	if (WrongCount == 0 ||  WrongCount > 0) {
		System.out.println(" -------");
		System.out.println(" |     |");
	}
    if (WrongCount == 1 ||  WrongCount > 1 ) {
		System.out.println(" O");
	}
    if (WrongCount == 2 ||  WrongCount > 2 ) {
    	System.out.print("\\ ");
    }
    if (WrongCount == 3 ||  WrongCount > 3 ) {
    	System.out.println("/");
    }
    if (WrongCount == 4 ||  WrongCount > 4 ) {
    	System.out.println(" |");
    }
    if (WrongCount == 5 ||  WrongCount > 5 ) {
    	System.out.print("/ ");
    }
    if (WrongCount == 6 ||  WrongCount > 6 ) {
    	System.out.println("\\");
    	System.out.println("You lost! ,The word was : " + word);
    	break;
}


	System.out.println();
	System.out.println();
	CurrentGuess = calcString(word,guesses);
	System.out.println(CurrentGuess);
	if (CurrentGuess.equals(word)) {
		System.out.println("You win!");
	}
	System.out.println("Guess the word:");
	String WordGuess = r.next();
	if (WordGuess.equals(word)) {
		System.out.println();
		System.out.println("You win!");
		break;
	}
	else {
		System.out.println("Try again");
	}
	}
	
	
	}

}