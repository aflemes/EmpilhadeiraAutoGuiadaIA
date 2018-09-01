/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.controller;

import empilhadeiraautoguiadaia.model.Solucao;
import java.util.ArrayList;

/**
 *
 * @author skyli
 */

public class InteligenciaController {
    private static ArrayList<Solucao> solucao;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    private static String caracteres;

    public static ArrayList<Solucao> getSolucao() {
        return solucao;
    }

    public static void setSolucao(ArrayList<Solucao> solucao) {
        InteligenciaController.solucao = solucao;
    }

    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }

    public static void setTaxaDeCrossover(double taxaDeCrossover) {
        InteligenciaController.taxaDeCrossover = taxaDeCrossover;
    }

    public static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }

    public static void setTaxaDeMutacao(double taxaDeMutacao) {
        InteligenciaController.taxaDeMutacao = taxaDeMutacao;
    }

    public static String getCaracteres() {
        return caracteres;
    }

    public static void setCaracteres(String caracteres) {
        InteligenciaController.caracteres = caracteres;
    }
    
    
}
