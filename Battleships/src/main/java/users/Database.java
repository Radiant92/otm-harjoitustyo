
package users;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Manages users by providing methods that can read and write users into a file,
 * and also return lists containing users.
 *
 * @author strohm
 */
public class Database {

    private ArrayList<User> users;
    private String file;

    /**
     * Constructor either finds and reads text file by its name given in the
     * parameter String file, or creates a new text file named after the
     * parameter String file. If the file is found the constructor will create
     * and add the users into the users list with the user information read from
     * the file.
     *
     * @param file String name of the file where user information is written.
     * @throws Exception if the file is not found, creates a new file with the
     * name of the parameter String file.
     */
    public Database(String file) throws Exception {
        this.users = new ArrayList<>();
        this.file = file;

        try {
            Files.lines(Paths.get(this.file)).forEach(line -> {
                String[] parts = line.split(";");
                users.add(new User(parts[0], Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
            });

        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(this.file));
            writer.flush();
            writer.close();
        }

    }

    /**
     * Writes all user information from the users list into the text file.
     *
     * @throws Exception that does nothing here.
     */
    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getName() + ";" + user.getWinsEasy() + ";"
                        + user.getWinsNormal() + ";" + user.getWinsHard() + "\n");
            }
            writer.flush();
            writer.close();
        }
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     * Checks if username is already in use, if not creates a new user with zero
     * wins and adds it to the users list. afterwards calls save() method to
     * save new users list into text file if a new user was added.
     *
     * @param name the name that is to be given to the new user.
     * @throws Exception that does nothing here.
     */
    public void addUser(String name) throws Exception {
        boolean containsName = false;
        if (!name.trim().isEmpty()) {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    containsName = true;
                    break;
                }
            }
            if (containsName == false) {

                users.add(new User(name, 0, 0, 0));
                save();
            }
        }
    }

    /**
     *
     * @return the list of users that are sorted by their easy game wins.
     */
    public List<User> getTopEasy() {
        Collections.sort(users, (User a, User b) -> b.getWinsEasy() - a.getWinsEasy());
        return users;
    }

    /**
     *
     * @return the list of users that are sorted by their normal game wins.
     */
    public List<User> getTopNormal() {
        Collections.sort(users, (User a, User b) -> b.getWinsNormal() - a.getWinsNormal());
        return users;
    }

    /**
     *
     * @return the list of users that are sorted by their hard game wins.
     */
    public List<User> getTopHard() {
        Collections.sort(users, (User a, User b) -> b.getWinsHard() - a.getWinsHard());
        return users;
    }

}
