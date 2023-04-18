import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction value);
    void deleteTransaction(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();

}
