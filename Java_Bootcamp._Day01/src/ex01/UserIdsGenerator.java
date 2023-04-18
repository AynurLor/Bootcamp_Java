public class UserIdsGenerator {
    private static UserIdsGenerator Instance;
    private static int id;
    private UserIdsGenerator() {};

    public static UserIdsGenerator getInstance() {
        if (Instance == null) {
            Instance = new UserIdsGenerator();
        }
        return Instance;
    }
    public int generateId() {
        return id++;
    }

}
