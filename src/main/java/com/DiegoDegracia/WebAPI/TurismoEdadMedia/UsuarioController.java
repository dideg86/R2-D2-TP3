package com.DiegoDegracia.WebAPI.TurismoEdadMedia;

import com.DiegoDegracia.DataRepositorio.UsuarioRepositorio;
import com.DiegoDegracia.Modelos.Repositorios.IUsuarioRepositorio;
import com.DiegoDegracia.Modelos.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsuarioController {
    @GetMapping("/usuario")
    public String greeting(@RequestParam(name="id", required=false, defaultValue = "") Integer id, Model model) {
        IUsuarioRepositorio usuarios = new UsuarioRepositorio();

        Usuario usr = usuarios.Obtener(1);

        if(usr == null){
            model.addAttribute("nombre", "Sin usuario");
            model.addAttribute("tiempo", "Sin tiempo");
            model.addAttribute("presup", "Sin monedas");
        }else{
            model.addAttribute("nombre", usr.getNombre());
            model.addAttribute("tiempo", usr.getTiempoDisponible());
            model.addAttribute("presup", usr.getPresupuesto());
        }


        return "usuario";
    }

}
