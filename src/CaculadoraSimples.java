import java.util.*;

public class CaculadoraSimples {
    private static final Queue<String> history = new LinkedList<>();
    private static final int LIMITE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Caculadora Simples");
            System.out.println("operação que deseja fazer: \n+ \n* \n- \n/ \nS -> sair\nH -> Histórico");
            String op = sc.next();

            if (op.equalsIgnoreCase("S")){
                System.out.println("Encerrando o programa...");
                break;
            }else if (op.equalsIgnoreCase("H")){
                printHistory();
                continue;
            }else if(!validOp(op)){
                System.out.println("Digite apenas as operações acima");
                continue;
            }


            try {
                System.out.println("numero: ");
                double n1 =  sc.nextDouble();
                System.out.println("numero: ");
                double n2 =  sc.nextDouble();

               double resulOfSwitch = switch (op){
                    case "+" -> soma(n1,n2);
                    case "-" -> subtracao(n1,n2);
                    case "*" -> multiplicacao(n1,n2);
                    case "/" -> {
                        if (n2 == 0){
                            System.out.println("Imposivel dividir por 0");
                            yield Double.NaN;
                        }else {
                           yield  divisao(n1,n2);
                        }
                    }
                    default -> Double.NaN;
                };

               if (!Double.isNaN(resulOfSwitch)){
                   String res = result(n1, n2, op, resulOfSwitch);
                   saveHistory(res);
                   printCaunt(res);
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

    public static String result(double n1, double n2, String op, double v){
        return n1 + " " + op + " " +  n2 + " = " + v;
    }

    public static void printCaunt(String c){
        System.out.println(c);
    }

    public static void saveHistory(String s){
        if (history.size() >= LIMITE){
            history.poll();
        }
        history.add(s);
    }

    public static void printHistory(){
        history.forEach(System.out::println);
    }

    public static boolean validOp(String op){
        List<String> ops = List.of("+", "-", "*", "/");
        return ops.contains(op);
    }
}
