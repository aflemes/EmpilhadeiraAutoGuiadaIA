/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.model;

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
    
    public Empilhadeira[] getEmpilhadeira() {
        return empilhadeira;
    }

    public void setEmpilhadeira(Empilhadeira[] empilhadeira) {
        this.empilhadeira = empilhadeira;
    }

    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public void setTamPopulacao(int tamPopulacao) {
        this.tamPopulacao = tamPopulacao;
    }
    
    
}
