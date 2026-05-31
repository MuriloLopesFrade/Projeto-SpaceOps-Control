package Entidades.RoboExplorador;

import Interface.CalculavelIPO;

public class RoboTerrestre extends RoboExplorador implements CalculavelIPO {

    /*
        Classe feita para representar robôs responsáveis pela exploração da superfície planetária.
     */

    private double distanciaPercorrida;
    private double inclinacaoSuportada;
    private double temperaturaSolo;

    public RoboTerrestre(int id, String nome, double nivelBateria, double velocidade, double distanciaPercorrida, double inclinacaoSuportada, double temperaturaSolo) {
        super(id, nome, nivelBateria, velocidade);
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
    public double calcularAutonomiaTerreno(double inclinacaoAtual){

        /*
            Calcula a autonomia restante considerando:

            - distância percorrida.
            - bateria;
            - inclinação do terreno;

            Exemplo de regra:

            -Quanto maior a inclinação do terreno, maior será o consumo de energia.
         */

        double nivelBateria = getNivelBateria();

        double autonomiaBase = nivelBateria * 10;
        double desgaste = distanciaPercorrida * 0.1;
        double penalidadeTerreno = inclinacaoAtual * 2;

        double autonomia = autonomiaBase - desgaste - penalidadeTerreno;

        return autonomia;
    }

    public void atualizarBateria(double inclinacaoAtual){

        double nivelBateria = getNivelBateria();

        double consumoDistancia = distanciaPercorrida * 0.05;
        double consumoInclinacao = inclinacaoAtual * 0.2;
        double consumoTotal = consumoDistancia + consumoInclinacao;

        nivelBateria -= consumoTotal;

        if (nivelBateria < 0) {
            nivelBateria = 0;
        }

        setNivelBateria(nivelBateria);
    }

    // Métodos erdados da SuperClasse

    public double calcularDesempenho(){
        return 0;
    }

    public String obterStatus(){

        if (getNivelBateria() >= 70) {
        return "OPERACIONAL";
        }

        if (getNivelBateria() >= 30) {
            return "ATENÇÃO";
        }

        return "CRÍTICO";
    }

    public void atualizarBateria() {}

    public String gerarRelatorio(){

        String aux = "";

        aux += "Distancia percorrida: "+ distanciaPercorrida+"\n";
        aux += "Inclinacao suportada: "+ inclinacaoSuportada+"\n";
        aux += "temperatura do Solo: "+ temperaturaSolo+"\n";
        aux += "Desempenho: "+ calcularDesempenho()+"\n";
        aux += "Distancia Percorrida: "+ distanciaPercorrida+"\n";
        aux += "Status: "+ obterStatus() +"\n";

        return aux;
    }

    // Métodos erdados das Interfaces

    public double fornecerIndiceIPO(){return 0;}

}
