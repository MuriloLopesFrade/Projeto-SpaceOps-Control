package Entidades.EstacaoEnergia;

import Entidades.EntidadeEspacial.EntidadeEspacial;
import Interface.CalculavelIPO;

public class EstacaoEnergia extends EntidadeEspacial implements CalculavelIPO {

    /*
        Representa estações responsáveis pelo fornecimento energético da missão.
     */

    private double energiaGerada;
    private double eficiencia;
    private double consumoAtual;

    public EstacaoEnergia(int id, String nome, String status, double energiaGerada, double eficiencia, double consumoAtual) {
        super(id, nome, status);
        this.energiaGerada = energiaGerada;
        this.eficiencia = eficiencia;
        this.consumoAtual = consumoAtual;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public double calcularEficiênciaEnergetica(){
        /*
            Calcula o desempenho energético da estação.
         */
        return 0;
    }

    // Métodos erdados da SuperClasse

    public double calcularDesempenho() {return 0;}
    public String gerarRelatorio() {return null;}

    // Métodos erdados da Interface
    public double fornecerIndice(){return 0;}
}
