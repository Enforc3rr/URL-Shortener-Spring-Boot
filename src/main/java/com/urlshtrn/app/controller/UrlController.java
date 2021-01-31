package com.urlshtrn.app.controller;

import com.urlshtrn.app.dao.UrlRepo;
import com.urlshtrn.app.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlController {
    final
    UrlRepo urlRepo;

    public UrlController(UrlRepo urlRepo) {
        this.urlRepo = urlRepo;
    }

    @GetMapping("/")
    public String home(Model model){
        Url url = new Url();
        model.addAttribute("urlObj",url);
        return "Home";
    }


    @PostMapping("/save")
    public String addingNewName(Url url , Model model){
        String newUrl = "http://localhost:8080/"+url.getNewName();
        url.setNewAddress(newUrl);
        if(url.getOldAddress().startsWith("www.")){
            url.setOldAddress("http://"+url.getOldAddress());
        }
        urlRepo.save(url);
        model.addAttribute("info",newUrl);
        return "DisplayInfo";
    }
    @GetMapping("/url/{name}")
    public String redirectToUrl(@PathVariable String name){
        Url url = urlRepo.findByNewName(name);
        return "redirect:"+url.getOldAddress();
    }
}
