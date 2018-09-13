/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.model;

import java.util.ArrayList;

/**
 *
 * @author skyli
 */
public class Populacao {
    private Empilhadeira[] empilhadeira;
    private int tamPopulacao; 
   
    public Populacao(int numGenes, int tamPop) {
        tamPopulacao = tamPop;
        empilhadeira = new Empilhadeira[tamPop];
        for (int i = 0; i < empilhadeira.length; i++) {
            empilhadeira[i] = new Empilhadeira(numGenes);
        }
    }
    
    public Populacao(int tamPop) {
        tamPopulacao = tamPop;
        empilhadeira = new Empilhadeira[tamPop];
        for (int i = 0; i < empilhadeira.length; i++) {
            empilhadeira[i] = null;
        }
    }
    
    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public void setTamPopulacao(int tamPopulacao) {
        this.tamPopulacao = tamPopulacao;
    }
    
    //ordena a população pelo valor de aptidão de cada indivíduo, do maior valor para o menor, assim se eu quiser obter o melhor indivíduo desta população, acesso a posição 0 do array de indivíduos
    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < empilhadeira.length - 1; i++) {
                if (empilhadeira[i].getAptidao() < empilhadeira[i + 1].getAptidao()) {
                    Empilhadeira temp = empilhadeira[i];
                    empilhadeira[i] = empilhadeira[i + 1];
                    empilhadeira[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }
    
    //verifica se algum indivíduo da população possui a solução
    public boolean temSolucao() {
       
        for (int i = 0; i < tamPopulacao; i++) {
            if (empilhadeira[i].isEncontreiSaida()){
                return true;
            }
        }
        
        return false;
    }
    
    public int getMelhorSolucao() {
        
        for (int i = 0; i < tamPopulacao; i++) {
            if (empilhadeira[i].isEncontreiSaida()){
                if (empilhadeira[i].getAptidao() == 1480)
                    return i;
            }
        }
        
        return 0;
    }
    
    //número de indivíduos existentes na população
    public int getNumEmpilhadeiras() {
        int num = 0;
        for (int i = 0; i < empilhadeira.length; i++) {
            if (empilhadeira[i] != null) {
                num++;
            }
        }
        return num;
    }
    
    public void setEmpilhadeira(Empilhadeira empilha) {
        for (int i = 0; i < empilhadeira.length; i++) {
            if (empilhadeira[i] == null) {
                empilhadeira[i] = empilha;
                return;
            }
        }
    }
    
    //coloca um indivíduo em uma certa posição da população
    public void setEmpilhadeira(Empilhadeira individuo, int posicao) {
        empilhadeira[posicao] = individuo;
    }
    
    public Empilhadeira getEmpilhadeira(int pos) {
        return empilhadeira[pos];
    }
    
    public void getSolucaoOtima(){
        ArrayList<String> solucaoOtima = new ArrayList<String>();
        
        solucaoOtima.add("Norte");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Oeste");
        solucaoOtima.add("Oeste");
        solucaoOtima.add("Oeste");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Sul");
        solucaoOtima.add("Leste");
        solucaoOtima.add("Norte");
        solucaoOtima.add("Leste");
    }
    
    
    
    
}
