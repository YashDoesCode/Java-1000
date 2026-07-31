// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {
   public GuessTheNumber() {
   }

   public static void main(String[] args) throws IOException {
      Game player = new Game();
      int Guesses = 0;

      while(!player.isCorrectNumber()) {
         try {
            player.takeUserInput();
            ++Guesses;
            player.setNoOfGuesses(Guesses);
         } catch (Exception var5) {
            System.out.println(var5.getMessage());
         }

         if (player.getNoOfGuesses() % 5 == 0) {
            System.out.println("Do you want to continue? Y/N");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char ans = (char)br.read();
            if (ans != 'Y' && ans != 'y') {
               System.exit(0);
            } else {
               player.setNoOfGuesses(0);
            }
         }

         if (player.isCorrectNumber()) {
            System.out.println("Guessed right!");
            System.out.println("No of Guesses you took :" + player.getNoOfGuesses());
         } else if (player.userGenerated > player.compGenerated && player.userGenerated - player.compGenerated <= 7) {
            System.out.println("try something little smaller");
         } else if (player.userGenerated > player.compGenerated && player.userGenerated - player.compGenerated >= 8) {
            System.out.println("try something quite smaller");
         } else if (player.userGenerated < player.compGenerated && player.compGenerated - player.userGenerated <= 7) {
            System.out.println("try something little larger");
         } else {
            System.out.println("Try something quite larger");
         }
      }

   }
}
