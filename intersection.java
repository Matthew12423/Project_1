package project1forme.roughdraft;

import java.util.ArrayList;

public class intersection 
{
  
  /** 
   * @param args
   * this is the implmentation for intersection, which takes two string arrays and only adds equal strings found
   * in both arrays to a linked list. this is done using a nested for loop that compares all the elements from the 
   * first array to the second. if the string element for the first array (outer loop) is the same as the element 
   * of the second array (innter loop), then a new element would be added to the list called list intersecion.
   * after all is finished, the list will be converted back to a string array and printed out using seperate for loops.
   */
  public static void main(String[] args) 
  {

    String[] array1 = { "a", "b", "c" };
    String[] array2 = { "b", "b", "d", "e" };
    ArrayList<String> listInt = new ArrayList<>();

    for (int i=0; i <array1.length; i++)
    {
      for (int j=0; j <array2.length; j++)
      {
        if (array1[i] == array2[j])
        {
          if (!listInt.contains(array1[i])) 
          {
            listInt.add(array1[i]);
          }
          break;
        }
      }
    }

    String[] arrayInt = new String[listInt.size()];
    for (int i = 0; i < listInt.size(); i++) 
    {
      arrayInt[i] = listInt.get(i);
    }

    for (int i=0; i <arrayInt.length;i++)
    {
      System.out.print(arrayInt[i]);
    }
  
  }
}