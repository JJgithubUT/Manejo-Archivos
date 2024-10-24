import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManipulacionArchivos {

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

        System.out.println("Lectura de archivos de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        leerArchivo(fileName);
    }

}