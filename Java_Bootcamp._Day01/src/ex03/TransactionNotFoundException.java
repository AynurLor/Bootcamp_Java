import java.util.UUID;

public class TransactionNotFoundException extends Exception{
    private UUID number;
    public UUID getNumber() {return number;}

    public TransactionNotFoundException(String message, UUID number) {
        super(message);
        this.number = number;
    }
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
