package project1forme.roughdraft;

import java.util.ArrayList;

public class difference 
{
    public static void main(String[] args) 
    {
        String[] array1 = { "a", "b", "c" };
        String[] array2 = { "b", "b", "d", "e" };
        String[] arrayDif = diff(array1,array2);

        for (int i=0; i < arrayDif.length;i++)
        {
            System.out.print(arrayDif[i]);
        }
    }

    
    /** 
     * @param arrayA
     * @param arrayB
     * @return String[]
     * ArrayA is the array and string that will be subtracted.
     * ArrayB is the subtractor. The diff program here scans through
     * ArrayA and checks for identical entries in ArrayB. Should
     * ArrayB have an entry or entries that matches ArrayA's, the entries will be removed from
     * ArrayA and returned.
     */
    public static String[] diff(String[] arrayA, String[] arrayB)
    {
        ArrayList<String> listDif = new ArrayList<>();

        for (int i=0; i < arrayA.length;i++)
        {
            listDif.add(arrayA[i]);
        }

        for (int i=0; i< arrayB.length;i++)
        {
            if (listDif.contains(arrayB[i]))
            {
                listDif.remove(arrayB[i]);
            }
        }

        String[] arrayDif = new String[listDif.size()];
        for (int i = 0; i < listDif.size(); i++) 
        {
          arrayDif[i] = listDif.get(i);
        }

        return arrayDif;
    }
    
}
