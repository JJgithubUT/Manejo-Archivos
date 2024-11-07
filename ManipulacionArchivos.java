import java.io.File;
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class ManipulacionArchivos {

    public static int countLines(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line; // Linea recuperada del archivo de texto
        int numLines = 0;

        try {
            // crear un apuntador al archivo físico
            System.out.println("Filename: " + fileName);
            file = new File("C:\\archivos\\" + fileName + ".txt");
            // abrir el archivo para lectura
            reader = new FileReader(file);
            // configurar el buffer para leer los datos del archivo
            br = new BufferedReader(reader);
            while ( (line = br.readLine()) != null) {
                numLines++;
            }
            reader.close();
        } catch ( Exception e ) {
            System.out.println( "Error al leer el archivo" + e.toString() );
        }

        System.out.println("Countlines: " + numLines);

        return numLines;
    }

    public static String[] fileToStringArray(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line; // Linea recuperada del archivo de texto
        String[] array = null;
        int t; // Tamaño del archivo en lineas de texto
        int i = 0; // Indice del arreglo
        
        try {
            // Obtener el tamaño el archivo en líneas
            t = countLines(fileName);
            System.out.println( "ttttttttttttttt(fileToStringArray): " + t);
            array = new String[t];
            file = new File("C:\\archivos\\" + fileName + ".txt");
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while ( ( line = br.readLine() ) != null ) {
                array[i] = line;
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + fileName);
        }
        
        return array;
    }

    public static void leerArchivo(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line;

        try {
            // crear un apuntador al archivo físico
            System.out.println("Filename: " + fileName);
            file = new File("C:\\archivos\\" + fileName + ".txt");
            // abrir el archivo para lectura
            reader = new FileReader(file);
            // configurar el buffer para leer los datos del archivo
            br = new BufferedReader(reader);
            while ( (line = br.readLine()) != null) {
                System.out.println("línea leída: " + line);
            }
            reader.close();
        } catch ( Exception e ) {
            System.out.println( "Error al leer el archivo" + e.toString() );
        }
    }

    public static void printStringArray(String[] array){
        System.out.println("Contenido del arreglo");
        for ( String element : array ) {
            System.out.println(element);
        }
    }

    public static void writeFile(String fileName) {
        // Un apuntador a un espacio físico en el disco duro
        FileWriter file;
        // Llave de acceso para el archivo
        PrintWriter writer;
        // Configurar buffer p leer del teclado
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try {
            // Apuntando a un espacio físico del disco duro
            file = new FileWriter("c:\\archivos\\" + fileName + ".txt");
            // Crear y abrir archivo en modo escritura
            writer = new PrintWriter(file);
            do {
                System.out.println("Escribe datos para guardar al archivo: ");
                entrada = bufer.readLine();
                // Guardar la entrada del archivo
                writer.println(entrada);
                System.out.println("Escriba x para salir, este campo no puede estar vacio");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } while ( respuesta != 'x' );
            file.close();
        } catch (Exception e) {
            System.out.println("################ Error al escribir el archivo ################");
            System.out.println("################ Error:                       ################");
            System.out.println(e.toString());
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName, entrada;
        String[] languages;
        int opcion;

        // Menú de opciones
        do {
            System.out.println("1 - Leer archivo y mostrar en pantalla");
            System.out.println("2 - Llamar arreglo con contenido de un archivo");
            System.out.println("3 - Crear archivo desde teclado");
            System.out.println("4 - Nada");
            System.out.println("5 - Salir");
            entrada = bufer.readLine();
            opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    leerArchivo(fileName);
                }
                break;
                case 2: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    languages = fileToStringArray(fileName);
                    printStringArray(languages);
                }
                break;
                case 3: {
                    System.out.println("Escribe el nombre del archivo: ");
                    fileName = bufer.readLine();
                    writeFile(fileName);
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