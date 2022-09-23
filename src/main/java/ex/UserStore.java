package ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = new User("null", false);
        for (User temp : users) {
            if (login.equals(temp.getUserName())) {
                result = temp;
                break;
            }
            if (result.getUserName().equals("null")) {
                throw new UserNotFoundException("User not found");
            }
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUserName().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Zve", true)
        };
        try {
            User user = findUser(users, "Zve");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
