package com.wit.burgerapp.controller;

import com.wit.burgerapp.dao.BurgerDao;
import com.wit.burgerapp.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("/")
    List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable int id){
        return burgerDao.findById(id);
    }

    @PostMapping("/")
    public Burger save(@RequestBody Burger burger){
       return burgerDao.save(burger);
    }
}
