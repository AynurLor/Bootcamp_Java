public class UserNotFoundException extends Exception{
    private int number;
    public int getNumber() {return number;}

    public UserNotFoundException(String message, int number) {
        super(message);
        this.number = number;
    }
}
