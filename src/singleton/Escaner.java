package singleton;

import java.util.Scanner;


public class Escaner {

   private Scanner scanner;
   private static Escaner instancia;

   private Escaner(){
      scanner = new Scanner(System.in);
   }

   public static Escaner getInstancia() {
      if (instancia == null)
         instancia = new Escaner();
      return instancia;
   }

   public String proxLinea(){
      return scanner.nextLine();
   }

   public void cerrarScanner(){
      scanner.close();
   }
}


