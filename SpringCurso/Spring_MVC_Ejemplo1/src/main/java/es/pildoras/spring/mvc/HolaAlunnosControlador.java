package es.pildoras.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaAlunnosControlador {

        // Metodo para pedir el formulario, proporciona el formulario
        // o Pedirle al servidor el formulario pedido
        // RequestMapping tiene una pararemtro  que es una peticion de una URL (especificamos la url que tiene que utilizar el usuario para que servidor le devuelva el formulario)
        // normalmente pra hacer el nombre de la url se utiliza el nombre del metodo aunque no siempre
        // RequestMapping lo podemos traducirlo como peticion de url
        @RequestMapping("/muestraFormulario")
        public String muestraFormulario(){

            return "HolaAlumnosFormulario";
        }


        // y otro metodo que sea capaz de trabajar/procesar la informcion del formulario cuando esta sea enviada
        // una vez procesado se enviara un JSP /html como respuesta a la view HolaAlumnosSpring
        @RequestMapping("/procesarFormulario")
        public String procesarFormulario(){

            return "HolaAlumnosSpring";
        }

}
