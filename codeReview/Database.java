public class Database
{
    private SqlServerConnection _databaseConnection;

    public Database(SqlServerConnection databaseConnection)
    {
        _databaseConnection = databaseConnection;
    }
}
