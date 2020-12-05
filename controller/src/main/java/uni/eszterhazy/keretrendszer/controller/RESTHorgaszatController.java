package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

import java.util.Collection;

@RestController
@RequestMapping(value = "/rest/")
public class RESTHorgaszatController {

    @Autowired
    HorgaszatService horgaszatService;

    @GetMapping(value = "horgaszatok")
    public Collection<Horgaszat> getAllHorgaszat() {
        return horgaszatService.getAllHorgaszat();
    }

    //034de301-f46a-4abd-aacc-f3632311cd76
    @GetMapping(value = "horgaszat/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Horgaszat getHorgaszatById(@PathVariable(name = "id") String id) throws HorgaszatNotFound {
        return horgaszatService.getHorgaszatById(id);
    }

    @ExceptionHandler(HorgaszatNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String unknownHorgaszatId(HorgaszatNotFound e){
        return "Horgaszat az adott azonositoval nem talalhato: "+e.getMessage();
    }

    @PostMapping(value = "horgaszatok", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addHorgaszat(@RequestBody Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
        System.out.println("Hozzáadandó: " + horgaszat);
        horgaszatService.addHorgaszat(horgaszat);
        return "Új horgászat került hozzáadásra a következő azonosítóval: " + horgaszat.getId();
    }

    @ExceptionHandler(HorgaszatAlreadyAdded.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String usedHorgaszatId(HorgaszatAlreadyAdded e){
        return "Horgaszat az adott azonositoval mar letezik: "+e.getMessage();
    }
}
