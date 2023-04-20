package questao4;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(5);
        fila.insere(10);
        fila.insere(4);
        fila.insere(100);
        fila.insere(33);

        FilaDupla filaDupla = Fila.filaCircularParaDupla(fila, 10);
        System.out.println("Os elementos da fila circular são:");
        while (!fila.vazia())
            System.out.println(fila.remove());
        System.out.println("Esses elementos foram colocados em uma fila dupla." +
                "\nTambém adicionaram-se estes elementos: -999 e 1222, no começo e no final da fila, respectivamente");
        filaDupla.insere(1222);
        filaDupla.insereInicio(-999);
        System.out.println("Os elementos da fila dupla são:");
        while (!filaDupla.vazia())
            System.out.println(filaDupla.remove());

    }
}
