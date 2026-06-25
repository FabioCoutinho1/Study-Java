package casting;

import java.awt.font.NumericShaper;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CastingInJava {
    public static void main(String[] args) {
//        Scanner leitor = new Scanner(System.in);
//
//        System.out.println("De uma nota de 1 a 5 ao produto");
//        String notaQualidade = leitor.nextLine();
//
//        System.out.println("De uma nota de 1 a 5 a entrega");
//        String notaQualidadeEtrega = leitor.nextLine();
//
//        int notaQualidaeInInt = Integer.parseInt(notaQualidade);
//        int notaQualidadeEtregaInt = Integer.parseInt(notaQualidadeEtrega);
//
//        double mediaNotas = (double) ( notaQualidaeInInt + notaQualidadeEtregaInt)/2;
//
//        System.out.println("A media das notas e: " + mediaNotas);
        int meuInt = 9;
        double meuDouble = meuInt;

        System.out.println(meuDouble);

        double meuFloat = 9.86;
        int meuIntForFloat = (int) meuInt;

        System.out.println(meuIntForFloat);
    }
}
