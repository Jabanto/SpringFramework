package es.pildoras.spring.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

    //Metodo encagragado de propocinarnos vista , tambien hay que decir es el archivor de mapear cual es archivo /vista a ver
    @RequestMapping
    public String muestraPagina(){

        return "paginaEjemplo";
    }

}
