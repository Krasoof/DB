import java.sql.ResultSet;
import java.sql.SQLException;

public class BadQueries implements IQuery{


    @Override
    public ResultSet selectQ(String query, Usser usser) throws SQLException {
        return usser.statement.executeQuery(query);
    }

    @Override
    public void dmlQuerries(String[] params, String kindOfQuery, Usser usser) throws SQLException {

    }


}
