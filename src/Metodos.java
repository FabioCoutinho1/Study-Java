import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 -> Adicionar a lista: \n 2 -> Adicionar a lista mais de um: ");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Nome: ");
            String nome = sc.next();
            addToList(nome);
        } else if (n == 2) {
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Quantidade: ");
            int quantidade = sc.nextInt();
            addToList(nome, quantidade);
        }else {
            System.out.println("Ditige apenas 1 ou 2");
        }

        viwerList();
    }

    public static void addToList (String value){
        list.add(value);
    }

    //sobrecarga de método aqui, recebe um parâmetro a mais
    public static void addToList (String value, int quantidade){
        for(int i = 0; i < quantidade; i++){
            list.add(value);
        }
    }

    public static void viwerList (){
        System.out.println(list);
    }
}
