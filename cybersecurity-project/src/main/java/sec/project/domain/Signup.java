package sec.project.domain;


public class Signup {

    private String username;
    private String password;

    public Signup() {
        super();
    }

    public Signup(String name, String password) {
        this();
        this.username = name;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}
