package com.wit.burgerapp.controller;

import com.wit.burgerapp.dao.BurgerDao;
import com.wit.burgerapp.dto.BurgerResponse;
import com.wit.burgerapp.entity.BreadType;
import com.wit.burgerapp.entity.Burger;
import com.wit.burgerapp.util.BurgerResponseEntity;
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
    List<BurgerResponse> findAll(){
        List<Burger> burgers = burgerDao.findAll();
        return BurgerResponseEntity.burgerToBurgerResponse(burgers);
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
    public BurgerResponse update(@RequestBody Burger burger){
        Burger updatedBurger = burgerDao.update(burger);
        return new BurgerResponse(updatedBurger.getName(), updatedBurger.getPrice());
    }

    // id yoksa -> save ,  id varsa -> update yapacak tek bir method yazacağız yarın. "POST + PUT" birleşecek artık.

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable  int id){
        return burgerDao.remove(id);
    }

    //findByPrice
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }
    //findByBreadType
    @GetMapping("/findByBreadType/{findByBreadType}")
    public List<Burger> findByBreadType(@PathVariable String findByBreadType) {
        BreadType breadTypeEnum = BreadType.valueOf(findByBreadType);
        return burgerDao.findByBreadType(breadTypeEnum);
    }
    //findByContent
    @GetMapping("/findByContent/{findByContent}")
    public List<Burger> findByContent(@PathVariable String findByContent ) {
        return burgerDao.findByContent(findByContent);
    }
}
