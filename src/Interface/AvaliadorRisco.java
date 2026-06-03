package Interface;

public interface AvaliadorRisco {

    /*
        Interface criada com a intenção de complementar o CalcularIPO, aqui a ideia é calcular qual seria a chance
        de algo dar errado em missões que utilizariam entidades como DroneAereo, RoboTerrestre e RoboEspacial.
        Sendo uma variavel que varia de 0-100 e calculada com base nos atributos de cada classe.

        A interface AvaliadorRisco foi criada para representar entidades capazes de calcular seu nível
        de risco operacional. Embora robôs, drones e estações possuam características diferentes, todos podem
        estimar a probabilidade de falhas utilizando critérios específicos de sua operação. O uso da interface permitiu
        aplicar polimorfismo, possibilitando que o sistema avalie riscos sem depender do tipo concreto da entidade.
     */

    public double calcularRisco();
}
