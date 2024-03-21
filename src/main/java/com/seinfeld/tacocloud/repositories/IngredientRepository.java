package com.seinfeld.tacocloud.repositories;

import com.seinfeld.tacocloud.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
