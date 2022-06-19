package pbl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
// word cloud class selects keywords from each questions
public class WordCloud {	
	
	// attribute
	private String question;
	private String key;
	private int difficultyLevel;
	private boolean notAsked;
	// necessary data
	public static String[] stopWords;
	public int count = 0;
	//constructor
	public WordCloud(String question) {
		this.question = question;
	}
	// getters and setters
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public WordCloud(String key, int difficultyLevel, boolean notAsked) {
		this.key = key;
		this.difficultyLevel = difficultyLevel;
		this.notAsked = notAsked;
	}
	
	public boolean notAsked() {
		return notAsked;
	}
	public void setAsked(boolean notAsked) {
		this.notAsked = notAsked;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
		
	//that procedure gets stop words
	public static void getStopWords() {    	
    	try {  	        
        File stopWordsFile = new File("stop_Words.txt"); // to open file       
        BufferedReader br = new BufferedReader(new FileReader(stopWordsFile)); //buffer reader for read file        
        stopWords = br.lines().toArray(String[]::new); // storing stop words
		br.close();
			
		} catch (IOException e) {
			System.out.println(e);
			}                    			  
		}
	
	//wc function gets keywords
	public String wc() {  		
		getStopWords(); 
		question = question.replaceAll("\\p{Punct}", " ").strip(); // to remove punctuation marks
		String[] words = question.split(" "); // Separator
		String keys = ""; // to store all possible words
		String returnKey = ""; // to return the key from keys
		 for (int i = 0; i < words.length; i++) {
			 boolean flag = true;
			 for (int j = 0; j < stopWords.length; j++) {	
				 // if the word stop word
				 if (words[i].strip().equalsIgnoreCase(stopWords[j])) {
		                flag = false;
		       		 break;
		            }
			 }
			 if (flag) {
				 keys += words[i] + " ";
			 }        
	     }		 
		 if (keys == "") {
			 
			 keys = "joker";
			 
		 }
		 
			 String[] keysArr = keys.strip().split("\\s+"); // split from blank spaces		
			int rnd = new Random().nextInt(keysArr.length); // to select random word			
			returnKey = keysArr[rnd];			 			 
		
		return returnKey;	
		}
	}



