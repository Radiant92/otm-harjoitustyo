
package users;

/**
 * Class provides user creation, information retrieval and management of games
 * won.
 *
 * @author strohm
 */
public class User {

    private String name;
    private int winsEasy;
    private int winsNormal;
    private int winsHard;

    /**
     * Constructor witch creates an user based on information set as its
     * parameters
     *
     * @param name sets name as users username.
     * @param easy users current wins on easy setting.
     * @param normal users current wins on normal setting.
     * @param hard users current wins on hard setting.
     */
    public User(String name, int easy, int normal, int hard) {
        this.name = name;
        winsEasy = easy;
        winsNormal = normal;
        winsHard = hard;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a win to easy games won.
     */
    public void winEasy() {
        this.winsEasy++;
    }

    /**
     * Adds a win to normal games won.
     */
    public void winNormal() {
        this.winsNormal++;
    }

    /**
     * Adds a win to hard games won.
     */
    public void winHard() {
        this.winsHard++;
    }

    public int getWinsEasy() {
        return winsEasy;
    }

    public int getWinsNormal() {
        return winsNormal;
    }

    public int getWinsHard() {
        return winsHard;
    }

}
