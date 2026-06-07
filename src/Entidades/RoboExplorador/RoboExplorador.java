package Entidades.RoboExplorador;

import Entidades.EntidadeEspacial.EntidadeEspacial;

public abstract class RoboExplorador extends EntidadeEspacial {

    /*
        Está classe foi criada para representar características e comportamentos comuns
        entre diferentes tipos de robôs utilizados na exploração espacial. Tanto os robôs terrestres
        quanto os robôs espaciais compartilham propriedades essenciais, como identificação, nível de bateria,
        velocidade operacional, status e capacidade de gerar relatórios de desempenho.

        Também como neste projeto não faz sentido termo um robô genérico fizemos essa classe ser abstrata,
        pois cada robô obrigatoriamente pertence a um tipo especializado, como RoboTerrestre ou RoboEspacial,
        cada um possuindo regras próprias de funcionamento e cálculos específicos.
     */

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
