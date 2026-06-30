import java.util.Scanner;

public class LacoDoWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        String senhaCorreta = "fabio123";
//        String senhaDigitada;
//
//        do {
//            System.out.println("Digite sua senha para entra");
//            senhaDigitada = input.nextLine();
//
//            if(!senhaDigitada.equals(senhaCorreta)){
//                System.out.println("Senha incorreta!");
//            }
//        }while (!senhaDigitada.equals(senhaCorreta));
//
//        System.out.println("Entrando...");
//        input.close();

        long saldo = 100;
        long valorSaque;

        do {
            System.out.println("Digite um valor que deseja sacar: ");
            valorSaque = input.nextLong();

            if (valorSaque % 10 != 0 || valorSaque > saldo || valorSaque <= 0) {
                System.out.println("o valor do saque deve ser um múltiplo de 10.");
            }
        }while (valorSaque % 10 != 0 || valorSaque > saldo || valorSaque <= 0);

        saldo -= valorSaque;
        System.out.println("sacando: " + valorSaque);
        System.out.println("sáldo atual: " + saldo);
    }
}
