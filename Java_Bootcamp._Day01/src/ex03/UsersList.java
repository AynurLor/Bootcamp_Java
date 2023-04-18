import java.util.ArrayList;
import java.util.List;

public interface UsersList {

    public void addUser(User user);
    public User getUserById(int idUser) throws UserNotFoundException;
    public User getUserByIndex(int index) throws UserNotFoundException;
    public Integer getCountUser();

}
