package SoundSystem;

/**
 * Created by JAbanto on 10.05.2017.
 *
 * crearemos algunos beans que representen algunos de los componentens de un equipo estereo .
 * primero crearemos un clase o interface {@link CompactDisc} que Srping detectara y creara como bean .
 * Despues crearemos la clase {@link CDPlayer} para que Spring la detecte y le inyecte el bena al CompactDisc
 *
 */
public interface CompactDisc {


    /*
    los detalles concretos de la interfaz CompactDisc no son importantes, pero si que la hayamos definido como tal.
    Como interfaz , define el contrato mediante el que un reporductors de CD puede operar con un Cd, y reduce al
    minido la relacioon  entre cualquier implementacion de un reproductor de CD y el proio Cd

    No obstante seguiemos necesitando un implmentacion de CompactDics . DE echo podriamos tener Varias. En
    este Caso comezaremos con uzna la clase SgtPeppers mostrada en el siguieente Listado
     */

    void play();
}

