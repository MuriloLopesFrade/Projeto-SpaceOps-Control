package Entidades.SensorEspacial;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.CalculavelIPO;
import Interface.Monitoravel;

public class SensorEspacial extends EntidadeEspacial implements Monitoravel, CalculavelIPO {

    /*
        Representa sensores utilizados para monitoramento ambiental.
     */

    private double temperatura;
    private double radiacao;
    private double pressaoAtmosferica;

    public SensorEspacial(int id, String nome, String status, double pressaoAtmosferica, double radiacao, double temperatura) {
        super(id, nome, status);
        this.pressaoAtmosferica = pressaoAtmosferica;
        this.radiacao = radiacao;
        this.temperatura = temperatura;
    }

    public double getPressaoAtmosferica() {
        return pressaoAtmosferica;
    }

    public double getRadiacao() {
        return radiacao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setPressaoAtmosferica(double pressaoAtmosferica) {
        this.pressaoAtmosferica = pressaoAtmosferica;
    }

    public void setRadiacao(double radiacao) {
        this.radiacao = radiacao;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double calcularRiscoAmbiental(){
        /*
            Calcula o risco ambiental da região monitorada.
         */
        return 0;
    }

    public double calcularDesempenho() {return 0;}
    public String gerarRelatorio() {return null;}

    public double fornecerIndice(){return 0;}
    public String obterStatus(){return null;}
}
