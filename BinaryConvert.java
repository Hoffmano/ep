
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

        if (string.length() >= getNumBits()) {
            System.out.println("ERRO: ESTOUROU NUMERO DE BITS DETERMINADO");
        }

        String[] arr = string.split("");

        int[] intArr = new int[BinaryConvert.numBits];

        int zeros = BinaryConvert.numBits - arr.length - 1;

        int counter = 0;
        for (int i = 0; i < BinaryConvert.numBits; i++) {
            if (i == 0) {
                if (x < 0) {
                    intArr[0] = 1;

                } else
                    intArr[0] = 0;
                continue;
            }
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

