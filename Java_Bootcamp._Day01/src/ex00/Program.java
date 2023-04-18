public class Program {
    public static void main(String[] args) {
    User ivan = new User(101, "Ivan", 1500);
    User sergey = new User(102, "Sergey", 0);

    Transaction transh = new Transaction(sergey, ivan, Transfer.credits,-1000);
        System.out.println(transh);
    }


}
