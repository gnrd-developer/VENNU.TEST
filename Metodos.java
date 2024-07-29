import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Metodos {
    public static int max = 5000;

    public static void generarArchivo() {
        Random random = new Random();
        int[] numerosAleatorios = new int[max];
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = random.nextInt(max*2) + 1;
        }
        try (FileWriter fileWriter = new FileWriter("numeros.txt")) {
            for (int j : numerosAleatorios) {
                fileWriter.write(j + "\t");
            }
            System.out.print("------------------------\n"
                    + "CREADO Y LISTO PARA MOSTRAR\n"
                    + "----------------------------------------");
        } catch (Exception e) {
            System.out.print("PROBELMAS AMIGOS" + e.getMessage());
        }
    }
/*............................................................................................................. */
    public static void mostrarArchivo(){
        try (Scanner scanner = new Scanner(new File("numeros.txt"))){
            System.out.print("\n\tMOSTRANDO:");
            while (scanner.hasNextInt()) {
                int numeroLeido = scanner.nextInt();
                System.out.print(numeroLeido + " ");
            }    
        } catch (Exception e) {
            System.out.print("ERROR:" + e.getMessage());
        }
    }

/*............................................................................................................. */


    private static int[] leerNumeros(){
        try (Scanner scanner = new Scanner(new File("numeros.txt"))){
            int[] numeros = new int[max];
            int indice = 0;
            while (scanner.hasNextLine() && indice < numeros.length) {
                numeros[indice++] = scanner.nextInt();
            }
            return numeros;
        } catch (Exception e) {
            System.out.print("ERROR AMIGO:" + e.getMessage());
            return null;
        }
    }

    private static int[] leerNumeros2(){
        try (Scanner scanner = new Scanner(new File("numerosOrdenados.txt"))){
            int[] numeros = new int[max];
            int indice = 0;
            while (scanner.hasNextLine() && indice < numeros.length) {
                numeros[indice++] = scanner.nextInt();
            }
            return numeros;
        } catch (Exception e) {
            System.out.print("ERROR AMIGO:" + e.getMessage());
            return null;
        }
    }
    
    public static void ordenar(){
        int [] numeros = leerNumeros();
        if(numeros == null){
            System.out.print("PROBLEMAS");
            return;
        }

        Arrays.sort(numeros);/* */

        try (FileWriter fileWriter = new FileWriter("numerosOrdenados.txt")){
            for (int numero : numeros) {
                fileWriter.write(numero + " ");
            }            
            System.out.print("------------------------\n"
            + "CREADO Y LISTO PARA MOSTRAR\n"
            + "----------------------------------------");
        } catch (Exception e) {            
            System.out.print("------------------------\n"
            + "ERROR:" + e.getMessage()
            + "\n----------------------------------------");
            
        }
    }

/*............................................................................................................. */

    public static void mostrarNumerosOrdenados(){
        
        try (Scanner scanner = new Scanner(new File("numerosOrdenados.txt"))){
            System.out.print("\n\tMOSTRANDO NUMEROS ORDENADOS:");
            while (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                System.out.print(numero + " ");
            }  
        } catch (Exception e) {
            System.out.print("ERROR:" + e.getMessage());
        }
    }

/*............................................................................................................. */

    public static void buscar(int num){
        int[] numeros = leerNumeros2();
        if(numeros == null){
            System.out.print("PROBLEMAS");
            return;
        }

        boolean encontrado = false;
        int posicion=-1;
        for (int i = 0; i<numeros.length; i++) {
            if (numeros[i] == num) {
                encontrado = true;
                posicion = i+1;
                break;
            }    
        }

        if (encontrado) {
            System.out.print("El " + num + " existe en el documentos 'numeros' en la posición: " + posicion);
        }
        else{
            System.out.print("El " + num + " No existe en el documento 'numeros'");
        }

    }
    
}
