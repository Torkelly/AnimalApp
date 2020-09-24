package animalapp.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
// Entity annotation allows a DB to know this is going to be a table
@Entity
public class Animal {
	@Id //indicates the next variable is an ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto generates ID's, adds +1 to create next ID by default
	private long id;
	// next annotations are all server-side input validations
	@Size(min=2, max=20, message="'Name' must be between 2 and 20 characters.")
	@Pattern(regexp = "^[a-zA-Z]+$", message="Integers and special characters not allowed.")
	private String name;
	@Size(min=2, max=30, message="'Species' must be between 2 and 30 characters.")
	@Pattern(regexp = "^[a-zA-Z]+$", message="Integers and special characters not allowed.")
	private String species;
	private char sex;
	@DecimalMin("0.01")
	private BigDecimal size;
	@Pattern(regexp = "^[a-zA-Z]*$", message="Integers and special characters not allowed.")
	@Size(min=2, max=20, message="'Color' must be between 2 and 15 characters.")
	private String color;
	
	//empty constructor
	public Animal() {
		super();
	}
	
	//constructor takes all parameters except color, which is not required.
	public Animal(String name, String species, char sex, BigDecimal size) {
		super();
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.size = size;
	}
	 //constructor takes all possible parameters
	public Animal(String name, String species, char sex, BigDecimal size, String color) {
		super();
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.size = size;
		this.color = color;
	}

	//getters and setters for variable access
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	// overrides default toString() method and returns a custom String
	@Override
	public String toString() {
		return "Animal " + id + ": " + name + " the " + species + "Sex - " + sex + ", Color - " + color + ", Size - " + size;	
	}
}
