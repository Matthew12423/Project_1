package project1forme;
//import java.util.Arrays;

public final class LinkedBag<T> implements BagInterface<T>
{
  private Node <T> firstNode;
  private int numberOfEntries;


  public LinkedBag()
  {
    firstNode = null;
    numberOfEntries = 0;
  }

  public int getCurrentSize()
  {
    return numberOfEntries;
  }

  public boolean isEmpty()
  {
   if (numberOfEntries ==0)
    {
        return true;
    }
     else
     {
        return false;
     }
  }
   /** 
     * @return int
     * The methods below get the current size and adds new entries to the bagArray.
     * The remove array function does the opposite and removes an entry by subtracting
     * from the index. Frequecy returns the number of times a certain object has appeared
     * while getindex returns an entry's location.
     */
  @Override
  public boolean add(T newEntry) 
  {
      Node<T> newNode = new Node<>(newEntry); // Create a new node with the new entry
      newNode.next = firstNode;
      firstNode = newNode;
      numberOfEntries++;
      return true;
  }


@Override
public T remove() 
{
    T result = null;
    if (firstNode != null) 
    {
        result = firstNode.data;
        firstNode = firstNode.next; // Remove the first node from the chain
        numberOfEntries--;
    }
    return result;
}

@Override
public boolean remove(T anEntry) 
{
 boolean result = false;
 Node <T> nodeNumber = getRefrenceTo(anEntry);

  if (nodeNumber != null)
  {
    nodeNumber.data = firstNode.data;
    firstNode = firstNode.next;
    numberOfEntries--;
    result = true;
  }
  return result;
}

private Node <T> getRefrenceTo(T anEntry)
{
    boolean found =false;
    Node <T> currentNode = firstNode;
    while (!found && (currentNode != null))
      {
        if (anEntry.equals(currentNode.data))
        {
          found = true;
        }
        else
        {
          currentNode = currentNode.next;
        }
      }
    return currentNode;
}


@Override
public void clear() 
{
    while (firstNode != null) 
    {
        Node<T> temp = firstNode;
        firstNode = firstNode.next; // Remove the first node
        temp.data = null; // Help with garbage collection
        temp.next = null;
    }
    numberOfEntries = 0;
}


@Override
public int getFrequencyOf(T anEntry) 
{
    int frequency = 0; 
    Node<T> currentNode = firstNode;

    while (currentNode != null) 
    {
        if (currentNode.data.equals(anEntry)) 
        {
            frequency++;
        }
        currentNode = currentNode.next;
    }
    return frequency;
}

@Override
public boolean contains(T anEntry) 
{
    boolean result = false;
    Node <T> currentNode = firstNode;
    while (currentNode != null) 
    {
        if (currentNode.data == anEntry)
        {
            result = true;
        }
        currentNode = currentNode.next;
    }
    return result;
}


/** 
 * @return T[]
 * Converts the string to an array.
 */
@Override
public T[] toArray() 
{
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[numberOfEntries];

    int index =0;
    Node <T> currentNode = firstNode;
    while ((index < numberOfEntries) && (currentNode != null))
    {
        result[index] = currentNode.data;
        index++;
        currentNode = currentNode.next;
    }
    return result;
}


/** 
 * @param anotherBag
 * @return BagInterface<T>
 * The union, difference, and intersection perform the same way they did
 * in their individual form. The union combines the arrays while the difference
 * removes duplicates from the chosen array. Intersection locates the first identical
 * entry in an array and returns the entry.
 */
@Override
public BagInterface<T> union(BagInterface<T> anotherBag) 
{
    ResizableArrayBag <T> unionBag = new ResizableArrayBag<>();

    T [] array1 = this.toArray();
    T [] array2 = anotherBag.toArray();


    for (int i = 0; i < array1.length; i++) 
    {
        unionBag.add(array1[i]);
    }
    for (int i = 0; i < array2.length; i++) 
    {
        unionBag.add(array2[i]);
    }

    return unionBag;
}

@Override
public BagInterface<T> intersection(BagInterface<T> anotherBag) 
{
    LinkedBag<T> intersectionBag = new LinkedBag<>();
    Node<T> currentNode = firstNode;

    while (currentNode != null) 
    {
        if (anotherBag.contains(currentNode.data) && intersectionBag.getFrequencyOf(currentNode.data) == 0) 
        {
            intersectionBag.add(currentNode.data);
        }
        currentNode = currentNode.next;
    }
    return intersectionBag;
}


@Override
public BagInterface<T> difference(BagInterface<T> anotherBag) 
{
    ResizableArrayBag <T> listDif = new ResizableArrayBag<>();

        T [] array1 = this.toArray();
        T [] array2 = anotherBag.toArray();

        for (int i=0; i < array1.length;i++)
        {
            listDif.add(array1[i]);
        }

        for (int i=0; i< array2.length;i++)
        {
            if (listDif.contains(array2[i]))
            {
                listDif.remove(array2[i]);
            }
        }


        return listDif;
}

}
