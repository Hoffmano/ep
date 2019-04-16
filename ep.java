import java.util.Scanner;

class ep {
    public static void main(String[] args) {

        Dados dados = new Dados();
        BinaryConvert binaryConvert = new BinaryConvert();
        Calculadora calculadora = new Calculadora();

        // receber numero 1 e numero 2

        Scanner scanner = new Scanner(System.in);

        System.out.println("NUMERO DE BITS COM BIT DE SINAL?");

        binaryConvert.setNumBits(scanner.nextInt());

        System.out.println("A COM BIT DE SINAL?");
        dados.setA(scanner.nextInt());

        System.out.println("B COM BIT DE SINAL?");
        dados.setB(scanner.nextInt());

        System.out.println("OPERACAO?");
        System.out.println("0 == SOM; 1 == SUB; 2 == MUL; 3 == DIV");
        dados.setOperacao(scanner.nextInt());

        scanner.close();

        System.out.println("hi");

        calculadora.resultado();

    }
}