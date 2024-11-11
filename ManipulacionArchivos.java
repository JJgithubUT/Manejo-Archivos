//import java.io.File;
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.io.FileWriter;

import files.Files;



public class ManipulacionArchivos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName, entrada;
        String[] languages;
        int opcion;
        Files files = new Files();

        // Menú de opciones
        do {
            System.out.println("1 - Leer archivo y mostrar en pantalla");
            System.out.println("2 - Llamar arreglo con contenido de un archivo");
            System.out.println("3 - Crear archivo desde teclado");
            System.out.println("4 - Numeros a Archivo");
            System.out.println("5 - Salir");
            entrada = bufer.readLine();
            opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    files.ReadFileInScreen(fileName);
                }
                break;
                case 2: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    languages = files.fileToStringArray(fileName);
                    files.printStringArray(languages);
                }
                break;
                case 3: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    files.writeKeyboardToFile(fileName);
                }
                break;
                case 4: {
                    int[] numeros = {10,0,9,15,32,67,8,95,69,34,1945};
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    files.writeIntArrayToFile(fileName, numeros);
                }
                break;
                case 5: {
                    System.out.println("Saliendo del sistema");
                    System.exit(0);
                }
                break;
                default:
                    break;
            }
        } while (opcion != 5);

    }

}