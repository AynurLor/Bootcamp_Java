import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private int size;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    static class Node {
        Transaction item;
        Node next;
        Node prev;

        Node(Node prev, Transaction element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public TransactionsLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void addTransaction(Transaction value) {
        if (value == null) {
            System.err.println("Value is null");
            System.exit(-1);
        }
        final Node lst = last;
        final Node newNode = new Node(lst, value, null);
        last = newNode;

        if (lst == null) {
            first = newNode;
        } else {
            lst.next = newNode;
        }
        size++;
    }


    @Override
    public void deleteTransaction(UUID id) throws TransactionNotFoundException {
        if (id == null) {
            throw new TransactionNotFoundException("Transaction Not Found");
        }
        for (Node tmp = first; tmp != null; tmp = tmp.next) {
            if (tmp.item.getIdentifier() == id && tmp.item != null) {
                Node next1 = tmp.next;
                Node prev1 = tmp.prev;

                if (prev1 == null) {
                    this.first = next1;
                } else {
                    prev1.next = next1;
                    tmp.prev = null;
                }
                if (next1 == null) {
                    this.last = prev1;
                } else {
                    next1.prev = prev1;
                    tmp.next = null;
                }
                tmp.item = null;
                size--;
                return;
            }
        }
        throw new TransactionNotFoundException("Transaction Not Found", id);
    }

    @Override
    public Transaction[] toArray() {
        if (size == 0) {
            return null;
        }
        Transaction[] transactions1 = new Transaction[size];
        int i = 0;
        for (Node tmp = first; tmp != null; tmp = tmp.next, i++) {
            transactions1[i] = tmp.item;
        }
        return transactions1;
    }

}
