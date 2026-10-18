package ejemplos;

public class distincionCasos {


    public static void main(String[] args) {

        // 0 args hola mundo
        // 1 args hola tal
        // 2 args o mas numeros args


        int n = args.length;


      switch (n){

          case 0: System.out.println("Hola mundo ");
           break;
          case 1: System.out.println("Hola "+args[0]);

          default: System.out.println("argumentos");

      }













    }
}
