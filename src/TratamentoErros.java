import java.util.InputMismatchException;

public class TratamentoErros {
    public static void main(String[] args) {

        try {
            System.out.println(dividir(10, 0));
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    public static double dividir(int a, int b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException("Divisão por zero não e possivel");
        }
        return (double) a /b;
    }
}

