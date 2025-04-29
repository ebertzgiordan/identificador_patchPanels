import java.util.ArrayList;
import java.util.List;

public class PatchPanel implements Pesquisa {
    // Classe principal que gerencia uma lista de portas em um patch painel
        private List<Porta> portas;

    public PatchPanel() {
        portas = new ArrayList<>();
    }

    public void adicionarPorta(Porta porta) {
        // Verifica se já existe uma porta com o mesmo código
        for (Porta p : portas) {
            if (p.getCodigo().equalsIgnoreCase(porta.getCodigo())) {
                System.out.println("Erro: Já existe uma porta cadastrada com o código " + porta.getCodigo() + ".");
                return; // Não adiciona duplicado
            }
        }
        portas.add(porta);
    }    

    public void removerPorta(String codigo) throws PortaNaoEncontradaException {  // Remove uma porta com base no código informado
        Porta p = buscarPorCodigo(codigo);
        portas.remove(p);
    }

    @Override
    public Porta buscarPorCodigo(String codigo) throws PortaNaoEncontradaException {  // Busca uma porta pelo código (lança exceção se não encontrar)
        for (Porta p : portas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        throw new PortaNaoEncontradaException("Porta com código " + codigo + " não encontrada.");
    }

    @Override
    public List<Porta> buscarPorUsuario(String nome) {  // Retorna uma lista de portas associadas ao nome do usuário
        List<Porta> resultado = new ArrayList<>();
        for (Porta p : portas) {
            if (p.getUsuarioFinal().equalsIgnoreCase(nome)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    @Override
    public List<Porta> listarPortasLivres() {  // Lista todas as portas que estão livres (não ocupadas)
        List<Porta> livres = new ArrayList<>();
        for (Porta p : portas) {
            if (!p.isOcupada()) {
                livres.add(p);
            }
        }
        return livres;
    }
    public List<Porta> listarPortasOcupadas() { // Lista todas as portas que estão ocupadas
        List<Porta> ocupadas = new ArrayList<>();
        for (Porta p : portas) {
            if (p.isOcupada()) {
                ocupadas.add(p);    
            }
        }
        return ocupadas;
    }
    

    public void listarTodas() {  // Exibe todas as portas cadastradas no painel
        for (Porta p : portas) {
            System.out.println(p.getDetalhes());
            System.out.println();
        }
    }
}