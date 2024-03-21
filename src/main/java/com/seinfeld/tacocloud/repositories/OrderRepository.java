package com.seinfeld.tacocloud.repositories;

import com.seinfeld.tacocloud.models.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
