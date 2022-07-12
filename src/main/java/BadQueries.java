import java.sql.ResultSet;
import java.sql.SQLException;

//do nothing riht now
public class BadQueries implements IQuery{


    @Override
    public ResultSet selectQ(String query, Usser usser) throws SQLException {
        return usser.statement.executeQuery(("select klient_imie from bd4_klient where klient_nazwisko =") + query);
    }




}
