package main;

import java.util.ArrayList;

public class SplitWords {
	public String maxiumMatching(String sentence,ArrayList<String> words,int maxLen){
		int start = 0;
		ArrayList<String> splitResult = new ArrayList<String>();
		//System.out.println("length:" + sentence.length());
		
		while(start < sentence.length()){
			//System.out.println("Start!");
			int max = maxLen > sentence.length() - start ? sentence.length() - start : maxLen;
			boolean find = false;
			
			for(int i = max;i > 0;i = i - 1){
				//System.out.println(sentence);
				String subString = sentence.substring(start, start + i);
				if(match(subString,words)){
					start += i;
					splitResult.add(subString);
					find = true;
					//System.out.println("SubString:" + subString);
					break;
				}
			}
			if(!find){
				start++;
				splitResult.add("not a word");
			}
			
		}
		
		String result = "";
		for(int i = 0;i < splitResult.size();i++){
			if(i != splitResult.size() - 1)
				result += splitResult.get(i) + "/";
			else
				result += splitResult.get(i);
		}
		return result;
	}
	
	private boolean match(String subString,ArrayList<String> words){
		for(int i = 0;i < words.size();i++){
			if(subString.equals(words.get(i)))
				return true;
		}
		return false;
	}
}
