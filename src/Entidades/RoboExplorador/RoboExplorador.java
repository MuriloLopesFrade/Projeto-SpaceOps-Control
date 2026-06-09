package Entidades.RoboExplorador;

import Entidades.EntidadeEspacial.EntidadeEspacial;

public abstract class RoboExplorador extends EntidadeEspacial {

    protected double nivelBateria;
    protected double velocidade;

    public RoboExplorador(int id, String nome, double nivelBateria, double velocidade) {
        super(id, nome);
        this.nivelBateria = nivelBateria;
        this.velocidade = velocidade;
    }

    public double getNivelBateria() {
        return nivelBateria;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setNivelBateria(double nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public abstract double calcularAutonomia();

    public abstract void atualizarBateria();

    public abstract double calcularDesempenho();

    public abstract String gerarRelatorio();

    public abstract String obterStatus();

}
