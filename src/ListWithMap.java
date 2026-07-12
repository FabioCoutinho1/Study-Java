import java.util.*;

public class ListWithMap{
    public static void main(String[] args) {
        List<User> lista = new ArrayList<>();

//        lista.add(new User("Fabio", true, 23));
//        lista.add(new User("Pedro", true, 26));
//        lista.add(new User("Michelle", true, 27));
//        lista.add(new User("Davi", true, 12));
//        lista.add(new User("Arthur", true, 1));
//        lista.add(new User("Natacha", false, 22));

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("nome: ");
            if (!sc.hasNext()) {
                throw new InputMismatchException("Digite um nome valido");
            }
            String nome = sc.next();
            System.out.print("idade: ");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Digite um idade valido");
            }
            int idade = sc.nextInt();
            System.out.print("e meu irmão? : ");
            if (!sc.hasNextBoolean()) {
                throw new InputMismatchException("Apenas true ou false");
            }
            boolean eIrmao = sc.nextBoolean();

            lista.add(new User(nome, eIrmao, idade));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        lista.forEach(System.out::print);

    }
}

record User(
        String nome,
        boolean irmao,
        int idade
){

}
