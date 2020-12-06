package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.*;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class HorgaszatController {

    @Autowired
    @Qualifier("horgaszatService")
    HorgaszatService service;

    @ModelAttribute(value="horgaszat")
    public Horgaszat create(){
        return new Horgaszat();
    }

    @ModelAttribute(value="sor")
    public Sor createSor() {
        return new Sor();
    }

    @ModelAttribute(value="fogas")
    public Fogas createFogas(){
        return new Fogas();
    }

    @ModelAttribute(value="datum")
    public Datum datum(){
        return new Datum();
    }

    @GetMapping(value="/horgaszatok")
    public ModelAndView getHorgaszatok(){
        ModelAndView mav = new ModelAndView("horgaszatlist.jsp");
        System.out.println(service.getAllHorgaszat());
        mav.addObject("horgaszatok",service.getAllHorgaszat());
        return mav;
    }

    @GetMapping(value="/horgaszat/{id}")
    public String getHorgaszatById(@PathVariable String id, Model model) throws HorgaszatNotFound {
        model.addAttribute("horgaszat",service.getHorgaszatById(id));
        return "horgaszatdetails.jsp";
    }

    @GetMapping(value="addHorgaszat")
    public String addHorgaszatForm(Model model){
        return "horgaszatForm.jsp";
    }

    @PostMapping(value="addHorgaszat")
    public String addHorgaszat(@ModelAttribute("horgaszat") Horgaszat horgaszat, Model  model){
        try {
            //service.addSor(sor);
            service.addHorgaszat(horgaszat);
        } catch (HorgaszatAlreadyAdded horgaszatAlreadyAdded) {
            horgaszatAlreadyAdded.printStackTrace();
        }
        return "redirect:horgaszat/"+horgaszat.getId();
    }

    @GetMapping(value = "/fogasok/add/{horgaszatId}")
    public String addFogasForm(@PathVariable String horgaszatId, Model model) {
        model.addAttribute("id", horgaszatId);
        model.addAttribute("horgaszbot",Horgaszbot.values());
        model.addAttribute("csali",Csali.values());
        return "fogasForm.jsp";
    }

    @PostMapping(value = "/fogasok/add/{horgaszatId}")
    public String addFogas(@ModelAttribute("fogas") Fogas fogas, Model model, @PathVariable String horgaszatId) {
        service.addFogas(fogas, horgaszatId);
        return "redirect:../../horgaszat/" + horgaszatId;
    }

    @GetMapping(value = "/fogasok/delete/{id}&{horgaszatId}")
    public String deleteFogas(@PathVariable int id, @PathVariable String horgaszatId) {
        service.deleteFogas(id, horgaszatId);
        return "redirect:../../horgaszat/" + horgaszatId;
    }

    @GetMapping(value = "/horgaszatok/delete/{id}")
    public String deleteHorgaszat(@PathVariable String id) throws HorgaszatNotFound {
        Horgaszat horgaszat = service.getHorgaszatById(id);
        service.deleteHorgaszat(horgaszat);
        return "redirect:../../horgaszatok";
    }

    @PostMapping(value = "/horgaszatok/listByDate")
    public String findAllBetweenKetDatum(@ModelAttribute("datum") Datum datum, Model model){
        model.addAttribute("horgaszatok",service.findAllBetweenKetDatum(datum.getStart(),datum.getEnd()));
        return "horgaszatlist.jsp";
    }

    @GetMapping(value = "getDatumForm")
    public String getDatumForm(){
        return "horgaszatokDatumForm.jsp";
    }
}
