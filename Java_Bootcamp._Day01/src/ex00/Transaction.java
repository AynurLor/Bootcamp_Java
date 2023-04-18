import java.util.UUID;

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

    public UUID getIdentifier_() {
        return Identifier_;
    }

    public void setIdentifier_(UUID identifier_) {
        Identifier_ = identifier_;
    }

    public User getRecipient_() {
        return Recipient_;
    }

    public void setRecipient_(User recipient_) {
        Recipient_ = recipient_;
    }

    public User getSender_() {
        return Sender_;
    }

    public void setSender_(User sender_) {
        Sender_ = sender_;
    }

    public Transfer getTransferCategory_() {
        return TransferCategory_;
    }

    public void setTransferCategory_(Transfer transferCategory_) {
        TransferCategory_ = transferCategory_;
    }

    public Integer getAmount_() {
        return Amount_;
    }

    public void setAmount_(Integer amount_) {
        Amount_ = amount_;
    }

    public Transaction(User recipient_, User sender, Transfer transferCategory_, Integer amount) {
        if ((TransferCategory_ == Transfer.credits && amount > 0) ||
            (TransferCategory_ == Transfer.debits && amount < 0)) {
            System.err.println("Amount error");
        } else if ((TransferCategory_ == Transfer.credits && Sender_.getBalance() < Amount_) ||
                   (TransferCategory_ == Transfer.debits && Recipient_.getBalance() < -Amount_)) {
            System.err.println("Amount error");
        }
        Identifier_ = UUID.randomUUID();
        Recipient_ = recipient_;
        Sender_ = sender;
        TransferCategory_ = transferCategory_;
        Amount_ = amount;
    }

}
