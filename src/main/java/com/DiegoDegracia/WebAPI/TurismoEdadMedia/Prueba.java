package com.DiegoDegracia.WebAPI.TurismoEdadMedia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Prueba {
    @GetMapping("/prueba")
    public String prueba(@RequestParam(name="id", required=false, defaultValue = "") Integer id, Model model) {
        return "prueba";
    }
}