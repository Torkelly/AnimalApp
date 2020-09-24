package animalapp;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import animalapp.bean.Animal;

// these tests are focused on the getters and setters of the animal class

class AnimalTest {
	BigDecimal weight = new BigDecimal(7.85);
	BigDecimal weightGain = new BigDecimal(8.25);

	Animal a = new Animal("Nimbus", "Cat", 'F', weight, "Gray");
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test 
	void testName() {
		assertEquals(a.getName(), "Nimbus");
	}

	@Test
	void testSize() {
		assertEquals(a.getSize(), weight);
	}
	
	@Test
	void changeWeight() {
		a.setSize(weightGain);
		assertEquals(a.getSize(), weightGain);
	}
}
