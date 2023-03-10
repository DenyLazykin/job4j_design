package ru.job4j.generics.exercises;

public class Stack<T> {
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            stringStack.push(s);
        }
        String s;
        while ((s = stringStack.pop()) != null) {
            System.out.println(s);
        }
    }
}
