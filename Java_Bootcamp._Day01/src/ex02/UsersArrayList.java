import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersArrayList implements UsersList {
    private User[] userList;
    private int size;
    private int countUsers;

    @Override
    public String toString() {
        return "UsersArrayList{" +
                "\nuserList=" + Arrays.toString(userList) +
                "\nsize=" + size +
                "\ncountUsers=" + countUsers +
                '}';
    }

    public UsersArrayList() {
        userList = new User[10];
        size = 10;
        countUsers = 0;
    }


    @Override
    public void addUser(User user) {
        if (user != null) {
            if (size == countUsers) {
                User[] newUserList = new User[size * 2];
                for (int i = 0; i < size; i++) newUserList[i] = userList[i];
                size = size * 2;
                userList = newUserList;
            }
            userList[countUsers++] = user;
        }
    }

    @Override
    public User getUserById(int idUser) throws UserNotFoundException {

        if (size >= 0) {
            for (int i = 0; i < countUsers; i++) {
                if (userList[i].getIdentifier() == idUser && userList[i] != null) {
                    return userList[i];
                }
            }
            throw new UserNotFoundException("The number is less than", idUser);
        }
        return null;
    }

    @Override
    public User getUserByIndex(int index) throws UserNotFoundException {
        if (size < index || userList[index - 1] != null) throw new UserNotFoundException("User not founded is index", index);
        return userList[index];
    }

    @Override
    public Integer getCountUser() {
        return size;
    }
}

