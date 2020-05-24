package es.pildoras.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaAlunnosControlador {

        //Metodo para pedir el formulario, proporciona el formulario
        // peduirle al servidor el formulario pedido
        // Peticion de una URL (especificamos la url que tiene que utilizar el usuario para que servidor le devuelva el formulario)
        // normalmente se utiliza la url el nombre del metodo aunque no siempre
        @RequestMapping("/muestraFormulario")
        public String muestraFormulario(){

            return "HolaAlumnosFormulario";
        }


        // y otro metodo que sea capaz de trabajar/procesa lainformcion del formulario cuandoesta sea enviada
        @RequestMapping("/procesarFormulario")
        public String procesarFormulario(){

            return "HolaAlumnosSpring";
        }

}
