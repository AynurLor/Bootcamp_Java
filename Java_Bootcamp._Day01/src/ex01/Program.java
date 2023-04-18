public class Program {
    public static void main(String[] args) {
        User us1 = new User("Ivan", 16000);
        System.out.println(us1.getIdentifier());
        User us2 = new User("Misha", 16000);
        System.out.println(us2.getIdentifier());
    }
}
