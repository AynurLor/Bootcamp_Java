import java.util.UUID;

public class Program {
    public static void main(String[] args) throws UserNotFoundException, TransactionNotFoundException {
        User user1 = new User("Ainyr", 5000);
        User user2 = new User("Bulat", 1000);

        TransactionsLinkedList TransactionList = user1.getTransactionsList();
        Transaction transac1 = new Transaction(user1, user2, Transfer.credits, -100);
        Transaction transac2 = new Transaction(user1, user2, Transfer.debits, 600);

        TransactionList.addTransaction(transac1);
        TransactionList.addTransaction(transac2);
        System.out.println(user1.getTransactionsList().getSize());

        TransactionList.deleteTransaction(transac2.getIdentifier());
        for (Transaction item : TransactionList.toArray()) System.out.println(item);

        try {
            TransactionList.deleteTransaction(UUID.randomUUID());
        } catch (TransactionNotFoundException exception) {
            System.out.println(exception);
        }
    }
}
