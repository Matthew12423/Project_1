package project1forme;

public class Node<T> 
{

    private T data;
    private Node<T> next;

    private Node(T dataPortion) 
    {
        this(dataPortion, null);
    }

    private Node(T dataPortion, Node<T> nextNode) 
    {

        data = dataPortion;
        next = nextNode;
    }
}