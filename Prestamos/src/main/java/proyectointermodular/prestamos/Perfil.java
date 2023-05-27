/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

/**
 * Clase Perfil que contiene los datos de usuario de un cliente, incluyendo si tiene pareja que es cliente del banco.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Perfil {

    //Atributos
    private String usuario;
    private String password;
    private SituacionCivil situacionCivil;
    private SituacionLaboral situacionLaboral;
    private boolean esMoroso;
    private boolean procesoJudicial;
    private String idConyuge;
    private boolean gananciales;

    /**
     * Constructor por parámetros que recibe todos los valores de los atributos y crea un objeto Perfil.
     *
     * @param usuario Parámetro de tipo String que será el nombre de usuario.
     * @param password Parámetro de tipo String que será la contraseña.
     * @param situacionCivil Parámetro de tipo SituacionCivil que será un Enum de situaciones civiles.
     * @param situacionLaboral Parámetro de tipo SituacionLaboral que será un Enum de situaciones laborales.
     * @param esMoroso Parámetro de tipo boolean que será true si es moroso y false si no lo es.
     * @param procesoJudicial Parámetro de tipo boolean que será true si tiene asuntos judiciales y false si no los tiene.
     * @param idConyuge Parámetro de tipo String que será el id del cónyuge cliente del banco.
     * @param gananciales Parámetro de tipo boolean que será true si están casados en regimen ganacial o false si no lo están.
     */
    public Perfil(String usuario, String password, SituacionCivil situacionCivil, SituacionLaboral situacionLaboral, boolean esMoroso, boolean procesoJudicial, String idConyuge, boolean gananciales) {
        this.usuario = usuario;
        this.password = password;
        this.situacionCivil = situacionCivil;
        this.situacionLaboral = situacionLaboral;
        this.esMoroso = esMoroso;
        this.procesoJudicial = procesoJudicial;
        this.idConyuge = idConyuge;
        this.gananciales = gananciales;
    }

    @Override
    public String toString() {
        return "Perfil{" + "usuario=" + usuario + ", password=" + password + ", situacionCivil=" + situacionCivil + ", situacionLaboral=" + situacionLaboral + ", esMoroso=" + esMoroso + ", procesoJudicial=" + procesoJudicial + ", idConyuge=" + idConyuge + ", gananciales=" + gananciales + '}';
    }

    /**
     * Método isEsMoroso que devuelve el valor del atributo esMoroso.
     *
     * @return Devuelve un boolean.
     */
    public boolean isEsMoroso() {
        return esMoroso;
    }

    /**
     * Método isProcesoJudicial que devuelve el valor del atributo procesoJudicial.
     *
     * @return Devuelve un boolean.
     */
    public boolean isProcesoJudicial() {
        return procesoJudicial;
    }

    /**
     * Método getSituacionLaboral que devuelve el valor del atributo situacionLaboral.
     *
     * @return Devuelve un SituacionLaboral.
     */
    public SituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    /**
     * Método getSituacionCivil que devuelve el valor del atributo situacionCivil.
     *
     * @return Devuelve un SituacionCivil.
     */
    public SituacionCivil getSituacionCivil() {
        return situacionCivil;
    }

    /**
     * Método isGananciales que devuelve el valor del atributo gananciales.
     *
     * @return Devuelve un boolean.
     */
    public boolean isGananciales() {
        return gananciales;
    }

    /**
     * Método getIdConyuge que devuelve el valor del atributo idConyuge.
     *
     * @return Devuelve un String.
     */
    public String getIdConyuge() {
        return idConyuge;
    }

}
