package Entidades.RoboExplorador;

import Interface.AvaliadorRisco;
import Interface.CalculavelIPO;

public class RoboEspacial extends RoboExplorador implements CalculavelIPO, AvaliadorRisco {

    /*

        Representa robôs que operam fora da superfície planetária.

        Exemplos:

        - robôs orbitais;
        - satélites autônomos;
        - drones espaciais.

     */

    private double altitudeOrbital;
    private double combustivel;
    private double nivelRadiacao;

    public RoboEspacial(int id, String nome, double nivelBateria, double velocidade, double altitudeOrbital, double combustivel, double nivelRadiacao) {
        super(id, nome, nivelBateria, velocidade);
        this.altitudeOrbital = altitudeOrbital;
        this.combustivel = combustivel;
        this.nivelRadiacao = nivelRadiacao;
    }

    public double getAltitudeOrbital() {
        return altitudeOrbital;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public double getNivelRadiacao() {
        return nivelRadiacao;
    }

    public void setAltitudeOrbital(double altitudeOrbital) {
        this.altitudeOrbital = altitudeOrbital;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public void setNivelRadiacao(double nivelRadiacao) {
        this.nivelRadiacao = nivelRadiacao;
    }

    // Método específico da classe
    public double calcularEstabilidadeOrbital(){

        /*
        Calcula a estabilidade da operação orbital considerando:

        - combustível;
        - radiação espacial;
        - altitude orbital.
         */

        return 0;
    }

    public void atualizarBateria(){}

    // Métodos erdados da SuperClasse
    public String gerarRelatorio() {return null;}

    public String obterStatus(){return null;}

    // Métodos erdados das Interfaces

    public double fornecerIndiceIPO(){return 0;}

    public double calcularRisco(){return 0;}


}
