package com.wit.burgerapp.util;

import com.wit.burgerapp.entity.Burger;
import com.wit.burgerapp.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void CheckBurgerCredentials(Burger burger){
        System.out.println(burger);
        if(burger.getName() == null || burger.getName().isEmpty() || burger.getPrice() <= 0){
            throw new BurgerException("Burger credential is not valid! ", HttpStatus.BAD_REQUEST);
        }
    }
}
