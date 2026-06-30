import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocoWhile {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> numList = new ArrayList<>();

        while (true) {
            System.out.println(
                    """
                    1 - Adicionar número \n
                    2 - Listar números \n
                    3 - Apagar número \n
                    4 - Editar número \n
                    5 - Sáir \s
                   \s"""
            );
            int num = scan.nextInt();

            if (num == 5) {
                System.out.println("Saindo...");
                break;
            }

            if(num < 1 || num > 5){
                System.out.println("Valor invaido");
                continue;
            }

            switch (num) {
                case 1 -> {
                    loopPrincipal:
                    while (true) {
                        System.out.println("Digíte o número: ");
                        String numStr = scan.next();
                        numList.add(numStr);

                        while (true) {
                            System.out.println("0 - voltar \n1 - Adicionar outro");
                            int num1 = scan.nextInt();
                            if (num1 == 0) {
                                System.out.println("Saindo...");
                                break  loopPrincipal;
                            } else if (num1 == 1) {
                                break;
                            }else{
                                System.out.println("opção invalido ");
                            }
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < numList.size(); i++) {
                        System.out.println(i + " - " + numList.get(i));
                    }
                }

                case 3 -> {
                    for (int i = 0; i < numList.size(); i++) {
                        System.out.println(i + " - " + numList.get(i));
                    }
                    System.out.println( "Index do número que quer deletar: ");
                    int index = scan.nextInt();
                    numList.remove(index);
                }
                case 4 -> {
                    for (int i = 0; i < numList.size(); i++) {
                        System.out.println(i + " - " + numList.get(i));
                    }

                    System.out.println("Index do número que deseja editar: ");
                    int index = scan.nextInt();
                    String oldValue = numList.get(index);
                    System.out.println("Editando: " + oldValue);
                    String newValue = scan.next();
                    numList.set(index, newValue);
                }
            }

        }


//        int i = 0;
//        while (i < 5){
//            System.out.println(i);
//            i++;
//            if (i == 3){
//                break;
//            }
//
//            continue;
//        }
    }
}
