package com.wit.burgerapp.dao;

import com.wit.burgerapp.entity.BreadType;
import com.wit.burgerapp.entity.Burger;
import com.wit.burgerapp.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
Bu Package 'da validation yazılmaz  normalde !
 */

@Repository  // Bu sınıftan instance oluşturuyor.(Bunu eklemezsen BurgerController Class 'ından hata alırsın, bulamaz burayı.)
public class BurgerDaoImpl implements BurgerDao {
    // Database 'e touch edecek code: EntityManager
    // veritabanına queries yazdıracak, veritabanından queries okuyacak

    @Autowired //BurgerDaoImpl class 'ının runtime 'da instance oluşunca bu entityManager 'ı içine enjekte etmesi için + create noarg constructor
    private EntityManager entityManager;
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Burger save(Burger burger) {
        if(burger.getName().isEmpty() || burger.getPrice() <= 0){
            throw new BurgerException("Burger credential is not valid! ", HttpStatus.BAD_REQUEST);
        }
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(int id) {
        Burger burger = entityManager.find(Burger.class, id);
        if(burger == null){
            throw new BurgerException("Burger with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return entityManager.find(Burger.class, id);
    }

    // SELECT * FROM fsweb.burger AS b WHERE price > 20 ORDER BY price DESC
    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query =
        entityManager.createQuery("SELECT b FROM Burger b WHERE price > :price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    // SELECT b FROM Burger b WHERE (b.breadType = white) ORDER BY b.name DESC
    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query =
                entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType =:breadType ORDER BY b.name DESC", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }

    // SELECT * FROM fsweb.burger AS b WHERE b.contents LIKE '%cheese%'
    // CONCAT ile çözüm:
    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%', :content,'%') ORDER BY b.name", Burger.class) ;
        query.setParameter("content", content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(int id) {
        Burger burger = findById(id);
        entityManager.remove(burger);
        return burger;
    }
}
