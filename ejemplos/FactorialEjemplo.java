package ejemplos;

public class FactorialEjemplo {

    public static void main(String[] args) {
        // n = n * (n-1)
        //si n = 0 es igual a 1
        // si n = 1 es igual a 1
        int numero = 0;
        long resultado = 0;

        //comprueba si entran los dos parametros
        if (args.length < 2) {
            System.out.println("Se requieren 2 parámetros: <Número> <Método (I/R)>");
            System.exit(1);
        }
        // comprobar que el primer argumento es un entero
        if(!esEntero(args[0])){
            System.out.println("Primer parametro no numerico : debe ser un entero positivo o negativo");
            System.exit(2);
        }


        // cuando se sabe que es un numero entero positivo o negativo lo guardamos
         numero= Integer.parseInt(args[0]);

        if (numero < 0) {
            System.out.println("Número incorrecto: debe ser >= 0");
            System.exit(1);
        }







        if (args[1].length() !=1) {
            System.out.println("Método de cálculo desconocido: debe ser Iterativo o Recursivo (I/i/Rr)");
            System.exit(3);
        }


        switch ( Character.toUpperCase(args[1].charAt(0))){
            case 'I': resultado = factorIterativo(numero);
                System.out.println("Factorial iterativo de " + numero + ": " + resultado);
                break;

            case 'R':  resultado = factorRecursivo(numero);
                System.out.println("Factorial recursivo de " + numero + ": " + resultado);
                break;
            default:  System.out.println("Método de cálculo desconocido: debe ser Iterativo o Recursivo (I/i/Rr)");
                System.exit(3);
        }



    }

    public static int factorIterativo(int n){
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    public static int factorRecursivo(int n){

        if (n <= 1) {
            return 1;
        }
        return n * factorRecursivo(n - 1);
    }



    private static boolean esEntero(String s){

        if(s==null || s.isEmpty()){
            return false;
        }
        int n = 0;
        if (s.charAt(0) == '-') {
            if (s.length() == 1) return false;
            n = 1;

        }
        for (int i = n; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }




}
