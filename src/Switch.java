import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

public class Switch {

    public enum StatusPedidos {
        AGUARDANDO_PAGAMENTO,
        ENVIADO,
        CANCELADO,
        ENTREGUE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println(" 1 - Segunda \n 2 - Terça \n 3 - Quarta \n 4 - Quinta \n 5 - Sexta \n 0 - sair");
//        int daysWeek =  sc.nextInt();
//
//        switch (daysWeek){
//            case 1 -> System.out.println("Segunda");
//            case 2 -> System.out.println("Terça");
//            case 3 -> System.out.println("Quarta");
//            case 4 -> System.out.println("Quinta");
//            case 5 -> System.out.println("Sexta");
//            case 0 -> {}
//            default -> System.out.println("Valor invalido");
//        }

        Map<Integer, StatusPedidos> mapEnum = Map.of(
                1, StatusPedidos.AGUARDANDO_PAGAMENTO,
                2, StatusPedidos.ENTREGUE,
                3, StatusPedidos.ENVIADO,
                4, StatusPedidos.CANCELADO
        );

        mapEnum.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });

        int numPedidos = sc.nextInt();

        StatusPedidos statusPedido = mapEnum.get(numPedidos);

        String msg = switch (statusPedido){
            case AGUARDANDO_PAGAMENTO -> "O pagamento esta sendo processado, aguarde!";
            case ENVIADO -> "O pedido já foi enviado, em breve chegara em seu endereço";
            case ENTREGUE -> "O pedido foi entregue em seu endereço";
            case CANCELADO -> "O pedido foi cancelado";
        };

        System.out.println(msg);
        int flaotVar = 10;
        final int valorCase = 10;
        switch ((int) flaotVar){
            case valorCase :
                System.out.println(flaotVar);
        }
    }
}
