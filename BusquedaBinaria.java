import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusquedaBinaria {

    public static int busqueda(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid; 
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Files files = new Files();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre del archivo a leer: ");
        String archivo = bufer.readLine();

        int[] data = files.fileToIntArray(archivo);

        if (data != null) {
            System.out.print("Número a buscar: ");
            int numero = Integer.parseInt(bufer.readLine());

            int resultado = busqueda(data, numero);

            int[] salida = {numero, resultado};

            if (resultado != -1)
                System.out.println("Número encontrado en el índice: " + resultado);
            else
                System.out.println("Número no encontrado.");

            System.out.print("Nombre del archivo para guardar el resultado de la búsqueda: ");
            String outputFile = bufer.readLine();
            files.writeIntArrayToFile(outputFile, salida);
        }
    }
}