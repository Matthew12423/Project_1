package project1forme.roughdraft;
public class union
{
  
  /** 
   * @param args
   * After creating two string arrays, the program will create a 
   * new string array that will get and combine the length of the original string arrays.
   * Afterwards, it will take the entries of the two strings and return a combined
   * string array that contains both string entries in based on the order they were listed. 
   * In our case, array1 was first so the entries of array1 will be displayed before array 2.
   */
  public static void main(String[] args) 
  {

    String[] array1 = { "a", "b", "c" };
    String[] array2 = { "b", "b", "d", "e" };
    String[] arrayTot= new String[array1.length+array2.length];

    for (int i = 0; i < array1.length; i++) 
    {
      arrayTot[i] = array1[i];
    }
    for (int i = 0; i < array2.length; i++) 
    {
      arrayTot[array1.length + i] = array2[i];
    }
//    
    
    for (int i=0; i <arrayTot.length;i++)
    {
      System.out.print(arrayTot[i]);
    }
  
  }
}