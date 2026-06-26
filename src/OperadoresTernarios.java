public class OperadoresTernarios {

    public static void main(String[] args) {
        //Operadores Ternários em Java

        String valor = 1 < 0 ? "Verdadeiro" : "Falso";

        int num1 = 10;
        int num2 = 20;

        Msg msg = new Msg();

        String isTrue = num1 <= num2 ? msg.msg("e verdade e isso: metodo"): msg.msg("E mentira: metodo");
        System.out.println(isTrue);

    }
}

class Msg {
    public String msg(String msg){
        return msg;
    }

    public void msgVoid(String msg){
        System.out.println(msg); // metodos como sem retorno não podem ser chamados pelo ternario
    }
}
