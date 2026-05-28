package Entidades.RoboExplorador;

import Interface.CalculavelIPO;
import Interface.Monitoravel;

public class RoboTerrestre extends RoboExplorador implements Monitoravel, CalculavelIPO {

    /*
        Classe feita para representar robôs responsáveis pela exploração da superfície planetária.
     */

    private double distanciaPercorrida;
    private double inclinacaoSuportada;
    private double temperaturaSolo;

    public RoboTerrestre(int id, String nome, String status, double nivelBateria, double velocidade, double distanciaPercorrida, double inclinacaoSuportada, double temperaturaSolo) {
        super(id, nome, status, nivelBateria, velocidade);
        this.distanciaPercorrida = distanciaPercorrida;
        this.inclinacaoSuportada = inclinacaoSuportada;
        this.temperaturaSolo = temperaturaSolo;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public double getInclinacaoSuportada() {
        return inclinacaoSuportada;
    }

    public double getTemperaturaSolo() {
        return temperaturaSolo;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public void setInclinacaoSuportada(double inclinacaoSuportada) {
        this.inclinacaoSuportada = inclinacaoSuportada;
    }

    public void setTemperaturaSolo(double temperaturaSolo) {
        this.temperaturaSolo = temperaturaSolo;
    }

    // Método específico da classe
    public double calcularAutonomiaTerreno(){

        /*
            Calcula a autonomia restante considerando:

            - distância percorrida.
            - bateria;
            - inclinação do terreno;

            Exemplo de regra:

            -Quanto maior a inclinação do terreno, maior será o consumo de energia.
         */
        return 0;
    }

    // Métodos erdados da SuperClasse

    public double calcularDesempenho(){
        return 0;
    }
    public String gerarRelatorio(){
        return null;
    }

    // Métodos erdados das Interfaces

    public String obterStatus(){return null;}
    public double fornecerIndice(){return 0;}



}
