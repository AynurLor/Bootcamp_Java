
public class User {
    private Integer Identifier_;;
    private String Name_;
    private Integer Balance_;

    public User(Integer identifier, String name, Integer balance) {
        Identifier_ = identifier;
        Name_ = name;
        if (balance < 0) System.err.println("Negative balance");
        else Balance_ = balance;
    }

    public Integer getBalance() {
        if (Balance_ < 0) {
            System.err.println("Negative balance");
        }
        return Balance_;
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
