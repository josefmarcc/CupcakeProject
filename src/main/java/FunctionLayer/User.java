package FunctionLayer;

/**
 * Her er en klasse der laver User objekter.
 * @author Thor, Hallur, Josef og Frederik
 */
public class User {

    private int id;
    private String email;
    private String password;
    private String role;
    private int credit;

    public User( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCredit() {
        return credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String showBalance(){
        return "Balance: " + credit + " kr";
    }



    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'';
    }

}
