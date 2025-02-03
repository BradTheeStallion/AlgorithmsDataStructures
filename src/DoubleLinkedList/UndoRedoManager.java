package DoubleLinkedList;

/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowoing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;
    //Undo operation
    public T undo(){
        //implement me
    }

    //perform an operation
    public void  addState (T newState) {
        //implement me

    }

    //Redo Operation
    public T redo(){
        //implement me
    }

    public static void main(String[] args) {


    }
}