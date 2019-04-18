import java.util.Arrays;

class Calculadora {

    private static int carry;
    Dados dados = new Dados();
    private int resultado;

    private static void overflowDetection(int[] a, int[] b, int[] c) {
        if ((a[0] == 0 && b[0] == 0 && c[0] == 1) || (a[0] == 1 && b[0] == 1 && c[0] == 0)) {
            System.out.println("OVERFLOW DETECTED");
            Runtime.getRuntime().exit(1);
        }
        else if(Calculadora.carry == 1){
            System.out.println("OVERFLOW DETECTED");
            Runtime.getRuntime().exit(1);
        }
    }

    public int resultado() {
        System.out.println("RESULTADO:");

        switch (dados.getOperacao()) {
        case 0:
            
            int[] res = soma(Dados.getIntA(), Dados.getIntB());

            if(Dados.getOldA().length == 0){
                Dados.setOldA(Dados.getaBinary());
            }
            if(Dados.getOldB().length == 0){
                Dados.setOldB(Dados.getbBinary());
            }

            Calculadora.overflowDetection(Dados.getOldA(), Dados.getOldB(), res);
            System.out.println(arrayString(res));

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

    public static String arrayString(int[] res) {
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

    // ESPLICA A SOMA COM COMPLEMENTO DE DOIS, OVERFLOW....
    // http://chortle.ccsu.edu/assemblytutorial/Chapter-08/ass08_24.html
    public static int[] soma(int binary1, int binary2) {

        // codigo retirado da internet
        // https://www.w3resource.com/java-exercises/basic/java-basic-exercise-17.php


        //http://teaching.idallen.com/dat2343/10f/notes/040_overflow.txt
   
       
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
                //Calculadora.carry = remainder;
            }
        }         

        return sum;

    }
}