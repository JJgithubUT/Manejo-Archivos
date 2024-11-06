import java.io.File;
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] languages;

        System.out.println("Lectura de archivos de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        //leerArchivo(fileName);

        languages = fileToStringArray(fileName);
        System.out.println("Contenido del arreglo");
        for ( String element : languages ) {
            System.out.println(element);
        }

    }

}