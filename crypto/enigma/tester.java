class tester {
  public static void main(String[] args) {
    //PLUGBOARD TESTING
    // plugboard p = new plugboard();
    // p.swapPlug("a","b");
    // System.out.println(p);
    // System.out.println(p.inp_to_out("a"));
    // System.out.println(p.inp_to_out("b"));
    // System.out.println(p.inp_to_out("c"));
    // SCRAMBLER TESTING
    // Scrambler sc1 = new Scrambler(0);
    // Scrambler sc2 = new Scrambler(1);
    // Scrambler sc3 = new Scrambler(2);
    // sc1.setScrambler("b");
    // sc2.setScrambler("c");
    // sc3.setScrambler("d");
    // sc1.setChild(sc2);
    // sc2.setChild(sc3);
    // Scrambler sc = sc1;
    // int x = 7;
    // while(sc != null) {
    //   x = sc.inp_to_out(x);
    //   System.out.println(x);
    //   sc = sc.child_scram;
    // }
    // x=x+1;
    // sc = sc3;
    // while(sc != null) {
    //   x = sc.out_to_inp(x);
    //   System.out.println(x);
    //   sc = sc.parent_scram;
    // }
    // sc = sc1;
    // while(sc != null) {
    //   x = sc.inp_to_out(x);
    //   System.out.println(x);
    //   sc = sc.child_scram;
    // }
    // x=x-1;
    // sc = sc3;
    // while(sc != null) {
    //   x = sc.out_to_inp(x);
    //   System.out.println(x);
    //   sc = sc.parent_scram;
    // }
    // for(int i = 0; i < 26*26; i++) {
    //   sc1.rotate();
    //   System.out.println(sc1 +", " + sc2 +", "+ sc3);
    // }
    // ENIGMA TESTING
    enigma e = new enigma();
    int[] x = {1,0,2};
    String[] y = {"c","d","e"};
    e.setScramblers(x,y);
    e.setplugBoard("a/b-l/k");
    System.out.println("inp with 1: " + e.getScramblers()[1].inp_to_out(1));
    String enc = e.encrypt("iwent", true);
    System.out.println("enc: "+ enc);
    e.setScramblers(x,y);
    e.setplugBoard("a/b-l/k");
    String dec = e.encrypt(enc, false);
    System.out.println(dec);
  }
}
