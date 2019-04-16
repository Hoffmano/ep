//import java.util.Arrays;
//import java.lang.*;

class Dados {

    BinaryConvert binaryConvert = new BinaryConvert();
    // Calculadora calculadora = new Calculadora();

    private static int a, b;
    private static int[] aBinary = new int[BinaryConvert.getNumBits()];
    private static int[] oldA = new int[BinaryConvert.getNumBits()];
    private static int[] bBinary = new int[BinaryConvert.getNumBits()];
    private static int[] oldB = new int[BinaryConvert.getNumBits()];
    private static int intA, intB;
    // private static boolean aC = false, bC = false;

    // 0 == soma; 1 == subtracao; 2 == multiplicacao; 3 == divisao
    private static int operacao;

    /**
     * @return the oldA
     */

    /**
     * @param oldA the oldA to set
     */
    public static void setOldA(int[] oldA) {
        Dados.oldA = oldA;
    }

    /**
     * @param oldB the oldB to set
     */
    public static void setOldB(int[] oldB) {
        Dados.oldB = oldB;
    }

    public static int[] getOldA() {
        return oldA;
    }

    /**
     * @return the oldB
     */
    public static int[] getOldB() {
        return oldB;
    }

    private static char charOperador;

    /**
     * @return the intA
     */
    public static int getIntA() {
        return intA;
    }

    /**
     * @return the intB
     */
    public static int getIntB() {
        return intB;
    }

    /**
     * @return the aBinary
     */
    public static int[] getaBinary() {
        return aBinary;
    }

    /**
     * @return the bBinary
     */
    public static int[] getbBinary() {
        return bBinary;
    }

    public void setA(int a) {
        Dados.a = a;
        Dados.aBinary = binaryConvert.convert(a);

        checkBinary(Dados.aBinary);

        String s = Calculadora.arrayString(Dados.aBinary);

        Dados.intA = Integer.parseInt(s);

        // System.out.println("A BINARIO: " + s);

        if (Dados.aBinary[0] == 1) {
            System.out.println(Calculadora.arrayString(complement(Dados.getaBinary())));
            setOldA(Dados.aBinary);
            Dados.aBinary = complement(Dados.getaBinary());
        }

    }

    public void setB(int b) {
        Dados.b = b;
        Dados.bBinary = binaryConvert.convert(b);

        checkBinary(Dados.bBinary);

        String s = Calculadora.arrayString(Dados.bBinary);

        Dados.intB = Integer.parseInt(s);

        // System.out.println("B BINARIO: " + s);

        if (Dados.bBinary[0] == 1) {
            System.out.println(Calculadora.arrayString(complement(Dados.getbBinary())));
            setOldB(Dados.bBinary);
            Dados.bBinary = complement(Dados.getbBinary());
        }

    }

    public void setOperacao(int operacao) {
        Dados.operacao = operacao;
        switch (operacao) {
        case 0:
            charOperador = '+';
            break;
        case 1:
            charOperador = '-';
            break;
        case 2:
            charOperador = '*';
            break;
        case 3:
            charOperador = '/';
            break;
        }
    }

    public int getOperacao() {
        return operacao;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public char getCharOperador() {
        return charOperador;
    }

    // testa a entrada para saber se esta é ou nao binaria
    private void checkBinary(int[] arr) {
        for (int i = 0; i < BinaryConvert.getNumBits(); i++) {
            if (arr[i] != 0 && arr[i] != 1) {

                System.out.println("ERRO NUMERO NAO BINARIO");
                System.out.println(arr[i]);

                Runtime.getRuntime().exit(1);
            }
        }
    }

    private int[] complement(int[] arr) {

        // String s = Arrays.toString(arr);
        // System.out.println(s);

        int[] comp = new int[BinaryConvert.getNumBits()];

        for (int i = 0; i < BinaryConvert.getNumBits(); i++) {
            if (arr[i] == 0) {
                comp[i] = 1;
            } else
                comp[i] = 0;
        }

        int compI = arrayInt(comp);

        // System.out.println(compI);

        return Calculadora.soma(compI, 1);

        // String s = Calculadora.arrayString(Calculadora.soma(compI, 1));

        // System.out.println("A COMPLEMENTO 2: " + s);
    }

    private int arrayInt(int[] arr) {
        return Integer.parseInt(Calculadora.arrayString(arr));
    }
}