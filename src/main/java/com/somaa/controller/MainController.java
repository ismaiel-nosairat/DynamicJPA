/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somaa.controller;

import com.somaa.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ismaiel
 */
@RestController
public class MainController {
    
    @Autowired
    MainService mainService;
    
    @RequestMapping("/test")
    public ResponseEntity<?> test(@RequestParam int option){
        return mainService.doTask(option);
    }
    
    
}
