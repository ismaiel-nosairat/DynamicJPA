/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somaa.services;

import com.somaa.entities.User;
import com.somaa.repos.UserRepo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ismaiel
 */
@Transactional
@Service
public class MainService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    EntityManager em;

    @PostConstruct
    public void init() {
        User user1 = new User("isma", 2000);
        User user2 = new User("omar", 3000);
        User user3 = new User("hamada", 4000);
        User user4 = new User("amer", 6000);
        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
    }

    public ResponseEntity<?> doTask(int option) {
        switch (option) {
            case 1: {
                return ResponseEntity.ok(findAll());
            }
            case 2: {
                return ResponseEntity.ok(find2());
            }
            case 3: {
                return ResponseEntity.ok(find3());
            }
            case 4: {
                return ResponseEntity.ok(find4());
            }
            default: {
                return null;

            }
        }

    }

    private List<User> findAll() {
        List<User> x = userRepo.findAll();
        return x;
    }

    private List<User> find2() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate hasBirthday = builder.equal(root.get("name"), "isma");

        query.where(builder.and(hasBirthday));
        return em.createQuery(query.select(root)).getResultList();

    }

    private List<User> find3() {
   CriteriaBuilder cb = this.em.getCriteriaBuilder();

        // create update
        CriteriaUpdate<User> update = cb.
        createCriteriaUpdate(User.class);

        // set the root class
        Root e = update.from(User.class);

        // set update and where clause
        update.set("salary", 3000);
        update.where(cb.lessThanOrEqualTo(e.get("salary"), 2000));

        // perform update
        this.em.createQuery(update).executeUpdate();
        return null;
    }

    private List<User> find4() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        // create delete
        CriteriaDelete<User> delete = cb.createCriteriaDelete(User.class);

        // set the root class
        Root e = delete.from(User.class);

        // set where clause
        delete.where(cb.lessThanOrEqualTo(e.get("salary"), 3000));

        // perform update
        int executeUpdate = this.em.createQuery(delete).executeUpdate();
        return null;
    }

}
