package bal.travelsyswebapp.logic;

import bal.travelsyswebapp.database.DatabaseX;
import bal.travelsyswebapp.objects.ClientObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientLogic extends Logic
{
    //metodo1
    public boolean insertClientBool(String p_strName, int p_iAge)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.client(id,name,age) "
                + "VALUES(0,'"+p_strName+"',"+p_iAge+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertClientRows(String p_strName, int p_iAge)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.client(id,name,age) "
                + "VALUES(0,'"+p_strName+"',"+p_iAge+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<ClientObj> getAllClients() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.client ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ClientObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            int iAge;
            
            ClientObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    iAge = CResult.getInt("age");
                    
                    CTemp = new ClientObj(iId, strName, iAge);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteClientRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "client");
        return iRows;
    }

    public ClientObj getClientById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.client where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ClientObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            int iAge;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    iAge = CResult.getInt("age");
                    
                    CTemp = new ClientObj(iId, strName, iAge);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateClientRows(int p_iId, String p_strName, int p_iAge) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update travelsys.client "
                + "set name = '"+p_strName+"',age = "+p_iAge+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}
