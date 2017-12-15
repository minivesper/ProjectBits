public class gameData {

  int size;
  int p1;
  int p2;

  public gameData(String p1_option, String p2_option, String size_option)
  {
    size = Integer.parseInt(Character.toString(size_option.charAt(0)));
    if(p1_option.equals("Human"))
    {
      p1 = 1;
    }
    else if(p1_option.equals("Computer"))
    {
      p1 = 0;
    }
    else
    {
      System.out.println("Something Went Horribly Wrong");
    }
    if(p2_option.equals("Human"))
    {
      p2 = 1;
    }
    else if(p2_option.equals("Computer"))
    {
      p2 = 0;
    }
    else
    {
      System.out.println("Something Went Horribly Wrong");
    }

  }

}
