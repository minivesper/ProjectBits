import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class enigma {

  Scrambler[] scramblers;
  Scrambler first_Scrambler;
  Scrambler last_Scrambler;
  Scrambler reflector;
  plugboard p;
  String[] alphabet =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

  public enigma()
  {
    this.scramblers = pop_Scramblers();
    this.p = new plugboard();
    this.reflector = new Scrambler(0);
    this.reflector.setScrambler("a");
  }

  public Scrambler[] pop_Scramblers() {
    Scrambler[] scramblers = new Scrambler[3];
    for(int i = 0; i < scramblers.length; i++) {
      scramblers[i] = new Scrambler(i);
    }
    return scramblers;
  }

  public void setplugBoard(String plug_inp) {
      String[] split_plug = plug_inp.split("-");
      for(int i = 0; i < split_plug.length; i++) {
        String[] swap_chars = split_plug[i].split("/");
        if(swap_chars.length > 1) {
          this.getplugboard().swapPlug(swap_chars[0], swap_chars[1]);
        }
      }

  }
  public String encrypt(String inp, boolean encrypt_or_decrypt) {
    String changed_text = "";
    for(int i = 0; i < inp.length(); i++) {
      Scrambler sc = this.first_Scrambler;
      int x = Arrays.asList(this.alphabet).indexOf(String.valueOf(inp.charAt(i)));
      System.out.println(x);
      while(sc != null) {
        x = sc.inp_to_out(x);
        System.out.println(this.alphabet[x]);
        sc = sc.child_scram;
      }
      if(encrypt_or_decrypt) { x = this.reflector.inp_to_out(x); }
      else { x = this.reflector.out_to_inp(x); }
      sc = this.last_Scrambler;
      while(sc != null) {
        x = sc.out_to_inp(x);
        System.out.println(this.alphabet[x]);
        sc = sc.parent_scram;
      }
      changed_text = changed_text + this.alphabet[x];
      this.rotateScramblers();
    }
    return changed_text;
  }
  public void setScramblers(int[] scramblerOrd, String[] initScrambleLetter) {
    this.first_Scrambler = this.getScramblers()[scramblerOrd[0]];
    for(int i = 0; i < scramblerOrd.length - 1; i++) {
      this.getScramblers()[scramblerOrd[i]].setChild(this.getScramblers()[scramblerOrd[i+1]]);
      this.getScramblers()[scramblerOrd[i]].setScrambler(initScrambleLetter[i]);
    }
    this.getScramblers()[scramblerOrd[scramblerOrd.length - 1]].setChild(null);
    this.last_Scrambler = this.getScramblers()[scramblerOrd[scramblerOrd.length - 1]];
    this.getScramblers()[scramblerOrd[scramblerOrd.length - 1]].setScrambler(initScrambleLetter[scramblerOrd.length - 1]);
  }

  public void rotateScramblers() {
    this.first_Scrambler.rotate();
  }

  public Scrambler[] getScramblers() {
    return this.scramblers;
  }

  public plugboard getplugboard() {
    return this.p;
  }
}
