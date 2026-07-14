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

                switchOfficials:
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
                    case 2 ->{
                        if(l.listOfficialsIsEmpty()){
                            System.out.println("Nenhum funcionário registrado");
                            break;
                        }
                        System.out.println("Escolha um da lista para apagar:");
                        l.printListOfOfficials(l);
                        int index = sc.nextInt();
                        try{
                        l.removeOfficial(l.getOfficial(index));
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Funcionário não encontrado!");
                            sc.nextLine();
                        }
                    }
                    case 3 -> {
                        if(l.listOfficialsIsEmpty()){
                            System.out.println("Nenhum funcionário registrado");
                            break;
                        }
                        System.out.println("Escolha um da lista para editar:");
                        l.printListOfOfficials(l);
                        int index = sc.nextInt();
                        sc.nextLine();
                        try{
                            Officials newOfficials = registerOfOfficials(sc);
                            l.editOfficial(l.getOfficial(index), newOfficials);
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Funcionário não encontrado!");
                            sc.nextLine();
                            break switchOfficials;
                        }
                    }
                    case 4 -> {
                        if(l.listOfficialsIsEmpty()){
                            System.out.println("Nenhum funcionário registrado");
                            break;
                        }
                        System.out.println("Escolha um da lista para apagar:");
                        l.printListOfOfficials(l);
                        int index = sc.nextInt();
                        try{
                            if (l.getOfficial(index) == null) {
                                break switchOfficials;
                            }
                            System.out.println("Deseja apagar esse funcionário?");
                            l.printFormatOfficials(l.getOfficial(index));
                            System.out.println("[y/n] - y para sim, n para não");
                            String confirm = sc.next();
                            if (confirm.equalsIgnoreCase("y")) {
                                System.out.println("Funcionário");
                                l.printFormatOfficials(l.getOfficial(index));
                                System.out.println(" removido com sucesso!");
                                l.removeOfficial(l.getOfficial(index));

                            } else if (confirm.equalsIgnoreCase("n")) {
                                System.out.println("cancelando...");
                                break switchOfficials;
                            }else {
                                System.out.println("Opção invalida!");
                                sc.nextLine();
                            }
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Funcionário não encontrado!");
                            sc.nextLine();
                        }
                    }
                    case 6 -> {
                        l.printListOfOfficials(l);
                    }
                    case 7 -> {
                        System.out.println("Saindo...");
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

    public boolean listOfficialsIsEmpty(){
        return listOfOfficials.isEmpty();
    }

    public void removeOfficial(Officials o){
        listOfOfficials.remove(o);
    }

    public void editOfficial(Officials o, Officials newOfficial){
        listOfOfficials.set(listOfOfficials.indexOf(o), newOfficial);
    }

    public Officials getOfficial(int i){
        return listOfOfficials.get(i);
    }

    public List<Officials> getListOfOfficials(){
        if(listOfficialsIsEmpty()){
            System.out.println("Lista vazia!");
        }
        return listOfOfficials;
    }

    public void printFormatOfficials(Officials list){
        System.out.printf("""
                                    |___________
                                    | nome: %s
                                    | idade: %d
                                    | salario: %f
                                    | cargo: %s
                                    |____________
                                """, list.name(), list.age(), list.salary(), list.position()
        );
    }

    public void printListOfOfficials(ListOfOfficials list){
        AtomicInteger count = new AtomicInteger();
        list.getListOfOfficials().forEach(e -> {
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
}