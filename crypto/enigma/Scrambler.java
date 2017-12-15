import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class Scrambler {

  int offset;
  String[] alphabet =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
  int[] scram0 = {2, 1, 12, 8, 15, 10, 24, 7, 18, 11, 17, 16, 14, 5, 23, 9, 4, 20, 22, 19, 6, 3, 21, 25, 0, 13};
  int[] scram1 = {19, 23, 5, 2, 6, 24, 10, 1, 12, 13, 22, 16, 25, 4, 9, 17, 14, 15, 18, 0, 21, 8, 7, 20, 11, 3 };
  int[] scram2 = {1, 10, 13, 7, 22, 5, 0, 9, 12, 6, 21, 2, 16, 11, 20, 19, 3, 24, 17, 8, 23, 18, 15, 14, 25, 4 };
  int[][] scramset = {scram0, scram1, scram2};
  HashMap scramble;
  HashMap invscramble;
  Scrambler child_scram;
  Scrambler parent_scram;

  public Scrambler(int scram_set_to_use) {
    this.offset = 0;
    scramble = new HashMap();
    invscramble = new HashMap();
    for(int i = 0; i < scramset[0].length; i++)
    {
      scramble.put(i, scramset[scram_set_to_use][i]);
      invscramble.put(scramset[scram_set_to_use][i], i);
    }
  }

  public void rotate()
  {
    this.offset += 1;
    if(this.offset % 26 == 0)
    {
      this.offset = 0;
      this.child_scram.rotate();
    }
  }

  public int inp_to_out(int inp) {
    int int_offset = 0;
    int adjusted_inp = inp;
    if(this.parent_scram != null) {
      int_offset = this.getOffset()-this.parent_scram.getOffset();
      adjusted_inp = inp + int_offset;
    }
    if(adjusted_inp < 0)
    {
      adjusted_inp = 26 + adjusted_inp;
    }
    // System.out.println(inp + " " + adjusted_inp);
    return (int)this.scramble.get(adjusted_inp);
  }

  public int out_to_inp(int inp) {
    int int_offset = 0;
    int adjusted_inp = inp;
    if(this.child_scram != null) {
      int_offset = this.getOffset()-this.child_scram.getOffset();
      adjusted_inp = inp + int_offset;
    }
    if(adjusted_inp < 0)
    {
      adjusted_inp = 26 + adjusted_inp;
    }
    // System.out.println(inp + " " + adjusted_inp);
    return (int)this.invscramble.get(adjusted_inp);
  }

  public void setScrambler(String init_letter) {
    this.offset = Arrays.asList(alphabet).indexOf(init_letter);
  }

  public void setChild(Scrambler child_scrambler) {
    this.child_scram = child_scrambler;
    if(child_scrambler != null) {
      child_scram.parent_scram = this;
    }
  }

  public int getOffset() {
    return this.offset;
  }

  public String toString() {
    String print_str = "";
    Set set = this.scramble.entrySet();
    Iterator i = set.iterator();
     while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        print_str = print_str + me.getKey() + ": " + me.getValue() + ", ";
     }
     return print_str;
    }
}
