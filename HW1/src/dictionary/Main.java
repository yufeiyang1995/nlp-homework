package dictionary;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.readFile("dic_ec.txt");
		System.out.println("Read File Success!");
		
		while(true) {
			System.out.println("Input a word:");
			Scanner sc = new Scanner(System.in);
			String word = sc.nextLine();
			String result = rf.search(word);
			if(result != null)
				System.out.println("Result is : " + result);
			else
				System.out.println("This word is not in the dictionary.");
		}
	}
}
