package pack1;

class Node {
    double value;
    Node next;

    public Node(final double value) {
        this.value = value;
    }

}

class LinkedList {

    Node head;

    void insertAtfirst(final double value) {
        final Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void insertAtLast(final double value) {

        final Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    Node reverseRecursively(final Node n) {
        if (n == null) {
            return null;
        } else if (n.next == null) {
            head = n;
            return n;

        } else {
            final Node t = reverseRecursively(n.next);
            n.next = null;
            t.next = n;
            return n;
        }

    }

    public static void main(final String args[]) {
        final LinkedList linkedList = new LinkedList();
        linkedList.insertAtLast(10);
        linkedList.insertAtLast(20);
        linkedList.insertAtLast(30);
        linkedList.insertAtLast(40);
        linkedList.display();
        linkedList.reverse();
        linkedList.display();
        linkedList.reverseRecursively(linkedList.head);
        linkedList.display();

    }

}
