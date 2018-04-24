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

    String name;
    int winsEasy;
    int winsNormal;
    int winsHard;

    public User(String name, int easy, int normal, int hard) {
        this.name = name;
        winsEasy = easy;
        winsNormal = normal;
        winsHard = hard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinsEasy() {
        return winsEasy;
    }

    public void WinEasy() {
        this.winsEasy++;
    }

    public int getWinsNormal() {
        return winsNormal;
    }

    public void WinNormal() {
        this.winsNormal++;
    }

    public int getWinsHard() {
        return winsHard;
    }

    public void WinHard() {
        this.winsHard++;
    }

}
