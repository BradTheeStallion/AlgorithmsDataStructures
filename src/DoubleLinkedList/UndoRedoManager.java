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
    private Node head;

    // Undo operation
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            return null;
        }

        currentState = currentState.prev;
        return currentState.state;
    }

    public void addState(T newState) {
        Node newNode = new Node(newState);

        if (currentState == null) {
            head = newNode;
            currentState = newNode;
            return;
        }

        if (currentState.next != null) {
            currentState.next = null;
        }

        newNode.prev = currentState;
        currentState.next = newNode;

        currentState = newNode;
    }

    // Redo Operation
    public T redo() {
        if (currentState == null || currentState.next == null) {
            return null;
        }

        currentState = currentState.next;
        return currentState.state;
    }

    public T getCurrentState() {
        return currentState != null ? currentState.state : null;
    }

    public static void main(String[] args) {
        // Example usage
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("First State");
        manager.addState("Second State");
        manager.addState("Third State");

        System.out.println("Current State: " + manager.getCurrentState());

        System.out.println("Undo: " + manager.undo());

        System.out.println("Redo: " + manager.redo());

        manager.addState("Fourth State");
        System.out.println("Current State: " + manager.getCurrentState());
    }
}