import java.util.UUID;

enum Transfer {
    debits,
    credits
}

public class Transaction {
    private UUID Identifier_;
    private User Recipient_;
    private User Sender_;
    private Transfer TransferCategory_;
    private Integer Amount_;

    @Override
    public String toString() {
        return "Transaction{" +
                "Identifier_=" + Identifier_.toString() +
                "\nRecipient_=" + Recipient_.getName() +
                "\nSender_=" + Sender_.getName() +
                "\nTransferCategory_=" +((TransferCategory_ == Transfer.debits)? "debits" : "credit") +
                "\nAmount_=" + Amount_ +
                '}';
    }

    public UUID getIdentifier() {
        return Identifier_;
    }

    public void setIdentifier(UUID identifier) {
        Identifier_ = identifier;
    }

    public User getRecipient() {
        return Recipient_;
    }

    public void setRecipient(User recipient) {
        Recipient_ = recipient;
    }

    public User getSender() {
        return Sender_;
    }

    public void setSender(User sender) {
        Sender_ = sender;
    }

    public Transfer getTransferCategory() {
        return TransferCategory_;
    }

    public void setTransferCategory(Transfer transferCategory) {
        TransferCategory_ = transferCategory;
    }

    public Integer getAmount() {
        return Amount_;
    }

    public void setAmount(Integer amount) {
        Amount_ = amount;
    }

    public Transaction(User recipient, User sender, Transfer transferCategory, Integer amount) {
        if ((TransferCategory_ == Transfer.credits && amount > 0) ||
            (TransferCategory_ == Transfer.debits && amount < 0)) {
            System.err.println("Amount error");
        } else if ((TransferCategory_ == Transfer.credits && Sender_.getBalance() < Amount_) ||
                   (TransferCategory_ == Transfer.debits && Recipient_.getBalance() < -Amount_)) {
            System.err.println("Amount error");
        }
        Identifier_ = UUID.randomUUID();
        Recipient_ = recipient;
        Sender_ = sender;
        TransferCategory_ = transferCategory;
        Amount_ = amount;
    }

}
