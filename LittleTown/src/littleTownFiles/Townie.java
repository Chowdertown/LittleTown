package littleTownFiles;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
 * Future Plans
 * 
 * want to add attraction system and banking system.
 * will add town and GUI
 * add Point of View system
 * want to add relationship system
 * add jobs
 * add talent and skill
 * add town activities
 * create gender class and include more
 * want to change hashCode so the they can change name
 * 
 */

/**
 * 
 * @author Oladotun Oladimejij
 * 
 * The purpose of this class is to create a new member of Little Town, a townie
 * the personality of the of the townies are based on the Myers Briggs 
 * personality types. The townies of Little Town act like characters in a story.
 * The instance variables are name of type String, gender of type String, 
 * p of type Personality
 * and age of type int.
 * 
 * All instances of a Townie have access to the Townie has access to the random
 * names and gender HashMaps as well as all the members of the town.
 *
 */
public class Townie {

	private String name="NONAME";
	private String gender = "N/A";
	private Personality p = new Personality();
	private int age=-1;
	
	private static HashMap<Integer,String> idxAndGend = new HashMap<>();
	private static HashMap<Integer,String> rndNames = new HashMap<>();
	private static ArrayList<Townie> townies = new ArrayList<>();
	
	/**
	 * This creates a new random Townie, with a random age, personality, and 
	 * name. It sets the Townie to the founder and adds them to the list of
	 * the members of the town.
	 * it is not complete I have to randomize name and create class on gender.
	 */
	public Townie() {
		townies.add(this);
		if (townies.size() == 1) {
			setFounder();
		}
		this.age = ((int) (Math.random() * (100 - 1))) + 1;
		p.setRandPersonality();
		this.randomGender();
		this.setRandomName();
	}
	/**
	 * This method creates a new Townie based on the parameters,
	 * It correspondingly sets the name, gender, and age to  the ones
	 * in the personality
	 *  
	 * It initially sets the personality to random, because the user will
	 * be prompted to adjust the personality if they'd like.
	 * 
	 * It adds the new Townie to the list of of Townies (the members of Little
	 * Town)
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Townie(String name, String gender, int age) {
		townies.add(this);

		if (townies.size() == 1) {
			setFounder();
		}

		this.name = name;
		this.age = age;
		this.gender = gender;

		p.setRandPersonality();
	}
	/**
	 * Creates a deep Copy of the Townie passed in as a parameter. 
	 * It sets the name, age, gender, and personality 
	 * @param original
	 */
	public Townie(Townie original) {
		if (original != null) {
			this.name = original.name;
			this.age = original.age;
			this.gender = original.gender;
			this.p = original.p;
		}
	}
	/**
	 * This method considers Two Townies equal if they have the same name
	 *  and personality
	 * @return true if the conditions are met.
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Townie)) {
			return false;
		}
		Townie toCompare = (Townie) other;
		return name.equals(toCompare.name) && p.pType().equals(toCompare.p.pType());
	}

	/**
	 * This method overrides the object class hasCode() to  depend
	 * the Townie's name, and personality types
	 */
	@Override
	public int hashCode() {
		int num = 3 * (1 + p.pType().hashCode()) + (7 * (1 + name.hashCode())) + 4;

		return num;
	}
	/**
	 * This method checks if this Townie is the founder of Little Town
	 * @return true if founder else false is returned
	 */
	public boolean isFounder() {

		if (setFounder().equals(this)) {
			return true;
		}

		return false;
	}
	/**
	 * This method sets the first Townie added to LittleTown as the founder
	 *  
	 * @return the founder of Little Town
	 */
	public final Townie setFounder() {
		if (townies != null && !townies.isEmpty()) {

			final Townie founder = townies.get(0);

			return founder;
		}

		return null;
	}

	/**
	 * This method returns the list of the members of LittleTown
	 * 
	 * @return the Arraylist of Townies
	 */
	public ArrayList<Townie> getTownMembers() {

		return townies;
	}

	/**
	 * This method returns the age of this Townie.
	 * 
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * This method returns the name of this Townie.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method returns the gender of this Townie.
	 * 
	 * @return
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * This method returns the Myers-Brigg personality of this Townie.
	 * 
	 * @return
	 */
	public String getPersonality() {

		return this.p.pType();
	}
	
	/**
	 * This method changes the gender if the Townie if it is a recognized gender
	 * by the program otherwise it does nothing.
	 * @param gender
	 */
	public void setGender(String gender) {

		if (gender != null) {
			// char firstLetter = gender.charAt(0);

			if (gender.compareToIgnoreCase("Female") == 0) {
				this.gender = "F";
			} else if (gender.compareToIgnoreCase("Male") == 0) {
				this.gender = "M";
			} else if (gender.compareToIgnoreCase("Nonbinary") == 0) {
				this.gender = "NONBINARY";
			}
		}
	}

