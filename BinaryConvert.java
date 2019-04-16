
class BinaryConvert {
    // numero de bits com o bit de sinal
    private static int numBits;

    public void setNumBits(int numBits) {
        BinaryConvert.numBits = numBits;
    }

    public static int getNumBits() {
        return numBits;
    }

    public int[] convert(int x) {

        String string = Integer.toString(x);

        //ERRO: ESTOUROU NUMERO DE BITS DETERMINADO
        if (string.length() > getNumBits()) {
            System.out.println("ERRO: ESTOUROU NUMERO DE BITS DETERMINADO");
            Runtime.getRuntime().exit(1);
        }

        String[] arr = string.split("");

        int[] intArr = new int[BinaryConvert.numBits];

        int zeros = BinaryConvert.numBits - arr.length - 1;

        int counter = 0;
        for (int i = 0; i < BinaryConvert.numBits; i++) {
            if (i <= zeros) {
                intArr[i] = 0;
                continue;
            }
            if (i > zeros) {
                intArr[i] = Integer.parseInt(arr[counter]);
                if (counter != arr.length - 1) {
                    counter++;
                }

            }
        }
        return intArr;
    }
}