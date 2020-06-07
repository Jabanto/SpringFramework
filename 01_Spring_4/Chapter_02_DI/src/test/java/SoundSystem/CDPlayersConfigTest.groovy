package SoundSystem

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by JAbanto on 10.05.2017.
 * {@link CDPlayersConfigTest} recurre a SpringJUnit4ClassRunner.class de Spring para que
 * se cree automaticamente un contexto de aplicacion de Spring al iniciarse la pruebe , y la anotacion
 * @ContextConfiguration le indica  que cargue su configuracion desde la clase {@link CDPlayersConfig}
 *
 *  Esta prueba solo es para un bean pero podemos implemetarla par todos los que deseemos
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayersConfig.class)
public class CDPlayersConfigTest  {

    /**
     * para demostrarlo la prueba tiene una propiedad de tipo {@Link CompactDisc} anotada con @Autowired
     * para inyectar el bean {@link CompactDisc} en la Prueba (describieremos mas adelan Autowired).
     *
     */
    /*
    COMPROBAR CONFIGURACION AUTOMATICA
     */

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    /**
     * Despues de anotar el constrctor de {@link CDPlayer} con @Autowired, puede estar seguro
     * de que Sprng le inyectara automaticamente un bean asignable a CompactDisc.
     * para comporbarlo , haremos reporducir el compactdisc a travez del bean {@link CDPlayer}
     */

    @Autowired
    private MediaPlayer player;


    /*
    Fin Conprobacion de AUTOCONFIGURACION DE SPRING
     */

    @Autowired
    private CompactDisc cd;
    /**
     * por ultimo , un sencillo metodo de prueba se agura que la propieada cd no sea null significa que Spring
     * ha podido detectar la clase {@link CompactDisc } automaticamente la crea como bean en el contexto de aplicacion
     * de spring y la inyecta en la prueba
     */

    @Test
    public void cdSchouldNotbeNull(){

        assertNotNull(cd);

    }

    /*
    TEST para Comprobar la autoconfiguracion
     */

    /**
     * Ademas de inyectar CompactDisc, se incluye el bena CDplayer en la variable miembro player
     * de la prueba (como tipo {@link MediaPlayer}) en el metodo de prueba play(), se invoca el metodo play()
     * en CDPlayer y se comprueba que realiza
     * la tarea esperada.
     *
     * Utilizamos {@Link SystemOutRule} en lugar de System.out que es una regla de Junit
     * que nos permite realizar afirmacipones sobre lo que haya escrito en la consosla
     * .en este Caso comprueba que el mesaje del metodo SgtPeppers. play
     * se ha enviado a la consolo.
     *
     */

    @Test
    public void play(){

        systemOutRule.clearLog();
        String test = player.play();
        assertEquals("Playing Sgt. Pepper´s Lonely Hearts Club Band" + " by The Beatles",
        systemOutRule.getLog());

    }

}
