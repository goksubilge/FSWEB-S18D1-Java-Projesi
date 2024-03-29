package com.wit.burgerapp.controller;

import com.wit.burgerapp.dao.BurgerDao;
import com.wit.burgerapp.entity.BreadType;
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

    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }

    // id yoksa -> save ,  id varsa -> update yapacak tek bir method yazacağız yarın. "POST + PUT" birleşecek artık.

    @DeleteMapping("/{id}")
    public Burger remove(int id){
        return burgerDao.remove(id);
    }

    //findByPrice
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findById(double price){
        return burgerDao.findByPrice(price);
    }
    //findByBreadType
    @GetMapping("/findByBreadType/{findByBreadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        BreadType breadTypeEnum = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(breadTypeEnum);
    }
    //findByContent
    @GetMapping("/findByContent/{findByContent}")
    public List<Burger> findByContent(@PathVariable String content ) {
        return burgerDao.findByContent(content);
    }
}
