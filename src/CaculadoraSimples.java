import java.util.InputMismatchException;
import java.util.Scanner;

public class CaculadoraSimples {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Caculadora Simples");
            System.out.println("operçåo que dejesa fazer: \n+ \n* \n- \n/ \nsair");
            String op = sc.next();
            if (op.equals("sair")){
                System.out.println("Encerrando o programa...");
                break;
            }

            try {
                System.out.println("numero: ");
                double n1 =  sc.nextDouble();
                System.out.println("numero: ");
                double n2 =  sc.nextDouble();


                switch (op){
                    case "+" -> System.out.println(soma(n1,n2));
                    case "-" -> System.out.println(subtracao(n1,n2));
                    case "*" -> System.out.println(multiplicacao(n1,n2));
                    case "/" -> {
                        if (n2 == 0){
                            System.out.println("Imposivel dividir por 0");
                        }else {
                            System.out.println(divisao(n1,n2));
                        }
                    }
                    default -> {
                        System.out.println("Opção invalida");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Você deve digitar apenas números");
                sc.next();
            }



        }
    }
    public  static double soma(double a, double b){
        return a+b;
    }

    public static double subtracao(double a, double b){
        return a-b;
    }

    public static double multiplicacao(double a, double b){
        return a*b;
    }
    public static double divisao(double a, double b){
        return a/b;
    }
}
