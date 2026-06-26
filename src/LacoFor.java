import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LacoFor{
    public static void main(String[] args) {

//        String[] arrayList = {"Fabio", "Pedro", "Julio", "Arthur"};
//
//        for(int i = 0; i <= 10; i ++){
//            System.out.println("o I esta em: " + i + "\n");
//        }
//
//        for(int i  = 0; i < arrayList.length; i ++){
//            System.out.println("Nome: " + arrayList[i] + "\n");
//        }
//
//        for(String nome : arrayList ){
//            System.out.println(nome);
//        }
//
//
//        String frase = "Olá meu nome e Fabio Farias Coutinho";
//
//        for(char letra : frase.toCharArray()){
//            System.out.println();
//        }
//
//        List<String> nomes = List.of("Fabio", "Pedro", "Julio", "Arthur", "Gabriel");
//
//        nomes.forEach(nome ->  System.out.println("Nome que vem da lsit: " + nome));

        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos nomes você quer salvar ?");

        int numNames = scan.nextInt();

        List<String> namesForFor = new ArrayList<>();

        for(int i = 0; i < numNames; i ++){
            System.out.println("Digite um nome: ");
            String nome = scan.next();
            namesForFor.add(nome);
            System.out.println("List: \n" + namesForFor);
        }

        for( String name : namesForFor){
            System.out.println("-" + name);
        }

        for (int i = 0 ; i < namesForFor.size(); i ++){
            System.out.println(i + " - " + namesForFor.get(i));
        }
     }
}
