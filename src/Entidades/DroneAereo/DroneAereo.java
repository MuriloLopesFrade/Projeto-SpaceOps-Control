package Entidades.DroneAereo;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.AvaliadorRisco;

public class DroneAereo extends EntidadeEspacial implements AvaliadorRisco {

    /*
        Representa drones utilizados para reconhecimento aéreo.
     */

    private double altitudeMaxima;
    private double areaMapeada;
    private double autonomiaVoo;

    public DroneAereo(int id, String nome, double altitudeMaxima, double areaMapeada, double autonomiaVoo) {
        super(id, nome);
        this.altitudeMaxima = altitudeMaxima;
        this.areaMapeada = areaMapeada;
        this.autonomiaVoo = autonomiaVoo;
    }

    public double getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public double getAreaMapeada() {
        return areaMapeada;
    }

    public double getAutonomiaVoo() {
        return autonomiaVoo;
    }

    public void setAltitudeMaxima(double altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }

    public void setAreaMapeada(double areaMapeada) {
        this.areaMapeada = areaMapeada;
    }

    public void setAutonomiaVoo(double autonomiaVoo) {
        this.autonomiaVoo = autonomiaVoo;
    }

    // Método específico da classe
    public double calcularCoberturaAerea(){
        return areaMapeada * (1+altitudeMaxima / 1000);
    }

    public double calcularAutonomiaFinalVoo(){

        double consumoAltitude = altitudeMaxima * 0.5;

        double consumoMapeamento =  calcularCoberturaAerea() * 0.2;

        return autonomiaVoo - consumoAltitude - consumoMapeamento;
    }

    // Método de interface
    public double calcularRisco(){
        return ((100-calcularAutonomiaFinalVoo())*0.7) + (calcularCoberturaAerea()*0.3);
    }

    // Métodos erdados da SuperClasse
    public String obterStatus() {

        String status;

        if (calcularAutonomiaFinalVoo() >= (autonomiaVoo*0.7)){
            status ="Operacional";
        } else if (calcularAutonomiaFinalVoo() >=(autonomiaVoo*0.3)) {
            status ="Atenção";
        } else {
            status = "Crítico";
        }

        return status;
    }

    public String gerarRelatorio() {

        String aux = "======== Relatorio Drone Aereo ========\n";
        aux += super.toString();
        aux += "Altitude Maxima: "+altitudeMaxima+"\n";
        aux += "areaMapeada: "+areaMapeada+"\n";
        aux += "autonomiaVoo: "+autonomiaVoo+"\n";
        aux += "autonomiaVoo: "+calcularAutonomiaFinalVoo()+"\n";

        return aux;
    }

}
