package questao1;

public class Processo {
    int identificador;
    String conteudo;

    public Processo(int identificador, String conteudo) {
        this.identificador = identificador;
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Processo #" + identificador + ". Conteúdo: " + conteudo;
    }
}
