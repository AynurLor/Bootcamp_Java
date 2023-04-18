import java.util.UUID;

public class TransactionsService {

    private TransactionsList transaction = new TransactionsLinkedList();
    private UsersList usersList = new UsersArrayList();
    private TransactionsLinkedList transactionsList = new TransactionsLinkedList();

    @Override
    public String toString() {
        return "TransactionsService{" +
                "transaction=" + transaction +
                ", usersList=" + usersList +
                ", transactionsList=" + transactionsList +
                '}';
    }

    public void addUser(User user) {
        this.usersList.addUser(user);
    }
//    public User getUser(){
//        return
//    }
    public int getBalans(int id) throws UserNotFoundException {
        return this.usersList.getUserById(id).getBalance();
    }

    public void addTransaction(int sender, int recipient, int amount) throws UserNotFoundException, IllegalTransactionException {


        User first = usersList.getUserById(sender);
        User second = usersList.getUserById(recipient);
        if (amount < 0 || first.getBalance() < amount) {
            throw new IllegalTransactionException("Illegal Transaction.");
        }

        Transaction credit = new Transaction(first, second, Transfer.credits, -amount);
        Transaction debit = new Transaction(first, second, Transfer.debits, amount);

        credit.setIdentifier(debit.getIdentifier());
        first.getTransactionsList().addTransaction(credit);
        second.getTransactionsList().addTransaction(debit);

        second.setBalance(second.getBalance()+amount);
        first.setBalance(first.getBalance()-amount);
    }

    public Transaction[] getInfoTransaction(int idUser) throws UserNotFoundException {
        return usersList.getUserById(idUser).getTransactionsList().toArray();
    }

    public void deleteTransaction(UUID transId, int userId) throws UserNotFoundException, TransactionNotFoundException {
        usersList.getUserById(userId).getTransactionsList().deleteTransaction(transId);
    }

    public Transaction[] CheckTransaction() throws UserNotFoundException {

        TransactionsLinkedList transactionList = new TransactionsLinkedList();
        Transaction[] arrayFirst = getTransaction().toArray();
        if (arrayFirst == null)
            return transactionList.toArray();

        for (int i = 0; i < arrayFirst.length; i++) {
            int count = 0;
            for (int j = 0; j < arrayFirst.length; j++) {
                if (arrayFirst[i].getIdentifier().equals(arrayFirst[j].getIdentifier())) {
                    count++;
                }
            }
            if (count != 2) {
                transactionList.addTransaction(arrayFirst[i]);
            }
        }
        return transactionList.toArray();
    }

    private TransactionsLinkedList getTransaction() throws UserNotFoundException {
        TransactionsLinkedList TransList = new TransactionsLinkedList();

        for (int i = 0; i < usersList.getCountUser(); i++) {
            User user = usersList.getUserByIndex(i);
            if (user != null) {
                int size = user.getTransactionsList().getSize();
                for (int j = 0; j < size; j++) {
                    TransList.addTransaction(user.getTransactionsList().toArray()[j]);
                }
            }
        }
        return TransList;
    }

}
