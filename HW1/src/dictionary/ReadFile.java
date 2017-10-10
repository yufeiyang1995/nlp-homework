package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
	private Map<String,String> wordList= new HashMap<String,String>();
	
	public void readFile(String fileName) {
		try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
           
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
            	sb.append(str+"/n");
                //System.out.println(str);
                
                String[] context = str.split("");
                String key = context[0];
                String value = "";
                for(int i = 1;i < context.length;i++) {
                	value += context[i] + " ";
                	
                }
                //System.out.println(value);
                
                wordList.put(key, value);
            }
           
            br.close();
            reader.close();
           
      }
      catch(FileNotFoundException e) {
                  e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
      }
	
	public String search(String word) {
		if(wordList.containsKey(word))
			return word + " " + wordList.get(word);
		else if(wordEasyReturn(word) != null) {
			return wordEasyReturn(word) + " " + wordList.get(wordEasyReturn(word));
		}
		else if(word.endsWith("ing")) {
			if(wordList.containsKey(word.substring(0, word.length() - 3))
					&& !isVowel(word.charAt(word.length() - 5))) {
				return word.substring(0, word.length() - 3) + 
						" " + wordList.get(word.substring(0, word.length() - 3));
			}
			else if(wordList.containsKey(word.substring(0, word.length() - 3) + "e")){
				return word.substring(0, word.length() - 3) + "e" + 
						" " + wordList.get(word.substring(0, word.length() - 3) + "e");
			}
			else
				return null;
		}
		else if(word.endsWith("ed")) {
			if(wordList.containsKey(word.substring(0, word.length() - 2)) 
					&& !isVowel(word.charAt(word.length() - 4))) {
				return word.substring(0, word.length() - 2) + 
						" " + wordList.get(word.substring(0, word.length() - 2));
			}
			else if(wordList.containsKey(word.substring(0, word.length() - 2) + "e")){
				return word.substring(0, word.length() - 2) + "e" + 
						" " + wordList.get(word.substring(0, word.length() - 2) + "e");
			}
			else
				return null;
		}
		else if(wordSpecialReturn(word) != null)
			return wordSpecialReturn(word) + wordList.get(wordSpecialReturn(word));
		else 
			return null;
	}
	
	private String wordEasyReturn(String word) {
		if(word.endsWith("s"))
			return word.substring(0, word.length() - 1);
		else if(word.endsWith("es"))
			return word.substring(0, word.length() - 2);
		else if(word.endsWith("ies"))
			return word.substring(0, word.length() - 3) + "y";
		else if(word.endsWith("ying"))
			return word.substring(0, word.length() - 3) + "ie";
		else if(word.endsWith("ing") && 
				word.charAt(word.length() - 4) == word.charAt(word.length() - 5))
			return word.substring(0, word.length() - 4);
		else if(word.endsWith("ied"))
			return word.substring(0, word.length() - 3) + "y";
		else if(word.endsWith("ed") && 
				word.charAt(word.length() - 3) == word.charAt(word.length() - 4))
			return word.substring(0, word.length() - 3);
		else
			return null;
	}
	
	private String wordSpecialReturn(String word) {
		if(word.equals("went"))
			return "go";
		if(word.equals("gone"))
			return "go";
		if(word.equals("sat"))
			return "sit";
		if(word.equals("done"))
			return "do";
		return null;
	}
	
	private boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
			return true;
		else
			return  false;
	}
}
