package sample.models;

/**
 * 26.11.2017
 * User
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class User {

    private String name;
    private int result;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public User(String name, int result) {
        this.name = name;
        this.result = result;
    }
}
