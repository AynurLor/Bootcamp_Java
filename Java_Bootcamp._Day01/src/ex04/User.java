public class User {
    private Integer Identifier_;
    private String Name_;
    private Integer Balance_;
    private TransactionsLinkedList Transaction_;

    public TransactionsLinkedList getTransactionsList() {
        return Transaction_;
    }

    public User(String name, Integer balance) {
        Identifier_ = UserIdsGenerator.getInstance().generateId();
        Transaction_ = new TransactionsLinkedList();
        Name_ = name;
        Balance_ = balance;
    }

    public Integer getBalance() {
        if (Balance_ < 0) {
            System.err.println("Negative balance");
        }
        return Balance_;
    }

    @Override
    public String toString() {
        return "User01{" +
                "Identifier_=" + Identifier_ +
                ", Name_='" + Name_ + '\'' +
                ", Balance_=" + Balance_ +
                '}';
    }

    public String getName() {
        return Name_;
    }

    public Integer getIdentifier() {
        return Identifier_;
    }

    public void setBalance(Integer balance) {
        if (balance > 0) Balance_ = balance;
        else if (balance < 0) System.err.println("Negative balance");
    }

    public void setIdentifier(Integer identifier) {
        Identifier_ = identifier;
    }

    public void setName(String name) {
        Name_ = name;
    }
}
