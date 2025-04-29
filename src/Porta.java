public abstract class Porta {
    // Classe abstrata base que representa uma porta genérica de patch panel
    protected String codigo; // Identificador do patch panel
    protected String localizacao; // Posição da porta
    protected boolean ocupada; // Indica se a porta está em uso
    protected String usuarioFinal; // Usuário destinado a utilizar a porta
    protected String observacao; // Observações adicionais (ex: cor do cabo)

    // Construtor para inicialização dos atributos comuns
    public Porta(String codigo, String localizacao, boolean ocupada, String usuarioFinal, String observacao) {
        this.codigo = codigo;
        this.localizacao = localizacao;
        this.ocupada = ocupada;
        this.usuarioFinal = usuarioFinal;
        this.observacao = observacao;
    }

    // Métodos de acesso (getters e setters)
    public String getCodigo() {
        return codigo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getUsuarioFinal() {
        return usuarioFinal;
    }

    // Métodos abstratos que serão implementados pelas subclasses de portas
    public abstract String getTipo();

    public abstract String getDetalhes();
}