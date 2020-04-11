package SoundSystem;


import org.springframework.stereotype.Component;

/**
 * Aunque no asignamos implicitamente un Id al bean , se le asigno und derivado de sunombre con la primera
 * leatraminusculas  si queremo asignar un id determinada podemos hacerloo facilmente como veremos a continuacion
 * agregando acomponent el nombre del ID DESEADO EN este caso "lonelyHeartsClub"
 */

/*
Id in Component definieren

 tambieon podemos utilizar @Named  pero borrando Component  en este caso Named viene
 de el modulo Java JSR-330 es casi igual a Component
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {

    private  String title = "Sgt. Pepper´s Lonely Hearts Club Band";
    private  String artist = "The Beatles";

    public void play(){

        /*
        para pasar el test quite ln
         */

        System.out.print("Playing " + title + " by " + artist);
    }

}
