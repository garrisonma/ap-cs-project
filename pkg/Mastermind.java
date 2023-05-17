package pkg;
import java.util.*;
import java.io.*;

public class Mastermind {
	int numRows = 12;
	int numCol = 4;
	String[][] board;
	String[] code;
	
	public Mastermind(){
		board = new String[numRows][numCol];
	}
	
	public void startGame(){
		populateBoard();
		codeMaker();
		printRules();
	}
	
	public void populateBoard(){
		for(String[] arr : board){
			for(String a : arr){
				a = " ";
			}
		}
	}
	public void codemaker(){
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
		
	}
}
	