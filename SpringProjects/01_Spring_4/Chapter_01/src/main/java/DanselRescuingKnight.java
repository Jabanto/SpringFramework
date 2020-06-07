/**
 * Created by JAbanto on 09.05.2017.
 */
public class DanselRescuingKnight implements Knight {

     /*
        Acoplamiento estrecho con el RescueDameelQuest

            tradicionalmente , cada objeto es responsable de obtener sus propias referencias
            a los negocios con los que coloboras(sus dependencias) esto genera condgio acoplado y
            dificil de probar o testear

     */

    // TODO: 09.05.2017 Deutsch Version

    private RescueDameelQuest quest;


    /**
     * @Link DanselRescuingKnight crea su propio reto
     * @Link RescueDammelQuest(rescatar ala princesa)
     * dentro del Constructor, esto hace que Dansel este muy acoplado
     * a RescueDammelQuest, limitando las acciones que Knight pueder hacer
     * es decir si hay que rescatar a la damisela se hara pero si hay que matar
     * a un dragon o otra accion el caballero no lo hara ademas
     * sera dificil de testerar el metodo {@lin embarkQuest()}
     *
     */

    /*
    el acoplamiento es necesario pero deber utilizarse con cuidado,
     */

    /**
     *  la DI implica otorgar a un objeto sus dependencias en lugar de que este tenga que obtenerlas por si solo
     *  es decir estas se inyectan en los objetos que las necesitan sin que estos la tengas que crear or si mismos
     *
     */

    public DanselRescuingKnight() {

        this.quest = new RescueDameelQuest();
    }

    public void embarkOnQuest(){

        quest.embarkt();
    }
}
