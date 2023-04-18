public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        UsersArrayList userList = new UsersArrayList();
        userList.addUser(new User("User 1", 100324));
        userList.addUser(new User("User 2", 2353426));
        userList.addUser(new User("User 3", 2353242));
        userList.addUser(new User("User 4 ", 23524362));

        System.out.println(userList);

        System.out.println(userList.getUserById(2));
        System.out.println("---------------------");
        System.out.println(userList.getUserByIndex(3));
        System.out.println("-------exception 1-------");
        try {
            User coco = userList.getUserById(322);
        } catch (UserNotFoundException pp) {
            System.out.println(pp);
        }

    }
}
