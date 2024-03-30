package com.wit.burgerapp.util;

import com.wit.burgerapp.dto.BurgerResponse;
import com.wit.burgerapp.entity.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerResponseEntity {
    public  static List<BurgerResponse> burgerToBurgerResponse (List<Burger> burgers){
        List<BurgerResponse> responses = new ArrayList<>();
        for(Burger burger: burgers) {
            responses.add(new BurgerResponse(burger.getName(), burger.getPrice()));
        }
        return responses;
    }
}
