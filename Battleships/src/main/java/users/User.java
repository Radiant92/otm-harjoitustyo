/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author strohm
 */
public class User {

    private String name;
    private int winsEasy;
    private int winsNormal;
    private int winsHard;

    public User(String name, int easy, int normal, int hard) {
        this.name = name;
        winsEasy = easy;
        winsNormal = normal;
        winsHard = hard;
    }

    public String getName() {
        return name;
    }

    public int getWinsEasy() {
        return winsEasy;
    }

    public void winEasy() {
        this.winsEasy++;
    }

    public void winNormal() {
        this.winsNormal++;
    }

    public void winHard() {
        this.winsHard++;
    }

    public int getWinsNormal() {
        return winsNormal;
    }

    public int getWinsHard() {
        return winsHard;
    }

}
