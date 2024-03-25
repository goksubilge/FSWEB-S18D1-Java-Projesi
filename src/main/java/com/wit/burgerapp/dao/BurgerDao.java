package com.wit.burgerapp.dao;

import com.wit.burgerapp.entity.BreadType;
import com.wit.burgerapp.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(int id);
    // birden fazla şey dönüyorsam: Set & List (Collection type) bişe döndürmem gerekli.
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(int id);
}
