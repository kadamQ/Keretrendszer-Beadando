package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

@Component("horgaszatController")
public class HorgaszatController {

    @Autowired
    @Qualifier("horgaszatService")
    HorgaszatService service;

    public void printAll(){
        System.out.println(service.getAllHorgaszat());
    }

}
