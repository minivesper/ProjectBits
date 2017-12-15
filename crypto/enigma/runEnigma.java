import java.io.Console;
import java.io.*;
import java.util.*;

class runEnigma {
  public static void main(String[] args) {
    enigma e = new enigma();
    Console c = System.console();
    boolean quit = false;
    boolean eSet = false;
    while(!quit) {
      String inp = c.readLine("What would you like to do?\n1. set Enigma\n2. Encrypt text\n3. Decrypt text\n4. Quit\n : ");
      if(inp.equals("1")) {
        String ScramblerOrder = c.readLine("enter order of Scramblers. E.G. \"0 1 2\"\n: ");
        int[] scramblerOrderArr = new int[3];
        String[] ScramblerOrderString = ScramblerOrder.split(" ");
        for(int i = 0; i< ScramblerOrderString.length; i++) {
          scramblerOrderArr[i] = Integer.parseInt(ScramblerOrderString[i]);
          System.out.println("order: " + scramblerOrderArr[i]);
        }
        System.out.println(scramblerOrderArr[0] + scramblerOrderArr[1] + scramblerOrderArr[2]);
        String StartingLetters = c.readLine("enter starting letters for scramblers. E.G. \"a b c\"\n: ");
        String[] StartingLettersArr = StartingLetters.split(" ");
        System.out.println(StartingLettersArr[0] + StartingLettersArr[1] + StartingLettersArr[2]);
        String plugboardString = c.readLine("enter plugboard string. E.G. \"a/b-j/k\" implies that a is switched with b and j is switched with k.\n: ");
        e.setScramblers(scramblerOrderArr, StartingLettersArr);
        e.setplugBoard(plugboardString);
        eSet = true;
      }
      else if(inp.equals("2")) {
        String filename = c.readLine("Enter plaintext filename. E.G. \"plaintext.txt\"\n: ");
        String plaintext = readFile(filename);
        System.out.println(plaintext);
        String enc = e.encrypt(plaintext, true);
        System.out.println(enc);
      }
      else if(inp.equals("3")) {
        String filename = c.readLine("Enter ciphertext filename. E.G. \"ciphertext.txt\"\n: ");
        String ciphertext = readFile(filename);
        System.out.println(ciphertext);
        String dec = e.encrypt(ciphertext, false);
        System.out.println(dec);
      }
      else if(inp.equals("4")) {
        quit = true;
      }
    }
  }

  public static String readFile(String filename) {
    File file = new File(filename);
    BufferedReader reader = null;
    String finaltext = "";
    try {
        reader = new BufferedReader(new FileReader(file));
        String text = null;

        while ((text = reader.readLine()) != null) {
            finaltext = finaltext + text;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
        }
    }
  return finaltext;
  }
}
