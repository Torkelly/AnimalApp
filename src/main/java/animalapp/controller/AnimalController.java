package animalapp.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import animalapp.bean.Animal;
import animalapp.repository.AnimalRepository;
// indicates a controller class, for this controller we are writing CRUD operations
@Controller
public class AnimalController {
	
	// creates an instance of the repository service, which communicates with the DB
	@Autowired
	AnimalRepository repo;
	
	//PostMapping and GetMapping indicates the URL path
	
	// gets all existing data from the animals table
	@GetMapping("/viewAll")
	public String viewAllAnimals(Model model) {
		model.addAttribute("animals", repo.findAll()); //allows access to variable animals in results.html
		return "results";
	}
	// gets the html form for input of new object animal
	@GetMapping("/inputAnimal")
	public String addNewAnimal(Model model) {
		Animal a =  new Animal();
		model.addAttribute("animal", a);
		return "input";
	}
	
	// sends user input to the repo
	@PostMapping("/inputAnimal")
	public String addNewAnimal(@Valid Animal a, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "input"; //when input fails validation, keep user on current page
		}
		repo.save(a);
		model.addAttribute("animals", repo.findAll()); //allows access to variable animals in results.html
		return "results"; // when input validates, send user to the animal objects viewing page
	}
	
	//gets the chosen animal object by Id, and generates a form for editing object
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Animal a = repo.findById((long) id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid animal Id:" + id));
			model.addAttribute("animal", a);
			return "update"; 
	}
	
	// sends updated animal object to repo, checks for valid input
	@PostMapping("/update/{id}")
	public String updateAnimal(@PathVariable("id") long id, @Valid Animal a,
		BindingResult result, Model model) {
		if(result.hasErrors()) {
			a.setId(id); //keeps us looking at the correct animal if there are errors
			return "update"; //when input fails validation, keep user on current page
		}
		repo.save(a);
		model.addAttribute("animals", repo.findAll());
		return "results"; // when input validates, send user to the animal objects viewing page
	}
	
	// gets the chosen animal object and deletes it from the repo and DB
	@GetMapping("/delete/{id}")
	public String deleteAnimal(@PathVariable("id") long id, Model model) {
		Animal a = repo.findById((long) id).orElseThrow(()
				-> new IllegalArgumentException("Invalid animal Id: " + id));
		repo.delete(a);
		model.addAttribute("animals", repo.findAll());
		return "results";
	}

}