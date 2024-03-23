package com.seinfeld.tacocloud.repositories;

import com.seinfeld.tacocloud.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
