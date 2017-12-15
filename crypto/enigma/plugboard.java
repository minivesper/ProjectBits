import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class plugboard {

  HashMap plugs;

  public plugboard() {
    plugs = new HashMap();
    String[] alphabet =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    for(int i = 0; i < alphabet.length; i++) {
      plugs.put(alphabet[i],alphabet[i]);
    }
  }
  public void swapPlug(String p1, String p2) {
    HashMap plugs = this.getPlugs();
    Object p1_val = plugs.get(p1);
    Object p2_val = plugs.get(p2);
    plugs.put(p1, p2_val);
    plugs.put(p2, p1_val);
    System.out.println("swapped cables " + p1 + " and " + p2);
  }

  public void resetPlugs() {
    HashMap plugs = this.getPlugs();
    String[] alphabet =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    for(int i = 0; i < alphabet.length; i++) {
      plugs.put(alphabet[i],alphabet[i]);
    }
  }

  public HashMap getPlugs() {
    return this.plugs;
  }

  public Object inp_to_out(String inp) {
    return this.getPlugs().get(inp);
  }

  public String toString() {
    String print_str = "";
    Set set = this.getPlugs().entrySet();
    Iterator i = set.iterator();
     while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
        print_str = print_str + me.getKey() + ": " + me.getValue() + ", ";
     }
     return print_str;
  }
}
