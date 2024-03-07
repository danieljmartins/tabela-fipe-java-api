package br.com.fipe.app;

import br.com.fipe.services.ConvertDataType;
import br.com.fipe.services.FipeApiConnection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private FipeApiConnection apiConnection = new FipeApiConnection();
    private final String ApiPath = "https://parallelum.com.br/fipe/api/v1";
    private ConvertDataType dataTypeConversor = new ConvertDataType();

    public void mainMenu() {
        int idVehicle = 0;
        String typeVehicle = "";

        System.out.println("\nSelecione o tipo de veículo: ");
        System.out.println("\n1 - Carros" +
                           "\n2 - Motos" +
                           "\n3 - Caminhões/Utilitários");

        try {
            idVehicle = scanner.nextInt();

            switch (idVehicle) {
                case 1:
                    typeVehicle = "carros";
                    break;
                case 2:
                    typeVehicle = "motos";
                    break;
                case 3:
                    typeVehicle = "caminhoes";
                    break;
                default:
                    System.out.println("Tipo inválido!");
                    return;
            }

            System.out.println(apiConnection.getData(ApiPath + "/" + typeVehicle + "/" + "marcas"));


        } catch (InputMismatchException e) {
            System.out.println("Tipo inválido!");
        }
    }
}
