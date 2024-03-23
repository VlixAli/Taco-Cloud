package com.seinfeld.tacocloud.repositories;

import com.seinfeld.tacocloud.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
