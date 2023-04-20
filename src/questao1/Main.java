package questao1;

public class Main {
    public static void main(String[] args) {

        // cinco processos para exemplificar
        SistemaOperacional sistemaOperacional = new SistemaOperacional(5);

        sistemaOperacional.inserirProcesso(new Processo(123, "Processo ABC"));
        sistemaOperacional.inserirProcesso(new Processo(189, "Processo BCD"));
        sistemaOperacional.inserirProcesso(new Processo(616, "Processo CDE"));
        sistemaOperacional.inserirProcesso(new Processo(950, "Processo DEF"));
        sistemaOperacional.inserirProcesso(new Processo(1245, "Processo EFG"));

        System.out.println("O sistema operacional tem estes procesos para executar: ");
        System.out.println(sistemaOperacional);
        System.out.println();

        System.out.println("O primeiro processo será executado");
        System.out.println(sistemaOperacional.encerrarProcesso() + " concluído.");
        System.out.println("Portanto, sobraram apenas estes processos: ");
        System.out.println(sistemaOperacional);


    }
}