	/**
	 * This method sets the Townie's personality based on the Myers-Brigg
	 * personality test. 
	 * iORe represents the spectrum Introversion and Extroversion
	 * sORn represents the spectrum Sensing and Intuition
	 * fORT represents the spectrum Thinking and Feeling
	 * jORp represents the spectrum Judging and Perceiving
	 * 
	 * Each parameter allows any integer to be put it in but will cap values
	 * from -11 to 11. The negative number corresponds to the letter on the
	 * left side of the or, positive numbers correspond to the letter on 
	 * right side. 
	 * 
	 * For ex. iORe -11 would be an introvert and 11 would be an extrovert.
	 * @param iORe
	 * @param sORn
	 * @param fORt
	 * @param jORp
	 */
	public void setPersonality(int iORe, int sORn, int fORt, int jORp) {

		p.setIorE(iORe);
		p.setSorN(sORn);
		p.setForT(fORt);
		p.setJorP(jORp);
	}
	/**
	 * This method increments the age field by 1 for all the Townies 
	 * in Little Town (the townies arrayList).
	 */
	public static void ageUP() {
		for (Townie t : townies) {
			t.age++;
		}
	}
	/**
	 * This method parses data from a list of names from a CSV called
	 * NationalNames.csv that contains the most popular names in the United
	 * States from 1880 to the present.
	 * 
	 * In a try Catch
	 * It tries
	 * It uses a Scanner to read the CSV file, and splits the data into its
	 * columns id , Names, Years, Gender, and Count. The data needed is the 
	 * ones from  id, Names, and Gender.
	 * 
	 * It creates a HashMap to map the values of the id/Index number(key)
	 * to their names(value)
	 * It also adds to the idxAndGender HashMap indexes(key) mapped to their
	 * Gender(value) 
	 * 
	 * and it catches an IOexception.
	 * 
	 * @return HashMap of index values mapped to a name value.
	 */
	public static void ListNames() {

		String nameFileData = "src/NationalNames.csv";
		File nameFile = new File(nameFileData);

		try {
			Scanner inputStream = new Scanner(nameFile);
			inputStream.next(); // ignore first line in CSV
			while (inputStream.hasNext()) {

				String data = inputStream.next();
				String[] values = data.split(",");

				// values[0]->id, values[1]->names, values->[3] gender
				Integer index = Integer.parseInt(values[0]);
				idxAndGend.put(index, values[3]);

				rndNames.put(index, values[1]);

			}
			inputStream.close();
		} catch (IOException exc) {
			System.out.println("FILE DOES NOT EXIST :(");
		}

	}
	/**
	 *  This method overrides the Object class toString method and prints on
	 *  one line 
	 *  Townie: name Gender: gender Age: age Personality : personalityType
	 *  
	 */
	@Override
	public String toString() {
		String print = "Townie:";
		print += name;
		print += " Gender:";
		print += gender;
		print += " Age:";
		print += age;
		print += " Personality:";
		print += p.pType();
		print += "\n";

		return print;
	}

	//PRIVATE HELPER METHODS--------------------------------------------------
	/**
	 * This method utilizes the Math class random method to randomize this 
	 * Townie's gender. It randomizes numbers from 1-3
	 * if the random number is 1 the the Townie is female
	 * if the random number is 2 then the Townie is male
	 * if the random number is 3 then the Townie is nonbinary
	 * 
	 */
	private void randomGender() {

		int gend = ((int) (Math.random() * (4 - 1))) + 1;

		if (gend == 1) {
			this.gender = "F";
		} else if (gend == 2) {
			this.gender = "M";
		} else if (gend == 3) {
			this.gender = "NONBINARY";
		}

	}

	/**
	 * The code in this method is in a try catch because it depends on the
	 * getListNames() method, which might cause an IOexception.
	 * 
	 * This method access data from the HashMap with indexes mapped  to the
	 * names and picks a random name based on the random index generated by 
	 * Math.random().
	 * It also decides what names a Townie can get based on their gender. 
	 * Non binary Townies can get any name, buy females only get the female 
	 * name and males only get male names.
	 * 
	 * If the try causes an exception it will set this Townie's name to Alex,
	 * a gender neutral name.
	 */
	private void setRandomName() {

		try {

			int size = rndNames.size();
			int pick = ((int) (Math.random() * (size)) - 1); // index from 0-(size-1)

			String name = rndNames.get(pick);
			if (this.gender == "NONBINARY") {
				this.name = name;
			} else if (this.gender.equals(idxAndGend.get(pick))) {
				this.name = name;
			} else {
				setRandomName();
			}
		} catch (Exception exc) {
			this.name = "Alex"; // chose a unisex name
		}
	}
}
