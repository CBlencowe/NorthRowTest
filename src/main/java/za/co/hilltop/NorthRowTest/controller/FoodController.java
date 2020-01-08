package za.co.hilltop.NorthRowTest.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.hilltop.NorthRowTest.model.Food;
import za.co.hilltop.NorthRowTest.repository.FoodRepository;

@Controller
@RestController
@RequestMapping("/food")
public class FoodController {
	@Autowired
    private FoodRepository foodRepo;

	// CREATE new food
	@PostMapping("/add")
	String newFood(@RequestBody Food newFood) {
		newFood.setCreateddate(new Date());
		return foodRepo.save(newFood).getId();
	}
	
	// READ all food
	@GetMapping("/all")
	List<Food> all() {
		return foodRepo.findAll();
	}

	// READ food by id
	@GetMapping("/{id}")
	Optional<Food> one(@PathVariable String id) {
		return foodRepo.findById(id);
	}

	// UPDATE food item
	@PutMapping("/update/{id}")
	Food replaceFood(@RequestBody Food newFood, @PathVariable String id) {
		return foodRepo.findById(id).map(food -> {
			food.setName(newFood.getName());
			food.setType(newFood.getType());
			food.setQuantity(newFood.getQuantity());
			return foodRepo.save(food);
		}).orElseGet(() -> {
			return foodRepo.save(newFood);
		});
	}
	
	// DELETE a food item
	@DeleteMapping("/{id}")
	String deleteFood(@PathVariable String id) {
		//foodRepo.deleteById(id);
		Food food = foodRepo.findById(id).orElse(null);
		if (food != null) {
			foodRepo.delete(food);
			return "deleted";
		} else {
			return "no item found";
		}
	}

	// SEARCH all by condition (name, type or date)
	@GetMapping("/search/{condition}")
	List<Food> search(@PathVariable String condition) {
		return foodRepo.findByConditions(condition); 
	}
}
