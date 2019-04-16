import java.util.Arrays;

class Calculadora {

    Dados dados = new Dados();
    private int resultado;

    public int resultado() {
        System.out.println("RESULTADO:");

        switch (dados.getOperacao()) {
        case 0:
            System.out.println(arrayString(soma(Dados.getIntA(), Dados.getIntB())));
            
            
        case 1:
            // return (dados.getA() - dados.getB());
        case 2:
            // return (dados.getA() * dados.getB());
        case 3:
            // return (dados.getA() / dados.getB());
        default:
            return 0;
        }
    }

    public static String arrayString(int[] res){
        String s = Arrays.toString(res);

        s = s.replaceAll(", ", "");
        s = s.replace("[", "");
        s = s.replace("]", "");
        
        return s;
    }

    private void setResultado() {
        this.resultado = resultado();
    }

    public void printResultado() {
        setResultado();
        System.out.println(dados.getA() + " " + dados.getCharOperador() + " " + dados.getB() + " = " + resultado);
    }


    //ESPLICA A SOMA COM COMPLEMENTO DE DOIS, OVERFLOW....
    //http://chortle.ccsu.edu/assemblytutorial/Chapter-08/ass08_24.html
    public static int[] soma(int binary1, int binary2) {
        
        // codigo retirado da internet
        // https://www.w3resource.com/java-exercises/basic/java-basic-exercise-17.php

        int[] sum = new int[BinaryConvert.getNumBits()];
        int remainder = 0;
        int i = BinaryConvert.getNumBits() - 1;

        

        while (binary1 != 0 || binary2 != 0) {
            sum[i--] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }

        if (remainder != 0) {
            if (i >= 0) {
                sum[i] = remainder;
            }
            else{
                System.out.println("ERRO: OVERFLOW");
                Runtime.getRuntime().exit(1);
            }
        } 

        
        return sum;

    }
}