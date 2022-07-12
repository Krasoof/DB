import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Usser {

    String login;
    String haslo;
    Connect connection;
    Statement statement;



    public Usser(String login, String haslo) throws SQLException {
        this.login = login;
        this.haslo = haslo;
        this.connection =  new Connect(login,haslo);
        this.statement = connection.con.createStatement();
    }

    public void closeConnection() throws SQLException {
        this.connection.con.close();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Connection getCon() {
        return connection.con;
    }

    public void setCon(Connection con) {
        this.connection.con = con;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usser usser = (Usser) o;
        return Objects.equals(login, usser.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "Usser{" +
                "login='" + login + '\'' +
                '}';
    }
}
