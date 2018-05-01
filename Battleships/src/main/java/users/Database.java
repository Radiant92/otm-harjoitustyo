/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author strohm
 */
public class Database {

    private ArrayList<User> users;
    private String file;

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

    public List<User> getTopEasy() {
        Collections.sort(users, (User a, User b) -> b.getWinsEasy() - a.getWinsEasy());
        return users;
    }

    public List<User> getTopNormal() {
        Collections.sort(users, (User a, User b) -> b.getWinsNormal() - a.getWinsNormal());
        return users;
    }

    public List<User> getTopHard() {
        Collections.sort(users, (User a, User b) -> b.getWinsHard() - a.getWinsHard());
        return users;
    }

}
