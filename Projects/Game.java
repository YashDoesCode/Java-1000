// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Game {
   int compGenerated = (int)(Math.random() * 100.0);
   int userGenerated;
   int noOfGuesses;

   public int getNoOfGuesses() {
      return this.noOfGuesses;
   }

   public void setNoOfGuesses(int guesses) {
      this.noOfGuesses = guesses;
   }

   Game() {
   }

   public void takeUserInput() throws IOException, NotValidException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter any number between 1 and 100");
      this.userGenerated = Integer.parseInt(br.readLine());
      if (this.userGenerated <= 0 || this.userGenerated >= 100) {
         throw new NotValidException("Number should lie between 1 and 100");
      }
   }

   public boolean isCorrectNumber() {
      return this.compGenerated == this.userGenerated;
   }
}
