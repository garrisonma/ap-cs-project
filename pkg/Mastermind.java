package pkg;
import java.util.*;
import java.io.*;

public class Mastermind {
	int numRows = 12;
	int numCol = 4;
	String[][] boardLeft = new String[numRows][numCol];
	String[][] boardRight = new String[numRows][numCol];
	String[] code;
	String realCode;
	int currentRow = 0;
	
	public Mastermind(){
	}
	
	public void startGame(){
		populateBoard();
		codeMaker();
		printRules();
		printBoard();
		guess();
	}
	
	public void populateBoard(){
		for(int i = 0; i < boardLeft.length; i++){
			for(int j = 0; j < boardLeft[0].length; j++){
				boardLeft[i][j] = " ";
			}
		}
		for(int i = 0; i < boardRight.length; i++){
			for(int j = 0; j < boardRight[0].length; j++){
				boardRight[i][j] = " ";
			}
		}
	}
	public void codeMaker(){
		realCode = "";
		code = new String[4];
		for(int c = 0; c < 4; c++){
			int i = (int)(Math.random()*6+1);
			if(i == 1){
				code[c] = "1";
				realCode += "1";
			}
			if(i == 2){
				code[c] = "2";
				realCode += "2";
			}
			if(i == 3){
				code[c] = "3";
				realCode += "3";
			}
			if(i == 4){
				code[c] = "4";
				realCode += "4";
			}
			if(i == 5){
				code[c] = "5";
				realCode += "5";
			}
			if(i == 6){
				code[c] = "6";
				realCode += "6";
			}
		}
		
	}
	public void printRules(){
		System.out.println(" ");
		System.out.println("------------------------------WELCOME TO MASTERMIND------------------------------");
		System.out.println(" ");
		System.out.println("A random code has been generated, and it is your job to break it!");
		System.out.println("The code contains 4 digits, and each digit is a random number from 1-6.");
		System.out.println("Numbers can repeat.");
		System.out.println("You have twelve attempts to guess the code.");
		System.out.println("After each guess, the right of the board will display the result of the guess.");
		System.out.println("An 'A' indicates that a correct number is in the correct place.");
		System.out.println("A 'B' indicates there is a correct number but in the wrong place.");
		System.out.println("A empty space indicates the number does not appear in the code.");
		System.out.println("The letter results do not correspond to a specific digit.");
		System.out.println("Here are some examples:");
		System.out.println("Code: 1, 3, 5, 6. Guess: 4, 2, 5, 3. Result: A, B");
		System.out.println("Code: 1, 5, 2, 2. Guess: 3, 4, 1, 1. Result: A");
		System.out.println("Code: 1, 2, 3, 4. Guess: 4, 1, 5, 3. Result: B, B, B");
		System.out.println("Good Luck!");
	}
	public void printBoard(){
		System.out.println(" ");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("  Guess Board        Result Board");
		System.out.println(" ");
		for(int i = 0; i< numRows; i++){
			for(int j = 0; j < numCol; j++){
				System.out.print("["+ boardLeft[i][j] + "] ");
			}
			System.out.print("   ");
			for(int c = 0; c < numCol; c++){
				System.out.print("["+ boardRight[i][c] + "] ");
			}
			System.out.println(" ");
		}
		System.out.println("---------------------------------------------------------------------------------");
	}
	public void guess(){
		Scanner sc = new Scanner(System.in);
		String x = "placeholder";
		while(true){
		while(true){
		System.out.println("Please enter a guess: ");
		x = sc.nextLine();
		if(x.length() == 4){
			if(x.substring(0,1).equals("1") || x.substring(0,1).equals("2") || x.substring(0,1).equals("3") || x.substring(0,1).equals("4") || x.substring(0,1).equals("5") || x.substring(0,1).equals("6")){
				if(x.substring(1,2).equals("1") || x.substring(1,2).equals("2") || x.substring(1,2).equals("3") || x.substring(1,2).equals("4") || x.substring(1,2).equals("5") || x.substring(1,2).equals("6")){
					if(x.substring(2,3).equals("1") || x.substring(2,3).equals("2") || x.substring(2,3).equals("3") || x.substring(2,3).equals("4") || x.substring(2,3).equals("5") || x.substring(2,3).equals("6")){
						if(x.substring(3,4).equals("1") || x.substring(3,4).equals("2") || x.substring(3,4).equals("3") || x.substring(3,4).equals("4") || x.substring(3,4).equals("5") || x.substring(3,4).equals("6")){
							break;
						}
					}
				}
			}
			
		}
		System.out.println("Code is in an incorrect format. Please try again with a combination of 4 digits from 1-6.");
		}
		if(realCode.contains(x)){
			for(int i = 0; i < 4; i++){
				boardLeft[currentRow][i] = x.substring(i,i+1);
				boardRight[currentRow][i] = "A";
			}
			printBoard();
			System.out.println("Congratulations! You've cracked the code.");
			return;
		}
		for(int i = 0; i < 4; i++){
				boardLeft[currentRow][i] = x.substring(i,i+1);
		}
		String b = code[0];
		String c = code[1];
		String d = code[2];
		String e = code[3];
		String realResult = "";
		for(int a = 0; a<4; a++){
			String m = x.substring(a, a+1);
			if(realCode.contains(m)){
				
				if(m.equals(b)){
					if(a == 0){
					realResult += "A";
					}
					else{
						realResult += "B";
					}
					b = "no";
				}
				else if(m.equals(c)){
					if(a == 1){
					realResult += "A";
					}
					else if(x.substring(1,2).equals(c)){
						realResult += "A";
					}
					else{
						realResult += "B";
					}
					c = "no";
				}
				else if(m.equals(d)){
					if(a == 2){
					realResult += "A";
					}
					else if(x.substring(2,3).equals(d)){
						realResult += "A";
					}
					else{
						realResult += "B";
					}
					d = "no";
				}
				else if(m.equals(e)){
					if(a == 3){
					realResult += "A";
					}
					else if(x.substring(3).equals(e)){
						realResult += "A";
					}
					else{
						realResult += "B";
					}
					e = "no";
				}
			}
		}
		for(int i = 0; i<4; i++){
			if(realResult.contains("A")){
				boardRight[currentRow][i] = "A";
				int j = realResult.indexOf("A");
				if(j == 0){
					realResult = realResult.substring(1);
				}
				else if(j == 3){
					realResult = realResult.substring(0,3);
				}
				else{
					realResult = realResult.substring(0,j) + realResult.substring(j+1);
				}
				}
			else if(realResult.contains("B")){
				boardRight[currentRow][i] = "B";
				int g = realResult.indexOf("B");
				if(g == 0){
					realResult = realResult.substring(1);
				}
				else if(g == 3){
					realResult = realResult.substring(0,3);
				}
				else{
					realResult = realResult.substring(0,g) + realResult.substring(g+1);
				}
				}

		}
	
		printBoard();
		currentRow++;
		if(currentRow == 12){
			System.out.print("You're all out of gueses. The code was "+ realCode + ". Better luck next time!");
			return;
		}
		}
	}
	}
	
	
	