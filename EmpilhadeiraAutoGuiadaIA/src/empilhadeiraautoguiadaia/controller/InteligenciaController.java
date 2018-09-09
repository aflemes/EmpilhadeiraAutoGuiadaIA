/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.controller;

import empilhadeiraautoguiadaia.model.Coordenadas;
import empilhadeiraautoguiadaia.model.Populacao;
import empilhadeiraautoguiadaia.model.Empilhadeira;
import java.util.ArrayList;
import java.util.Random;

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
    private ArrayList<String> posibilidades;
    
    /**
     *
     */
    public InteligenciaController() {
        this.posibilidades = new ArrayList<String>();
        
        this.posibilidades.add("Sul");
        this.posibilidades.add("Norte");
        this.posibilidades.add("Oeste");
        this.posibilidades.add("Leste");
    }

    public ArrayList<String> getPosibilidades() {
        return posibilidades;
    }

    public void setPosibilidades(ArrayList<String> posibilidades) {
        this.posibilidades = posibilidades;
    }
    
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
        //
        return labirinto[coordenadas.getY()][coordenadas.getX()];
    }
    
    public static Populacao novaGeracao(Populacao populacao, boolean elitismo) {
        Random r = new Random();
        //nova população do mesmo tamanho da antiga
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        //se tiver elitismo, mantém o melhor indivíduo da geração atual
        if (elitismo) {
            novaPopulacao.setEmpilhadeira(populacao.getEmpilhadeira(0));
        }

        //insere novos indivíduos na nova população, até atingir o tamanho máximo
        while (novaPopulacao.getNumEmpilhadeiras()< novaPopulacao.getTamPopulacao()) {
            //seleciona os 2 pais por torneio
            Empilhadeira[] pais = selecaoTorneio(populacao);

            Empilhadeira[] filhos = new Empilhadeira[2];

            //verifica a taxa de crossover, se sim realiza o crossover, se não, mantém os pais selecionados para a próxima geração
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = new Empilhadeira(pais[0].getDirecao());
                filhos[1] = new Empilhadeira(pais[1].getDirecao());
            }

            //adiciona os filhos na nova geração
            novaPopulacao.setEmpilhadeira(filhos[0]);
            novaPopulacao.setEmpilhadeira(filhos[1]);
        }

        //ordena a nova população
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }
    
    public static Empilhadeira[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        //seleciona 3 indivíduos aleatóriamente na população
        populacaoIntermediaria.setEmpilhadeira(populacao.getEmpilhadeira(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setEmpilhadeira(populacao.getEmpilhadeira(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setEmpilhadeira(populacao.getEmpilhadeira(r.nextInt(populacao.getTamPopulacao())));

        //ordena a população
        populacaoIntermediaria.ordenaPopulacao();

        Empilhadeira[] pais = new Empilhadeira[2];

        //seleciona os 2 melhores deste população
        pais[0] = populacaoIntermediaria.getEmpilhadeira(0);
        pais[1] = populacaoIntermediaria.getEmpilhadeira(1);

        return pais;
    }
    
    public static Empilhadeira[] crossover(Empilhadeira empilha1, Empilhadeira empilha2) {
        Random r = new Random();
        //sorteia o ponto de corte
        int pontoCorte1 = r.nextInt((empilha1.getDirecao().size()/2) -2) + 1;
        int pontoCorte2 = r.nextInt((empilha1.getDirecao().size()/2) -2) + empilha1.getDirecao().size()/2;

        Empilhadeira[] filhos = new Empilhadeira[2];

        //pega os genes dos pais
        ArrayList<String> genePai1 = empilha1.getDirecao();
        ArrayList<String> genePai2 = empilha2.getDirecao();

        ArrayList<String> geneFilho1 = new ArrayList<String>();
        ArrayList<String> geneFilho2 = new ArrayList<String>();

        //realiza o corte do Gene 1 
        for (int nodo = 0; nodo < pontoCorte1; nodo++) {
            geneFilho1.add(genePai1.get(nodo));
        }
        for (int nodo = pontoCorte1; nodo < pontoCorte2; nodo++) {
            geneFilho1.add(genePai2.get(nodo));
        }
        for (int nodo = pontoCorte2; nodo < genePai1.size(); nodo++) {
            geneFilho1.add(genePai1.get(0));
        }
        
        //realiza o corte do Gene 2 
        for (int nodo = 0; nodo < pontoCorte1; nodo++) {
            geneFilho2.add(genePai2.get(nodo));
        }
        for (int nodo = pontoCorte1; nodo < pontoCorte2; nodo++) {
            geneFilho2.add(genePai1.get(nodo));
        }
        for (int nodo = pontoCorte2; nodo < genePai1.size(); nodo++) {
            geneFilho2.add(genePai2.get(0));
        }
        //cria o novo indivíduo com os genes dos pais
        filhos[0] = new Empilhadeira(geneFilho1);
        filhos[1] = new Empilhadeira(geneFilho2);

        return filhos;
    }  

}
