import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class SystemPassword {
    private static final Queue<String> passwords = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Senha atendimento");
        atendimentos:
        while (true){
            System.out.println("""
                    1 - Gerar senha
                    2 - Finalizar atendimento atual
                    3 - Proximo atendimento
                    4 - Ver atendimento atual
                    5 - Sair
                    """);
            int opcao = sc.nextInt();
            switch (opcao){
                case 1 -> {
                    String senha = gerarSenha();
                    addPassword(senha);
                    System.out.println("Senha gerada com sucesso: " + senha);
                }
                case 2 -> {
                    finalizarSenha();
                }
                case 3 -> {
                    System.out.println("Para chamar o próximo, finalize o atendimento atual Primeiro (Opção 2)!");
                    printPasswords();
                }
                case 4 -> {
                    System.out.println("Atendimento atual:");
                    printPasswords();
                }
                case 5 -> {
                    break atendimentos;
                }
                default -> {
                    System.out.println("Opção inválida!");
                }
            }
        }
    }

   public static void addPassword(String password) {
        passwords.add(password);
   }

   public static void printPasswords() {
       System.out.println(passwords.peek());
   }

   public static void finalizarSenha() {
        passwords.poll();
   }

   public static String gerarSenha() {
        String characterPermitted = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int maxLength = 10;
        return  new Random().ints(maxLength, 0, characterPermitted.length())
               .mapToObj(characterPermitted::charAt)
               //mesmo que indice -> characterPermitted.charAt(indice)
               .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
               .toString();
   }
}
