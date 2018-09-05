/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.controller;

import empilhadeiraautoguiadaia.model.Coordenadas;
import java.util.ArrayList;

/**
 *
 * @author skyli
 */

public class InteligenciaController {
    private static ArrayList<Coordenadas> solucao;
    private static String labirinto[][];
    private static int numGenes;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    private static String caracteres;
    
    public static ArrayList<Coordenadas> getSolucao() {
        return solucao;
    }

    public static void setSolucao(ArrayList<Coordenadas> solucao) {
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

    public static int getNumGenes() {
        return numGenes;
    }

    public static void setNumGenes(int numGenes) {
        InteligenciaController.numGenes = numGenes;
    }

    public static String[][] getLabirinto() {
        return labirinto;
    }

    public static void setLabirinto(String[][] labirinto) {
        InteligenciaController.labirinto = labirinto;
    }
    
    public String getPosicaoLabirinto(Coordenadas coordenadas){
        return labirinto[coordenadas.getX()][coordenadas.getY()];
    }

}
