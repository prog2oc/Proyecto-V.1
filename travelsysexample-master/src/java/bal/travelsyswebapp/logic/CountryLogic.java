package bal.travelsyswebapp.logic;

import bal.travelsyswebapp.database.DatabaseX;
import bal.travelsyswebapp.objects.CountryObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryLogic extends Logic
{

    public ArrayList<CountryObj> getAllCountries() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.country ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CountryObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strCode;
            
            CountryObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strCode = CResult.getString("code");
                    
                    CTemp = new CountryObj(iId, strName, strCode);
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

    public int insertCountryRows(String p_strName, 
            String p_strCode) 
    {
        //INSERT INTO travelsys.country(id,name,code) VALUES(0,'wakanda','wk');
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.country"
                + "(id,name,code) "
                + "VALUES(0,'"+p_strName+"','"+p_strCode+"');";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public int deleteCountryRows(int p_iId) 
    {

        int iRows = deleteTableRows(p_iId,"country");
        return iRows;
    }

    public CountryObj getCountryById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.country "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CountryObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strCode;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strCode = CResult.getString("code");
                    
                    CTemp = new CountryObj(p_iId, strName, strCode);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
    }

    public int updateCountryRows(int p_iId, String p_strName, String p_strCode) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "UPDATE travelsys.country "
                + "SET name = '"+p_strName+"', code = '"+p_strCode+"' "
                + "WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;        
    }
    
}
