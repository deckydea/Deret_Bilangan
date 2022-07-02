import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String name;
        String nim;
        int numberSize;


        while (true) {

            System.out.print("Masukan Nama Anda [1...25]               : ");
            name = input.next();

            //Validate the length of a name, must be greater than 1 and less than 25
            if (validateLength(name, 1, 25)) {
                System.out.println("Nama tidak sesuai. Panjang karakter nama minimal 1 dan maksimal 25\n");

                //Confirm if the user want to repeat the input
                if (confirmIsRepeat()) continue;
                else return;
            }

            //Repeat everytime the input error.
            while (true) {
                System.out.print("Masukan NIM Anda [harus 10 karakter]     : ");
                nim = input.next();

                //Validate the length of a nim, must be 10
                if (validateLength(nim, 10, 10)) {
                    System.out.println("NIM tidak sesuai. Panjang karakter NIM minimal 1 dan maksimal 25\n");

                    //Confirm if the user want to repeat the input
                    if (confirmIsRepeat()) continue;
                    else return;
                }
                break;
            }


            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

            System.out.println("Registrasi Sukses..");
            System.out.printf("Selamat datang %s [NIM: %s].. ^^V\n", name, nim);

            System.out.println("Mari belajar macam-macam deret bilangan..");

            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.print("Masukan Sembarangan Angka [5..20] : ");
            numberSize = input.nextInt();
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

            System.out.println("Deret Bilangan");
            System.out.println("################\n");

            //Calculate and print the event number
            populateEvenNumber(numberSize);

            //Calculate and print the odd number
            populateOddNumber(numberSize);

            //Calculate and print the fibonacci number
            populateFibonacci(numberSize);

            //Confirm if the user want to repeat the program
            if (!confirmIsRepeat()) return;
        }
    }

    private static void populateFibonacci(int numberSize){
        System.out.printf("%s Bilangan Fibonacci : \n", numberSize);

        int sumPrintedNumber = 0;

        int a;
        int b = 1;
        int c = 1;
        for(int i = 1; i <= numberSize; i++)
        {
            a = b;
            b = c;
            c = a + b;
            System.out.printf("%s ", a);
            sumPrintedNumber += a;
        }


        System.out.printf("\nHasil penjumlahan: %s \n\n", sumPrintedNumber);
    }

    private static void populateEvenNumber(int numberSize){
        System.out.printf("%s Bilangan Genap: \n", numberSize);

        int printedLength = 0;
        int sumPrintedNumber = 0;
        int i = 1;
        do{
            if (i%2 == 0){
                System.out.printf("%s ", i);
                printedLength++;
                sumPrintedNumber += i;
            }

            i++;
        }while (printedLength < numberSize);


        System.out.printf("\nHasil penjumlahan: %s \n\n", sumPrintedNumber);
    }

    private static void populateOddNumber(int numberSize){
        System.out.printf("%s Bilangan Ganjil: \n", numberSize);

        int printedLength = 0;
        int sumPrintedNumber = 0;
        int i = 1;
        do{
            if (i%2 != 0){
                System.out.printf("%s ", i);
                printedLength++;
                sumPrintedNumber += i;
            }

            i++;
        }while (printedLength < numberSize);

        
        System.out.printf("\nHasil penjumlahan: %s \n\n", sumPrintedNumber);
    }

    private static boolean confirmIsRepeat() {
        boolean isRepeat;

        while (true) {
            System.out.print("Anda ingin mengulang? [y/t] : ");
            String value = input.next();

            if (value.equals("y") || value.equals("Y")) {
                isRepeat = true;

                //More space
                System.out.println();
                break;
            } else if (value.equals("t") || value.equals("T")) {
                isRepeat = false;
                break;
            }else{
                System.out.println("Silahkan ketik 'y' untuk mengulang atau 't' untuk mengakhiri");
            }
        }

        return isRepeat;
    }

    //Validating the length of string
    private static boolean validateLength(String value, int minLength, int maxLength) {
        return value.length() < minLength || value.length() > maxLength;
    }
}
