import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RegisterOfOfficial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListOfOfficials l = new ListOfOfficials();

        System.out.println("===Registro de Funcionários===");
        registerOfOfficials:
        while (true) {
            System.out.println("""
                    1 - Registrar novo funcionário
                    2 - Apagar funcionário
                    3 - Editar funcionário
                    4 - Excluir funcionário
                    5 - Ver funcionário
                    6 - Ver todos funcionários
                    7 - Encerrar program
                    """);
            try {
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> {
                        try {
                            Officials officials = registerOfOfficials(sc);
                            l.addOfficial(officials);
                        }catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                    }
                    case 6 -> {
                        AtomicInteger count = new AtomicInteger();
                        l.getListOfOfficials().forEach(e -> {
                            System.out.printf("""
                                (%s)-|___________
                                    | nome: %s
                                    | idade: %d
                                    | salario: %f
                                    | cargo: %s
                                    |____________
                                """, count, e.name(), e.age(), e.salary(), e.position()
                            );
                            count.getAndIncrement();
                        });
                    }
                    case 7 -> {
                        break registerOfOfficials;
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Opção invalida");
                sc.nextLine();
            }



        }


    }
    private static Officials registerOfOfficials(Scanner scRegister) throws InputMismatchException {

            System.out.print("Nome: ");

            String nome = scRegister.next();

            System.out.print("Idade: ");

            int idade = scRegister.nextInt();

            System.out.print("Salário: ");

            float salario = scRegister.nextFloat();

            System.out.print("Cargo: ");

            String cargo = scRegister.next();

       return new Officials(nome, idade, salario, cargo);
    }
}
record Officials (
        String name,
        int age,
        float salary,
        String position
){

}

class ListOfOfficials{
    public List<Officials> listOfOfficials = new ArrayList<Officials>();

    public void addOfficial(Officials o){
        listOfOfficials.add(o);
    }

    public void removeOfficial(Officials o){
        listOfOfficials.remove(o);
    }

    public void editOfficial(Officials o){
        listOfOfficials.set(listOfOfficials.indexOf(o), o);
    }

    public Officials getOfficial(int i){
        return listOfOfficials.get(i);
    }

    public List<Officials> getListOfOfficials(){
        return listOfOfficials;
    }
}