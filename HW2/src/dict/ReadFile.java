package dict;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	private ArrayList<String> words = new ArrayList<String>();
	private int maxLen = 0;
	private int wordsNum = 0;
	
	public void readFile(String fileName){
		try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
           
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
            	wordsNum++;
            	sb.append(str+"/n");
                String[] context = str.split(",");
                words.add(context[0]);
                //System.out.println("WORD: " + context[0]);
                
                if(context[0].length() > maxLen){
                	maxLen = context[0].length();
                }
            }
            //System.out.println("MaxLen: " + maxLen);
            //System.out.println("wordsNum: " + wordsNum);
           
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
	
	public ArrayList<String> getWords(){
		return words;
	}
	
	public int getMaxLen(){
		return maxLen;
	}
}
