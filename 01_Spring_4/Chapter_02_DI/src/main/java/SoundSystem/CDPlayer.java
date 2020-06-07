package SoundSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JAbanto on 10.05.2017.
 */

@Component
public class CDPlayer implements MediaPlayer {


    /**
     * Conexcion automatica para que spring detecte la dependencias
     * es un forma que Spring satisfaga automaticamente dependencias de un Bean buscando a otros bean de la aplicacion      que coindida con sus necesidad . para indicar que debe realizarse la conexion automatica , se utilizada la
     * anotacion
     * @Autowired de Spring
     */

    private CompactDisc compactDisc;


    /**
     * fijese en la clse CDPLayer . Su constructor se anota con Autowired . lo que indica que cuando Spring cree el
     * Bean CD Player , debe instanciarlo a travez de ese constructor y pasar un bean que se asigne a CompactDisc
     * @param cd
     */

    @Autowired
    public CDPlayer(CompactDisc cd){

        this.compactDisc = cd;
    }

    public void play(){

        compactDisc.play();
    }

    /**
     * el uso de Autowired no se limita constructores , tambien se puede usar en el metodo de establecimiento de
     * un propiedadd , por ejemplo si {@link CDPlayer} tuviera un metodo setCompactDisc(), se podria anotar para la
     * conexion automatica de esta forma
     *
     */

    // @Autowired(required = false)
    public void setCompactDisc(CompactDisc disc){
        /*
     Despues de que spring haya instanciado el Bean , intentara satisfacer öas dependencias expresadas a travez de de
     metodos como setCompactDisc que estan anotados
      */
         this.compactDisc = disc;
     }

    /**
     * en realidad no hay nada especial con los metodos de establecimiento @Autowired tambien se puede aplicar a cualquier otro metodo de la clase. si {@link CDPlayer} tuvier un metodo insertDisc(); @Autowired funcionaria igual de
     * bien que en setCompactDisc
     */


    /*
        Si no queire utilizar @Autowired puede usar @Inject que proviene de la especificacion Java Dependency Injection
        como @Named estos dos son admitidos por Spring son ligeramente distintos pero puede utiliyarze como
        @Autowired
     */
    //@Autowired(required = false)
    public void insertDisc(CompactDisc discInserting){

        this.compactDisc = discInserting;

        /**
         * Independientemente de si se trata de un construtor o un metodo Spring intentara satifacer la dependia expresada en los parametros dek metodo , si no hay benn que conincidadn Spring generara un exception cuando cree
         * el context , para evitarala puede usar Autowired(required=false)
         * con esto Spring intentra hacer la conexcion pero sino hay bena que coincidad , el bean se dejara sin conectar
         *
         */
    }

    /*
    COMCLUSIONES

     */

    /**
     * aUNQUE EN MUCHOS CASO PREFIERA UAR LA AUTOCONFIGURATION DE sPRING CON ANALISISI DE COMPONENTS Y CONEXCION AUTOMATICA ; EN otros  tendremos que configurar Spring de manera explicita , Por ejemplo , imagine que quiere conectar componentes de una biblioteca de terceros a su aplicacion , Como no dispone
     * del codigo fuente de dicha biblioteca , no puede anotar sus clases con @Component y Autowired
     * , Por tanto tendra que recurrir a la configuracion explicita, tenemos dos opciones
     * java o Xml
     *
     * como mecionamos antes JavaConfig es la opcion preferida para la configuracion explicita ya que es mas potente , ofrece seguridad de tipos y permite la refactorizacion
     *
     * Cabe decir que el analisisi de componentes con Componnet Scan y Concetra java Benas con Java Config
     * de manera explita , se pueden usar conjuntamente
     *
     */




}
