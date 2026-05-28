package Interface;

public interface Monitoravel {

    /*
        Responsabilidade:
        -Define que uma entidade pode ser monitorada operacionalmente.

        Justificativa:
        -Nem todas as entidades precisam obrigatoriamente fornecer dados de monitoramento.
        -O uso de interface foi escolhido porque diferentes classes de hierarquias distintas precisam compartilhar o mesmo contrato.
     */

    public String obterStatus();
}
