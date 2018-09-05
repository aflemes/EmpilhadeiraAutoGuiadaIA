/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empilhadeiraautoguiadaia.model;

import java.util.ArrayList;
import empilhadeiraautoguiadaia.controller.InteligenciaController;
import empilhadeiraautoguiadaia.model.Coordenadas;
import empilhadeiraautoguiadaia.view.Principal;
import java.util.Random;

/**
 *
 * @author skyli
 */
public class Empilhadeira {

    private ArrayList<String> direcao;
    private InteligenciaController controller;
    private int aptidao;
    private Coordenadas posicao;
    /*
    numGenes seria cada possivel passo
    */
    public Empilhadeira(int numGenes) {
        ArrayList<String> possibilidades = new ArrayList<>();
        Random random = new Random();
        
        controller = new InteligenciaController();
        
        possibilidades.add("Sul");
        possibilidades.add("Norte");
        possibilidades.add("Oeste");
        possibilidades.add("Leste");
        
        for (int i = 0; i < numGenes; i++) {
            //gera as possibilidades
            direcao.add(possibilidades.get(random.nextInt(4)));
        }
        posicao.setX(0);
        posicao.setY(10);
        
        geraAptidao();
    }
    //gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
        //busca a saida do labirinto
        ArrayList<Coordenadas> solucao = controller.getSolucao();
       
        for (int i = 0; i < controller.getNumGenes(); i++) {
            switch(direcao.get(i)){
                case "Norte":
                    aptidao += ultrapassaLimites("Norte");
                    break;
                case "Sul":
                    aptidao += ultrapassaLimites("Sul");
                    break;
                case "Leste":
                    aptidao += ultrapassaLimites("Leste");
                    break;
                case "Oeste":
                    aptidao += ultrapassaLimites("Oeste");
                    break;
            }
            if (verificaSolucao())
                break;
        }
    }
    public ArrayList<String> getDirecao() {
        return direcao;
    }

    public void setDirecao(ArrayList<String> direcao) {
        this.direcao = direcao;
    }

    public int getAptidao() {
        return aptidao;
    }

    public void setAptidao(int Aptidao) {
        this.aptidao = Aptidao;
    }
    
    private boolean verificaSolucao(){
        ArrayList<Coordenadas> solucao = controller.getSolucao();
        
        for (int i = 0; i < solucao.size(); i++) {
            if (posicao.getX() == solucao.get(i).getX() &&
                posicao.getY() == solucao.get(i).getY()){
                return true;
            }
        }
        
        return false;
    }
    private int ultrapassaLimites(String destino){
        String posicaoNoLabirinto = controller.getPosicaoLabirinto(posicao);
        
        switch (destino){
            case "Norte":               
                if (posicao.getY() - 1 > 0){
                    //nao extrapolou o limite do labirinto
                    if (posicaoNoLabirinto.indexOf("N") > 0){
                        //Esbarrou em uma parede
                        return -1;
                    }
                    else
                    {
                        //Nao encontrou nenhuma parede;
                        //Seta nova posicao
                        posicao.setY(posicao.getY() - 1);
                        return 5;
                    }
                }
                else
                    return -1;
            case "Sul":
                if (posicao.getY() + 1 < 10){
                    //nao extrapolou o limite do labirinto
                    if (posicaoNoLabirinto.indexOf("S") > 0){
                        //Esbarrou em uma parede
                        return -1;
                    }
                    else
                    {
                        //Nao encontrou nenhuma parede;
                        //Seta nova posicao
                        posicao.setY(posicao.getY() + 1);
                        return 5;
                    }
                }
                else
                    return -1;
                
            case "Leste":
                if (posicao.getX() + 1 < 10){
                    //nao extrapolou o limite do labirinto
                    if (posicaoNoLabirinto.indexOf("L") > 0){
                        //Esbarrou em uma parede
                        return -1;
                    }
                    else
                    {
                        //Nao encontrou nenhuma parede;
                        //Seta nova posicao
                        posicao.setX(posicao.getX() + 1);
                        return 5;
                    }
                }
                else
                    return -1;                
               
            case "Oeste":
                if (posicao.getX() - 1 > 0){
                    //nao extrapolou o limite do labirinto
                    if (posicaoNoLabirinto.indexOf("O") > 0){
                        //Esbarrou em uma parede
                        return -1;
                    }
                    else
                    {
                        //Nao encontrou nenhuma parede;
                        posicao.setX(posicao.getX() - 1);
                        return 5;
                    }
                }
                else
                    return -1;
        }
        
        return 0;
    }
      
}
