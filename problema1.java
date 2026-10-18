import java.util.Scanner;

public class problema1 {

 public static void main(String[] args) {

     int[] numeros = new int[5];
     Scanner teclado = new Scanner(System.in);

    System.out.println("Dame un numero ");
    for (int i=0;i<5;i++){
        numeros[i]= teclado.nextInt();
    }

     for (int i=0;i<5;i++){

        if(!(numeros[i]<100)){
            System.out.println("Es del volumen : "+numeros[i]/100);
        }
        else if(numeros[i]>999999){
            System.out.println("Pasa el limite");
         }
        else{
            System.out.println("No esta en volumen");
        }


     }



    teclado.close();
    }

}
