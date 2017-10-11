package main;

import java.util.ArrayList;
import java.util.Scanner;

import dict.ReadFile;

public class Main {
	private static String dictFile = "ce£¨ms-word£©.txt";
	
	public static void main(String[] args){
		ReadFile rf = new ReadFile();
		rf.readFile(dictFile);
		
		ArrayList<String> words = rf.getWords();
		int maxLen = rf.getMaxLen();
		while(true){
			System.out.println("Input a Sentence:");
			Scanner sc = new Scanner(System.in);
			String sentence = sc.nextLine();
			
			//System.out.println("Sentence: " + sentence);
			SplitWords sw = new SplitWords();
			String result = sw.maxiumMatching(sentence,words,maxLen);
			System.out.println("Result: " + result);
		}
	}
}
