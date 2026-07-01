import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class LacoForEeach{
    public static void main(String[] args) {
//        String[] nomes = {"fabio", "natacha", "miumiu", "churumejo", "filhotao"};
//
////        for (String nome : nomes ){
////            System.out.println(nome);
////        }
//
//        List<String> nomesWithList = List.of(nomes);
//        nomesWithList.forEach(nome ->  {
//            String nomeUpperCase = nome.toUpperCase();
//            System.out.println("nome: " + nomeUpperCase);
//        });
//
//        List<Integer> numbesWithIntList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        numbesWithIntList.forEach(numbes -> {
//            System.out.println(numbes * numbes);
//        });

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua frase: ");

        String frase = sc.nextLine();


        char[] todasLetras = frase.replace(" ", "").toCharArray();


        List<String> listLetras = List.of(frase.replace(" ", "").split(""));

        listLetras.forEach(letraAtual -> {
            char letra = letraAtual.charAt(0);
            int contadorGeral = 0;

            for (int i = 0; i < todasLetras.length; i++) {
                if (letra == todasLetras[i]) {
                    contadorGeral++;
                }

            }
            System.out.println(letra + " tem " + contadorGeral + " caracteres ");
        });
    }
}