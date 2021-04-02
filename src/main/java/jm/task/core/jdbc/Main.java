package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        String nameTable = "pensionniiFond";
        List<User> users = List.of(
                new User("Vissarion", "Nedopobedimii", (byte) 96),
                new User("Evlampii", "Shac", (byte) 83),
                new User("Klavdiya", "Przhevalskaya", (byte) 91),
                new User("Vladimir", "Tutin", (byte) 101));

        util.createTable(nameTable);
        for (User user : users) {
            util.joinUser(user, nameTable);
        }
        util.showTable(nameTable);
        util.deleteUser(2L, nameTable);
        util.clearTable(nameTable);
        util.deleteTable(nameTable);
    }
}
