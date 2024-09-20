import java.util.Scanner;

public class Menu {


    void run() {


        try {
            while (true) {

                System.out.println("Sea bienvenido/a al Conversor de Monedas");
                System.out.println();
                System.out.println("1) Dólar =>> Peso Argentino");
                System.out.println("2) Peso Argentino =>> Dólar");
                System.out.println("3) Dólar =>> Peso Real brasileño");
                System.out.println("4) Real brasileño =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Dólar =>> Peso chileno");
                System.out.println("8) Peso chileno =>> Dólar");
                System.out.println("9) Dólar =>> Peso chileno");
                System.out.println("10) Peso chileno =>> Dólar");
                System.out.println("11) Salir");

                System.out.println("Elija una opcion válida:");

                Scanner scaner = new Scanner(System.in);

                int option = scaner.nextInt();

                if (option == 11) {
                    break;
                }

                System.out.println("Digita el valor:");
                double value = scaner.nextDouble();
                GetInformation getInformation = new GetInformation();


                switch (option) {
                    case 1:


                        getInformation.getValue("USD", "ARS", value);


                        break;
                    case 2:
                        getInformation.getValue("ARS", "USD", value);
                        break;
                    case 3:
                        getInformation.getValue("USD", "BRL", value);
                        break;
                    case 4:

                        getInformation.getValue("BRL", "USD", value);
                        break;
                    case 5:
                        getInformation.getValue("USD", "COP", value);
                        break;
                    case 6:
                        getInformation.getValue("COP", "USD", value);
                        break;
                    case 7:
                        getInformation.getValue("USD", "CLP", value);
                        break;
                    case 8:
                        getInformation.getValue("CLP", "USD", value);
                        break;
                    case 9:
                        getInformation.getValue("USD", "BOB", value);
                        break;
                    case 10:
                        getInformation.getValue("BOB", "USD", value);
                        break;


                }

            }


        }catch (Exception e){

            System.out.println("ocurrio un error en el programa");
        }
    }
}
