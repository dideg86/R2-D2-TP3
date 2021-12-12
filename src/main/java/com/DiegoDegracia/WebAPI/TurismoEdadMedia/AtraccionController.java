package com.DiegoDegracia.WebAPI.TurismoEdadMedia;

import com.DiegoDegracia.DataRepositorio.AtraccionRepositorio;
import com.DiegoDegracia.DataRepositorio.RepoInterno.AtraccionRepoInterno;
import com.DiegoDegracia.Modelos.Atraccion;
import com.DiegoDegracia.Modelos.Repositorios.IAtraccionRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtraccionController {
    @GetMapping("/atraccion")
    public String atraccion(@RequestParam(name="id", required=false, defaultValue = "") Integer id, Model model) {
            IAtraccionRepositorio atracciones = new AtraccionRepositorio();
            Atraccion atr = atracciones.Obtener(1);

            if (atr == null) {
                model.addAttribute("nombre", "Sin atraccion");
                model.addAttribute("costo", "Sin costo");
            } else {
                model.addAttribute("nombre", atr.getNombre());
                model.addAttribute("costo", atr.getCosto());
            }

        return "atraccion";
    }
}