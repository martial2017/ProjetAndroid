package isge.bf.org.projet;

/**
 * Created by mart on 29/04/2019.
 */

public class User {
    String nom;
    String password;

    public User(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }
    public User() {
        this.nom = " ";
        this.password = " ";
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
