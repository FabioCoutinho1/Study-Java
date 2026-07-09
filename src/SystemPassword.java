import javax.crypto.spec.PSource;
import java.util.*;

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
                    3 - Chamar atendimento atual
                    4 - Ver atendimento atual
                    5 - Ver fila completa
                    6 - Sair
                    """);

            try {
                int opcao = sc.nextInt();
                switch (opcao){
                    case 1 -> {
                        String senha = makePassword();
                        addPassword(senha);
                        System.out.println("Senha gerada com sucesso: " + senha);
                    }
                    case 2 -> {
                        if (checkQueueIsEmpty()){
                            break ;
                        }
                        System.out.println("Finalizando o atendimento: ");
                        printPasswords();
                        finishPassword();

                    }
                    case 3 -> {
                        if (checkQueueIsEmpty()){
                            break ;
                        }
                        System.out.println("Para chamar o próximo, finalize o atendimento atual Primeiro (Opção 2)!");
                        printPasswords();
                    }
                    case 4 -> {
                        if (checkQueueIsEmpty()){
                            break ;
                        }
                        System.out.println("Atendimento atual:");
                        printPasswords();
                    }
                    case 5 -> {
                        printQueue();
                    }
                    case 6 -> {
                        break atendimentos;
                    }
                    default -> {
                        System.out.println("Opção inválida!");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Opção invalida");
                sc.next();
            }

        }
    }

   public static void addPassword(String password) {
        passwords.add(password);
   }

   public static boolean checkQueueIsEmpty (){
        if (passwords.isEmpty()){
            System.out.println("Nenhuma senha na fila");
            return true;
        }
        return false;
   }

   public static void printPasswords() {

        System.out.println(passwords.peek());
   }

   public static void printQueue (){
        if (checkQueueIsEmpty()){
            return;
        }
        int position = 0;
       for(String password: passwords){
           System.out.println(position + " -- " + password);
           position++;
       }
       System.out.println("====================");
   }

   public static void finishPassword() {
       passwords.poll();
   }

   public static String makePassword() {
        String characterPermitted = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int maxLength = 10;
        return  new Random().ints(maxLength, 0, characterPermitted.length())
               .mapToObj(characterPermitted::charAt)
               .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
               .toString();
   }
}
