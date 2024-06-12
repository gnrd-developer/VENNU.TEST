

public class Aplication{
    public static void main(String[] args){
        int op;
        int num;
        do {
            System.out.print("\n\n\tMENU\n"+
            "---------------\n"+
            "0 . SALIR'\n"+
            "1 . GENERAR ARCHIVO 'NUMEROS'\n"+
            "2 . MOSTRAR ARCHIVO 'NUMEROS'\n"+
            "3 . ORDENAR ARCHIVO 'NUMEROS'\n"+
            "4 . MOSTRAR ARCHIVO ORDENADO\n" +
            "5 . BUSCAR NUMERO EN ARCHIVO\n" +
            "\t OPCION NUMERO: "
            );
            op=Leer.datoInt();
            switch (op) {
                case 1:
                    Metodos.generarArchivo();
                    break;
                case 2:
                    Metodos.mostrarArchivo();
                    break;
                case 3:
                    Metodos.ordenar();
                    break;
                case 4:
                    Metodos.mostrarNumerosOrdenados();
                    break;
                case 5:
                    System.out.print("\n\tINGRESE EL NUMERO QUE BUSCA: ");
                    num=Leer.datoInt();
                    Metodos.buscar(num);
                    break;
                default:
                    break;
            }
        } while (op!=0);

    }
}