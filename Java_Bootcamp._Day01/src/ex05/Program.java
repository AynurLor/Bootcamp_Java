import java.util.UUID;

public class Program {
    public static void main(String[] args) throws UserNotFoundException, TransactionNotFoundException, IllegalTransactionException {
        User user1 = new User("Ainyr", 5000);
        User user2 = new User("Nyrislam", 1000);

        TransactionsService menu = new TransactionsService();
        menu.addUser(user1);
        menu.addUser(user2);

        menu.addTransaction(user1.getIdentifier(), user2.getIdentifier(), 1000);
        menu.addTransaction(user2.getIdentifier(), user1.getIdentifier(), 500);
        menu.addTransaction(user2.getIdentifier(), user1.getIdentifier(), 100);
        System.out.println("-----------add transaction------------");
        Transaction[] arrayTransactionUser1 = menu.getInfoTransaction(user1.getIdentifier());
        UUID idTr = arrayTransactionUser1[1].getIdentifier();
        for (int i = 0; i < menu.getInfoTransaction(user1.getIdentifier()).length; i++) {
            System.out.println(arrayTransactionUser1[i]);
        }
        menu.deleteTransaction(idTr, user1.getIdentifier());
        System.out.println("-----------delete transaction------------");
        for (int i = 0; i < menu.getInfoTransaction(user1.getIdentifier()).length; i++) {
            System.out.println(arrayTransactionUser1[i]);
        }
    }
}
