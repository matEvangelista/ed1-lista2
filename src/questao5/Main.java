package questao5;

/*
* Como vai funcionar?
* Fila de filas
* Fila de idosos na frente e fila de adultos atrás
* Criei uma classe para isso: FilaLoja*/

public class Main {

    public static void main(String[] args) {

        FilaLoja filaLoja = new FilaLoja(10); // máximo de 20 pessoas, 10 idosos e 10 adultos
        // será usado para encher a fila. true para idoso, false para adulto
        boolean[] pessoas = {true, false, false, false, false, true, false, true, true, false};
        for (boolean idoso : pessoas)
            filaLoja.inserePessoa(new Cliente(idoso));
        System.out.println(filaLoja);

        // agora, removendo um cliente por vez
        while (!filaLoja.estaVazia()) {
            filaLoja.atendeCliente();
            System.out.println(filaLoja);
        }

    }



}
