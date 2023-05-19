package pkg;
import java.util.*;
import java.io.*;

public class Mastermind {
	int numRows = 12;
	int numCol = 4;
	String[][] boardLeft = new String[numRows][numCol];
	String[][] boardRight = new String[numRows][numCol];
	String[] code;
	
	public Mastermind(){
	}
	
	public void startGame(){
		populateBoard();
		codeMaker();
		printRules();
		
		printBoard();
	}
	
	public void populateBoard(){
		for(String[] arr : boardLeft){
			for(String a : arr){
				a = " ";
			}
		}
		for(String[] arrr : boardRight){
			for(String c : arrr){
				c = " ";
			}
		}
	}
	public void codeMaker(){
		code = new String[6];
		for(String b : code){
			int i = (int)(Math.random()*6+1);
			if(i == 1){
				b = "1";
			}
			if(i == 2){
				b = "2";
			}
			if(i == 3){
				b = "3";
			}
			if(i == 4){
				b = "4";
			}
			if(i == 5){
				b = "5";
			}
			if(i == 6){
				b = "6";
			}
		}
	}
	public void printRules(){
		System.out.println("------------------------------WELCOME TO MASTERMIND------------------------------");
		System.out.println("A random code has been generated, and it is your job to break it.");
		System.out.println("The code contains 4 digits, and each digit is a random number from 1-6.");
		System.out.println("Numbers can repeat.");
		System.out.println("You have twelve attempts to guess the code.");
		System.out.println("After each guess, the right of the board will display the result of the guess.");
		System.out.println("An 'A' indicates that a correct number is in the correct place.");
		System.out.println("A 'B' indicates there is a correct number but in the wrong place.");
		System.out.println("A 'C' indicates the number does not appear in the code.");
		System.out.println("The letter results do not correspond to a specific digit.");
		System.out.println("Here are some examples:");
		System.out.println("Code: 1, 3, 5, 6. Guess: 4, 2, 5, 3. Result: A, B, C, C");
		System.out.println("Code: 1, 5, 2, 2. Guess: 3, 4, 1, 1. Result: A, C, C, C");
		System.out.println("Code: 1, 2, 3, 4. Guess: 4, 1, 5, 3. Result: B, B, B, C");
		System.out.println("Good Luck!");
		System.out.println("---------------------------------------------------------------------------------");
	}
	public void printBoard(){
		System.out.println(" ");
		System.out.println("Guess Board--------------------------Result Board");
		System.out.println(" ");
		for(int i = 0; i< numRows; i++){
			for(int j = 0; j < numCol; j++){
				System.out.print("["+ boardLeft[i][j] + "] ");
			}
			System.out.print("   ");
			for(int c = 0; c < numCol; c++){
				System.out.print("["+ boardRight[i][c] + "] ");
			}
		}
	}
	
}
	