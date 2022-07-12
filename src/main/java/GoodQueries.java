import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//do nothing riht now
public class GoodQueries implements IQuery {

    private final String select = "select klient_imie from bd4_klient where klient_nazwisko =?";


    @Override
    public ResultSet selectQ(String query, Usser usser) throws SQLException
    {

        PreparedStatement statementToDo = usser.connection.con.prepareStatement(select);
        statementToDo.setString(1,query);
        return statementToDo.executeQuery();

    }





}
