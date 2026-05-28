package Interface;

public interface CalculavelIPO {

    /*
        Responsabilidade:
        -Define entidades capazes de contribuir para o cálculo do IPO.

        Justificativa:
        -Permite calcular o IPO polimorficamente sem depender do tipo exato da entidade.
     */
    public double fornecerIndice();
}
