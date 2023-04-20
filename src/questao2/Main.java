package questao2;

public class Main {
    public static void main(String[] args) {
        // Apenas um exemplo. Deixei um espaço a menos em fila para exemplificar o que a questão pedia
        Fila fila = new Fila(7);
        Fila fila1 = new Fila(3);
        Fila fila2 = new Fila(5);
        // ints para fila1
        fila1.insere(4);
        fila1.insere(10);
        fila1.insere(30);

        // ints para fila2
        fila2.insere(-10);
        fila2.insere(-90);
        fila2.insere(-120);
        fila2.insere(-200);
        fila2.insere(-10000); // não será exibido

        fila.combinaFilas(fila1, fila2);

        System.out.println("Estes são os elementos da fila:");
        while (!fila.vazia()) System.out.println(fila.remove());
        // note que -10000 não foi impresso porque não cabia no objeto fila apesar de caber em fila2

    }
}
