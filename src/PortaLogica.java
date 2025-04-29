public class PortaLogica extends Porta {
    // Subclasse que representa apenas portas de rede lógica 
    private String tipoCabo;  // Tipo do cabo de rede (Cat5e, Cat6, Cat6a)
    private String uso;       // Finalidade da porta (ex: Pc, Impressora)

    public PortaLogica(String codigo, String localizacao, boolean ocupada, String usuarioFinal, String observacao, String tipoCabo, String uso) {
        super(codigo, localizacao, ocupada, usuarioFinal, observacao);
        this.tipoCabo = tipoCabo;
        this.uso = uso;
    }

    @Override
    public String getTipo() {
        return "Lógica";
    }

    // Retorna uma string com todas as informações detalhadas da porta lógica
    @Override
    public String getDetalhes() {
        return String.format("[Lógica] Código: %s | Localização: %s | Tipo Cabo: %s | Uso: %s | Ocupada: %s | Usuário: %s | Obs: %s",
                codigo, localizacao, tipoCabo, uso, ocupada ? "Sim" : "Não", usuarioFinal, observacao);
    }
}