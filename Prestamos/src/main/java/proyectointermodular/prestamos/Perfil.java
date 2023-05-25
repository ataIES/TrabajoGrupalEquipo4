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
    private Cliente pareja;
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
     * @param pareja Parámetro de tipo Cliente que será su pareja en caso de que también sea cliente del banco.
     * @param gananciales Parámetro de tipo boolean que será true si están casados en regimen ganacial o false si no lo están.
     */
    public Perfil(String usuario, String password, SituacionCivil situacionCivil, SituacionLaboral situacionLaboral, boolean esMoroso, boolean procesoJudicial, Cliente pareja, boolean gananciales) {
        this.usuario = usuario;
        this.password = password;
        this.situacionCivil = situacionCivil;
        this.situacionLaboral = situacionLaboral;
        this.esMoroso = esMoroso;
        this.procesoJudicial = procesoJudicial;
        this.pareja = pareja;
        this.gananciales = gananciales;
    }

    @Override
    public String toString() {
        return "\nPerfil{" + "usuario=" + usuario + ", password=" + password + ", situacionCivil=" + situacionCivil + ", situacionLaboral=" + situacionLaboral + ", esMoroso=" + esMoroso + ", procesoJudicial=" + procesoJudicial + ", pareja=" + pareja + ", gananciales=" + gananciales + '}';
    }

    
    //GETs
    public boolean isEsMoroso() {
        return esMoroso;
    }

    public boolean isProcesoJudicial() {
        return procesoJudicial;
    }

    public SituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    public SituacionCivil getSituacionCivil() {
        return situacionCivil;
    }

    public Cliente getPareja() {
        return pareja;
    }

    public boolean isGananciales() {
        return gananciales;
    }

}
