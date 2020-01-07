package za.co.hilltop.NorthRowTest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import za.co.hilltop.NorthRowTest.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> { // extends PagingAndSortingRepository<Food, String> {
	@Query(nativeQuery = true, value = "SELECT * FROM food")
	List<Food> findAll();
	
//	//name, type or date
//	@Query(nativeQuery = true, value = "SELECT * FROM food f WHERE f.name = :condition OR f.type =:condition")
//	List<Food> findByConditions(String condition);
	
	@Query(nativeQuery = true, value = "SELECT * FROM food f WHERE f.name LIKE CONCAT('%',:condition,'%') OR f.type LIKE CONCAT('%',:condition,'%') OR f.createddate LIKE CONCAT('%',:condition,'%')")
	List<Food> findByConditions(String condition);
}
