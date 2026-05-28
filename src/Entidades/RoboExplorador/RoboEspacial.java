package Entidades.RoboExplorador;

import Interface.CalculavelIPO;
import Interface.Monitoravel;

public class RoboEspacial extends RoboExplorador implements Monitoravel, CalculavelIPO {

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

    public RoboEspacial(int id, String nome, String status, double nivelBateria, double velocidade, double altitudeOrbital, double combustivel, double nivelRadiacao) {
        super(id, nome, status, nivelBateria, velocidade);
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

    // Métodos erdados da SuperClasse
    public double calcularDesempenho() {return 0;}

    public String gerarRelatorio() {return null;}

    // Métodos erdados das Interfaces

    public double CalculavelIPO() {return 0;}

    public double Monitoravel() {return 0;}

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

}
