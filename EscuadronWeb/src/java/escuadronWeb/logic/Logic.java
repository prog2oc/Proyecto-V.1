package escuadronWeb.logic;

import escuadronWeb.database.DatabaseEscuadron;

public class Logic 
{
    private DatabaseEscuadron m_CDatabase;

    public Logic() 
    {
        setDatabase( createDatabase() );
    }

    public DatabaseEscuadron getDatabase() 
    {
        return m_CDatabase;
    }

    private void setDatabase(DatabaseEscuadron p_CDatabase) 
    {
        m_CDatabase = p_CDatabase;
    }

    private DatabaseEscuadron createDatabase() 
    {
        DatabaseEscuadron database = getDatabase();
        if(database == null)
        {
            database = new DatabaseEscuadron();
        }
        return database;
    }    
}