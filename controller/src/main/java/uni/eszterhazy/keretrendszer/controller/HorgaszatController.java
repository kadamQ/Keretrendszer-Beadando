package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.*;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class HorgaszatController {

    @Autowired
    @Qualifier("horgaszatService")
    HorgaszatService service;

    @ModelAttribute(value = "horgaszat")
    public Horgaszat create() {
        return new Horgaszat();
    }

    @ModelAttribute(value = "sor")
    public Sor createSor() {
        return new Sor();
    }

    @ModelAttribute(value = "fogas")
    public Fogas createFogas() {
        return new Fogas();
    }

    @ModelAttribute(value = "datum")
    public Datum datum() {
        return new Datum();
    }

    @GetMapping(value = "/horgaszatok")
    public ModelAndView getHorgaszatok() {
        ModelAndView mav = new ModelAndView("horgaszatlist.jsp");
        System.out.println(service.getAllHorgaszat());
        mav.addObject("horgaszatok", service.getAllHorgaszat());
        return mav;
    }

    @GetMapping(value = "horgaszat/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public String getHorgaszatById(@PathVariable String id, Model model) {
        try {
            model.addAttribute("horgaszat", service.getHorgaszatById(id));
            return "horgaszatdetails.jsp";
        } catch (HorgaszatNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horgaszat az adott azonositoval nem talalhato: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "addHorgaszat")
    public String addHorgaszatForm(Model model) {
        return "horgaszatForm.jsp";
    }

    @PostMapping(value = "addHorgaszat")
    public String addHorgaszat(@ModelAttribute("horgaszat") Horgaszat horgaszat, Model model) {
        try {
            service.addHorgaszat(horgaszat);
            return "redirect:horgaszat/" + horgaszat.getId();
        } catch (HorgaszatAlreadyAdded e) {
            throw new ResponseStatusException(HttpStatus.IM_USED, "Horgaszat az adott azonositoval mar letezik: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "/fogasok/add/{horgaszatId:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public String addFogasForm(@PathVariable String horgaszatId, Model model) {
        model.addAttribute("id", horgaszatId);
        model.addAttribute("horgaszbot", Horgaszbot.values());
        model.addAttribute("csali", Csali.values());
        return "fogasForm.jsp";
    }

    @PostMapping(value = "/fogasok/add/{horgaszatId}")
    public String addFogas(@ModelAttribute("fogas") Fogas fogas, Model model, @PathVariable String horgaszatId) {
        try {
            service.addFogas(fogas, horgaszatId);
            return "redirect:../../horgaszat/" + horgaszatId;
        } catch (HorgaszatNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horgaszat az adott azonositoval nem talalhato: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "/fogasok/delete/{id}&{horgaszatId:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public String deleteFogas(@PathVariable int id, @PathVariable String horgaszatId) {
        try {
            service.deleteFogas(id, horgaszatId);
            return "redirect:../../horgaszat/" + horgaszatId;
        } catch (HorgaszatNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horgaszat az adott azonositoval nem talalhato: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "/horgaszatok/delete/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public String deleteHorgaszat(@PathVariable String id) {
        try {
            Horgaszat horgaszat = service.getHorgaszatById(id);
            service.deleteHorgaszat(horgaszat);
            return "redirect:../../horgaszatok";
        } catch (HorgaszatNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horgaszat az adott azonositoval nem talalhato: " + e.getMessage(), e);
        }
    }

    @PostMapping(value = "/horgaszatok/listByDate")
    public String findAllBetweenKetDatum(@ModelAttribute("datum") Datum datum, Model model) {
        model.addAttribute("horgaszatok", service.findAllBetweenKetDatum(datum.getStart(), datum.getEnd()));
        return "horgaszatlist.jsp";
    }

    @GetMapping(value = "getDatumForm")
    public String getDatumForm() {
        return "horgaszatokDatumForm.jsp";
    }
}
