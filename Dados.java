import java.util.Arrays;
import java.lang.*;

class Dados {

    BinaryConvert binaryConvert = new BinaryConvert();

    private static int a, b;
    private static int[] aBinary = new int[BinaryConvert.getNumBits()];
    private static int[] bBinary = new int[BinaryConvert.getNumBits()];
    private static int intA, intB;
    private static boolean aC = false, bC = false;

    // 0 == soma; 1 == subtracao; 2 == multiplicacao; 3 == divisao
    private static int operacao;

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

        if(checkBinary(Dados.aBinary)){
            System.out.println("ERRO NUMERO NAO BINARIO");
        }

        String s = Arrays.toString(Dados.aBinary);

        s = s.replaceAll(", ", "");
        s = s.replace("[", "");
        s = s.replace("]", "");

        Dados.intA = Integer.parseInt(s);

        System.out.println(s);
    }

    public void setB(int b) {
        Dados.b = b;
        Dados.bBinary = binaryConvert.convert(b);

        if(checkBinary(Dados.aBinary)){
            System.out.println("ERRO NUMERO NAO BINARIO");
        }

        String s = Arrays.toString(Dados.bBinary);

        s = s.replaceAll(", ", "");
        s = s.replace("[", "");
        s = s.replace("]", "");

        Dados.intB = Integer.parseInt(s);

        System.out.println(s);
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

    //testa a entrada para saber se esta é ou nao binaria
    private boolean checkBinary(int[] arr){
        for(int i : arr){
            if(i != 0 || i != 1){
                return true;
            }
        }
        return false;
    }

    private 1complement(){
        
    }

}
