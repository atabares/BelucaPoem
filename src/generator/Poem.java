package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p>
 * Class that generate a random poem of five lines.
 * </p>
 * <p>
 * Copyright (c) 2014<BR>
 * Consult-Soft S.A.<BR>
 * Created on: 11/05/2014<BR>
 * 
 * @author atabares
 * </p>
 */
public class Poem {
	
	/** Adjectives */
	static List<String> adjectives = new ArrayList<String>();
	/** Nouns */
	static List<String> nouns = new ArrayList<String>();
		/** Pronouns */
	static List<String> pronouns = new ArrayList<String>();
	/** Verbs */
	static List<String> verbs = new ArrayList<String>();
	/** Prepositions */
	static List<String> prepositions = new ArrayList<String>();
	/** The poem */
	static String poem = new String();
	

	private static void loadAdjectives() {
		String st = "black|white|dark|light|bright|murky|muddy|clear";
		StringTokenizer stt = new StringTokenizer(st, "|", false);
		
		while (stt.hasMoreTokens()) {
			adjectives.add(stt.nextToken().toString());
		}
	}
	
	private static void loadNouns() {
		String st = "heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|tree|flower|field" +
				"|meadow|pasture|harvest|water|father|mother|brother|sister";
		StringTokenizer stt = new StringTokenizer(st, "|", false);
		
		while (stt.hasMoreTokens()) {
			nouns.add(stt.nextToken().toString());
		}
	}
	
	private static void loadPronouns() {
		String st = "my|your|his|her";
		StringTokenizer stt = new StringTokenizer(st, "|", false);
		
		while (stt.hasMoreTokens()) {
			pronouns.add(stt.nextToken().toString());
		}
	}
	
	private static void loadVerbs() {
		String st = "runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks";
		StringTokenizer stt = new StringTokenizer(st, "|", false);
		
		while (stt.hasMoreTokens()) {
			verbs.add(stt.nextToken().toString());
		}
	}
	
	private static void loadPrepositions() {
		String st = "above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during" +
				"|inside|onto|outside|under|underneath|upon|with|without|through";
		StringTokenizer stt = new StringTokenizer(st, "|", false);
		
		while (stt.hasMoreTokens()) {
			prepositions.add(stt.nextToken().toString());
		}
	}
	
	/**
	 * @return
	 */
	public static String generatePoem () {
		for (int i=0; i<5; i++) {
			poem = poem.concat(generateLine()).concat("\n");
		}
		
		return poem;
	}
	
	/**
	 * @return
	 */
	private static String generateLine () {
		String line;
		
		line = getNoun();
		line = line.concat(getPreposition());
		line = line.concat(getPronoun());
		line = line.concat("\n");
		
		return line;
	}
	
	/**
	 * Get a random adjective and/or recall a adjective rule.
	 * @return A adjective.
	 */
	private static String getAdjective () {
		String adjective = adjectives.get((int) Math.floor(Math.random()*adjectives.size())).concat(" ");
		int nextRule = (int) Math.floor(Math.random()*3+1);
		
		switch (nextRule) {
			case 1 : adjective = adjective.concat(getNoun());
					 break;
			
			case 2 : adjective = adjective.concat(getAdjective());
					 break;
					 
			case 3 : break;
		}
		
		return adjective;
	}

	/**
	 * Get a random noun and/or recall a noun rule.
	 * @return A noun.
	 */
	private static String getNoun () {
		String noun = nouns.get((int) Math.floor(Math.random()*nouns.size())).concat(" ");
		int nextRule = (int) Math.floor(Math.random()*3+1);
		
		switch (nextRule) {
			case 1 : noun = noun.concat(getVerb());
					 break;
			
			case 2 : noun = noun.concat(getPreposition());
					 break;
					 
			case 3 : break;
		}
		
		return noun;
	}
	
	/**
	 * Get a random pronoun and/or recall a pronoun rule.
	 * @return A pronoun.
	 */
	private static String getPronoun () {
		String pronoun = pronouns.get((int) Math.floor(Math.random()*pronouns.size())).concat(" ");
		int nextRule = (int) Math.floor(Math.random()*2+1);
		
		switch (nextRule) {
			case 1 : pronoun = pronoun.concat(getNoun());
					 break;
			
			case 2 : pronoun = pronoun.concat(getAdjective());
					 break;
		}
		
		return pronoun;
	}
	
	/**
	 * Get a random verb and/or recall a verb rule.
	 * @return A verb.
	 */
	private static String getVerb () {
		String verb = verbs.get((int) Math.floor(Math.random()*verbs.size())).concat(" ");
		int nextRule = (int) Math.floor(Math.random()*3+1);
		
		switch (nextRule) {
			case 1 : verb = verb.concat(getPreposition());
					 break;
			
			case 2 : verb = verb.concat(getPronoun());
					 break;
					 
			case 3 : break;
		}
		
		return verb;
	}
	
	/**
	 * Get a random preposition and/or recall a preposition rule.
	 * @return A preposition.
	 */
	private static String getPreposition () {
		String preposition = prepositions.get((int) Math.floor(Math.random()*prepositions.size())).concat(" ");
		int nextRule = (int) Math.floor(Math.random()*3+1);
		
		switch (nextRule) {
			case 1 : preposition = preposition.concat(getNoun());
					 break;
			
			case 2 : preposition = preposition.concat(getPronoun());
					 break;
					 
			case 3 : preposition = preposition.concat(getAdjective());
			 		 break;
		}
		
		return preposition;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("THE POEM:\n");
		
		loadAdjectives();
		loadNouns();
		loadPronouns();
		loadVerbs();
		loadPrepositions();
		
		System.out.println(generatePoem());
	}

}
