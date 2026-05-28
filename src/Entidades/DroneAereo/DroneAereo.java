package Entidades.DroneAereo;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.Monitoravel;

public class DroneAereo extends EntidadeEspacial implements Monitoravel {

    /*
        Representa drones utilizados para reconhecimento aéreo.
     */

    private double altitudeMaxima;
    private double areaMapeada;
    private double autonomiaVoo;

    public DroneAereo(int id, String nome, String status, double altitudeMaxima, double areaMapeada, double autonomiaVoo) {
        super(id, nome, status);
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
    public double calcularCoberturaAerea(){return 0;}

    // Métodos erdados da SuperClasse
    public double calcularDesempenho() {return 0;}

    public String gerarRelatorio() {return null;}

    // Métodos erdados da Interface
    public double Monitoravel() {return 0;}

}
