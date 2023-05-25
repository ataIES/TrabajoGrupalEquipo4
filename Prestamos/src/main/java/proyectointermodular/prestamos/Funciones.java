/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointermodular.prestamos;

/**
 * Clase Funciones que contiene métodos estáticos auxiliares.
 *
 * @author Víctor Sánchez Llada, César Torre, Efrén Gutiérrez y Adrián Tresgallo.
 */
public class Funciones {

    /**
     * Método estático aptoParaPrestamo que recibe por parámetro un objeto Cliente y devuelve un boolean si es apto para recibir un préstamo o no.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un boolean.
     */
    public static boolean aptoParaPrestamo(Cliente cliente) {

        boolean apto = false;

        if (!esMorosoOJudical(cliente)) { //Si el cliente NO es moroso/asunto judicial

            if (esDesempleadoOEstudianteOAmoCasa(cliente)) { //Si el cliente es Desempleado, estudiante o amo de casa hay que comprobar si tiene pareja cliente del banco en régimen ganancial.

                if (esCasado(cliente)) { //Si el cliente está casado

                    Cliente pareja = cliente.getPerfil().getPareja(); //Recuperamos el objeto pareja para saber si está casado con un cliente del banco.

                    if (pareja != null) { //Si el objeto pareja no es null es que existe como cliente. Hay que analizar a la pareja.

                        if (pareja.getPerfil().isGananciales()) { //Si están casados en régimen ganancial.

                            if (!esMorosoOJudical(pareja)) { //Si la pareja NO es moroso/asunto judicial.

                                if (!esDesempleadoOEstudianteOAmoCasa(pareja)) { //Si la pareja no está desempleado, estudiante o amo de casa.

                                    if (tieneBasesMinimas(pareja)) { //Si cumple con las bases mínimas la pareja es APTA para solicitar un préstamo.
                                        apto = true;
                                    } else { //Si no cumple con las bases mínimas la pareja no es APTA para solicitar un préstamo.
                                        System.out.println("Préstamo no concedido: No cumple con las bases mínimas.");
                                    }

                                } else { //Si la pareja es desempleada, estudiante o amo de casa.
                                    System.out.println("Préstamo no concedido: Pareja Desempleado, estudiante o amo de casa.");
                                }

                            } else { //Pareja con morosidad o asuntos judiciales.
                                System.out.println("Préstamo no concedido: Morosidad o asuntos judiciales.");
                            }

                        } else { //Si no tienen régimen ganancial.
                            System.out.println("Préstamo no concedido: Su pareja es cliente del banco pero tienen no tienen régimen ganancial.");
                        }

                    } else { //Casado pero la pareja no es cliente del banco.
                        System.out.println("Préstamo no concedido: Casado pero su pareja no es cliente del banco.");
                    }

                } else { //Es desempleado, estudiante o amo de casa y no está casado.
                    System.out.println("Préstamo no concedido: Desempleado, estudiante o amo de casa + Casado no.");
                }

            } else { //El cliente está trabajando por cuenta propia, ajena o es pensionista.

                if (tieneBasesMinimas(cliente)) { //Si cumple con las bases mínimas el cliente es APTO para solicitar un préstamo.
                    apto = true;
                } else { //Si no cumple con las bases mínimas el cliente no es APTO para solicitar un préstamo.
                    System.out.println("Préstamo no concedido: No cumple con las bases mínimas.");
                }
            }

        } else { //Si el cliente TIENE morosidad o proceso judicial.
            System.out.println("Préstamo no concedido: Morosidad o asuntos judiciales.");
        }

        return apto;

    }

    /**
     * Método estático cantidadPrestamo que recibe por parámetro un objeto Cliente y devuelve un double con la cantidad que le corresponde de préstamo.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un double.
     */
    public static double cantidadPrestamo(Cliente cliente) {

        double cantidad;
        double mediaAnual = cliente.getCuentaBancaria().getMediaNominaAnual();
        double ultNomina = cliente.getCuentaBancaria().getNominaUltMes();

        if ((mediaAnual >= 1000 || mediaAnual < 2000) && (ultNomina >= 1000 || ultNomina < 2000)) {
            cantidad = 5000;
        } else if ((mediaAnual >= 2000 || mediaAnual < 3000) && (ultNomina >= 2000 || ultNomina < 3000)) {
            cantidad = 10000;
        } else {
            cantidad = 15000;
        }

        return cantidad;

    }

    /**
     * Método estático esMorosoOJudical que recibe por parámetro un objeto Cliente y devuelve un boolean si es moroso o tiene asuntos judiciales.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un boolean.
     */
    private static boolean esMorosoOJudical(Cliente cliente) {
        return cliente.getPerfil().isEsMoroso() || cliente.getPerfil().isProcesoJudicial();
    }

    /**
     * Método estático esDesempleadoOEstudianteOAmoCasa que recibe por parámetro un objeto Cliente y devuelve un boolean si está desempleado, estudiante o amo de casa.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un boolean.
     */
    private static boolean esDesempleadoOEstudianteOAmoCasa(Cliente cliente) {
        SituacionLaboral situacionLaboral = cliente.getPerfil().getSituacionLaboral();
        return situacionLaboral == SituacionLaboral.DESEMPLEADO || situacionLaboral == SituacionLaboral.ESTUDIANTE || situacionLaboral == SituacionLaboral.AMO_DE_CASA;
    }

    /**
     * Método estático esCasado que recibe por parámetro un objeto Cliente y devuelve un boolean si está casado.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un boolean.
     */
    private static boolean esCasado(Cliente cliente) {
        SituacionCivil situacionCivil = cliente.getPerfil().getSituacionCivil();
        return situacionCivil == SituacionCivil.CASADO;
    }

    /**
     * Método estático tieneBasesMinimas que recibe por parámetro un objeto Cliente y devuelve un boolean si cumple con las bases mínimas.
     *
     * @param cliente Parámetro de tipo Cliente.
     * @return Devuelve un boolean.
     */
    private static boolean tieneBasesMinimas(Cliente cliente) {

        boolean basesMinimas = false;

        if (cliente.getCuentaBancaria().getMediaNominaAnual() >= 1000) { //Si la media anual de la nómina es >= 1000.

            if (cliente.getCuentaBancaria().getNominaUltMes() >= 1000) { //Si la última nómina es >= 1000. La pareja es APTA para solicitar un préstamo.
                basesMinimas = true;
            } else { //Si la última nómina es < 1000. La pareja no es APTA para solicitar un préstamo.
                System.out.println("Préstamo no concedido: La cantidad de la última nómina no cumple los requisitos.");
            }

        } else { //Si la media anual de la nómina es < 1000.
            System.out.println("Préstamo no concedido: La media anual de la nómina no cumple los requisitos.");
        }

        return basesMinimas;

    }

}
