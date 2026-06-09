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

    public String toString() {
        return super.toString() + "Tipo: Drone Áereo\n";
    }

    public double calcularCoberturaAerea(){

        double cobertura = (areaMapeada / 1000) * 100;

        if (cobertura<0){
            cobertura=0;
        }

        if (cobertura>100){
            cobertura=100;
        }
        return cobertura;
    }

    public double calcularAutonomiaFinalVoo(){

        double consumoAltitude = (altitudeMaxima/2000) * 30;

        double consumoMapeamento =  (calcularCoberturaAerea()/1000) * 20;

        double autonomiaFinal =autonomiaVoo - consumoAltitude - consumoMapeamento;

        if (autonomiaFinal<0){
            autonomiaFinal=0;
        }

        if (autonomiaFinal>100){
            autonomiaFinal=100;
        }

        return autonomiaFinal;
    }

    public double calcularRisco(){

        double riscoAutonomia = (100-calcularAutonomiaFinalVoo())*0.4;
        double riscoCoberturaAerea =  (100-calcularCoberturaAerea())*0.3;

        double ristoTotal= riscoAutonomia+riscoCoberturaAerea;

        if (ristoTotal<0){
            ristoTotal=0;
        }

        if (ristoTotal>100){
            ristoTotal=100;
        }

        return ristoTotal;
    }

    public String obterStatus() {

        if (calcularAutonomiaFinalVoo() >= ((altitudeMaxima/2000)*70)){
            return"Verde";
        } else if (calcularAutonomiaFinalVoo() >=((altitudeMaxima/2000)*30)) {
            return"Amarelo";
        }

        return "Vermeho";
    }

    public String gerarRelatorio() {

        String aux = "==> Drone Aereo: "+getNome()+"\n";
        aux += "Identificador:"+getId()+"\n";
        aux += "Altitude máxima: "+altitudeMaxima+"m\n";
        aux += "Área Mapeada: "+areaMapeada+"km\n";
        aux += "Autonomia inicial voo: "+autonomiaVoo+"%\n";
        aux += "Autonomia final voo: "+String.format("%.2f", calcularAutonomiaFinalVoo())+"%\n";
        aux += "Porcentagem de área coberta: "+String.format("%.2f", calcularCoberturaAerea())+"%\n";
        aux += "Status: "+ obterStatus()+"\n";

        return aux;
    }

}
