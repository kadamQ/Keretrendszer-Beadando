package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

import java.util.Collection;

@RestController
@RequestMapping(value="/rest/")
public class RESTHorgaszatController {

    @Autowired
    HorgaszatService horgaszatService;

    @GetMapping(value = "horgaszatok")
    public Collection<Horgaszat> getAllHorgaszat(){
        return horgaszatService.getAllHorgaszat();
    }

    @GetMapping(value="horgaszat/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Horgaszat getHorgaszatById(@PathVariable(name="id") String id){
        return horgaszatService.getHorgaszatById(id);
    }

    @PostMapping(value = "horgaszatok", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json:charset=utf-8")
        public String addHorgaszat(@RequestBody Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
            System.out.println("Hozzáadandó: "+horgaszat);
            horgaszatService.addHorgaszat(horgaszat);
            return "Új horgászat került hozzáadásra a következő azonosítóval: "+horgaszat.getId();
        }
    }
}
