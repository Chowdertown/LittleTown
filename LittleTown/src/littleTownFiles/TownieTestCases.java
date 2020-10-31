package littleTownFiles;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownieTestCases {

	
    /**
     * This tests if he Townie was initialized properly by constrcutor
     * and the first Townie added is the founder
     */
	@Test
	void createTownieTest() {
		
		Townie Spongebob = new Townie ("Spongebob", "M", 37);
		assertEquals(Spongebob.getAge(),37);
		assertEquals(Spongebob.getName(), "Spongebob");
		assertEquals(Spongebob.getGender(),"M");
		assertEquals(Spongebob.isFounder(),true);
		assertTrue(Spongebob.getTownMembers()!= null);
	}
	
	/**
	 * This test passes as long as it does not create an IOExcepton
	 */
	@Test
	void createRandTownieTest() {
		Townie.ListNames();
		Townie JohnDoe;
		JohnDoe = new Townie ();
		
		System.out.println(JohnDoe);
	}
	/**
	 * This tests that two Townies are equal
	 */
	@Test 
	void equalsAndHashcodeTest() {
		Townie Micheala = new Townie("Micheal","M",26);
		Townie Michealb = new Townie("Micheal","M", 26);
		Micheala.setPersonality(7, 7, 7, 7);
		Michealb.setPersonality(7, 7, 7, 7);
		
		assertEquals(Micheala,Michealb);
		assertEquals(Micheala.hashCode(),Michealb.hashCode());
	}
	/**
	 * This tests if all the Townies age up.
	 */
	@Test
	void ageUpTest() {
		Townie Pam = new Townie ("Pam", "M", 30);
		Townie Micheal = new Townie("Micheal","M",40);
		Townie Jim= new Townie("Jim","M",32);
		Townie Dwight =  new Townie("Dwight","M",36);
		
		Townie.ageUP();
		assertEquals(Pam.getAge(),31);
		assertEquals(Micheal.getAge(),41);
		assertEquals(Jim.getAge(),33);
		assertEquals(Dwight.getAge(),37);
	}
	/**
	 * This tests if gender will change weather the input string value is
	 * recognized or not.
	 */
   @Test 
   void setGenderTest() {
	   Townie Quinn = new Townie("Quinn","F",19);
	   Townie Cooper = new Townie("Cooper", "M",28);
	   Quinn.setGender("N/A");
	   Cooper.setGender("nonbinary");
	   
	   assertEquals(Quinn.getGender(),"F");
	   assertEquals(Cooper.getGender(),"NONBINARY");
   }
}
