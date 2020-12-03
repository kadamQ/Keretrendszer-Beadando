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
import uni.eszterhazy.keretrendszer.model.Csali;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Horgaszbot;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

@Controller
public class HorgaszatController {

    @Autowired
    @Qualifier("horgaszatService")
    HorgaszatService service;

    @ModelAttribute(value="horgaszat")
    public Horgaszat create(){
        return new Horgaszat();
    }

    @GetMapping(value="/horgaszatok")
    public ModelAndView getHorgaszatok(){
        ModelAndView mav = new ModelAndView("horgaszatlist.jsp");
        System.out.println(service.getAllHorgaszat());
        mav.addObject("horgaszatok",service.getAllHorgaszat());
        return mav;
    }

    @GetMapping(value="/horgaszat/{id}")
    public String getHorgaszatById(@PathVariable String id, Model model){
        model.addAttribute("horgaszat",service.getHorgaszatById(id));
        return "horgaszatdetails.jsp";
    }

    @GetMapping(value="addHorgaszat")
    public String addHorgaszatForm(Model model){
        return "horgaszatForm.jsp";
    }

    @PostMapping(value="addHorgaszat")
    public String addDolgozo(@ModelAttribute("horgaszat") Horgaszat horgaszat, Model  model){
        try {
            service.addHorgaszat(horgaszat);
        } catch (HorgaszatAlreadyAdded horgaszatAlreadyAdded) {
            horgaszatAlreadyAdded.printStackTrace();
        }
        return "redirect:horgaszat/"+horgaszat.getId();
    }
}
