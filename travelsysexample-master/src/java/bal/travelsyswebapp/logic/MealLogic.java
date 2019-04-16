package bal.travelsyswebapp.logic;

import bal.travelsyswebapp.database.DatabaseX;
import bal.travelsyswebapp.objects.MealObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MealLogic extends Logic
{

    public ArrayList<MealObj> getAllMeals() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.meal ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<MealObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescription;
            
            MealObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strDescription = CResult.getString("description");
                    
                    CTemp = new MealObj(iId, strName, strDescription);
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

    public int insertMealRows(String p_strName, String p_strDescription) 
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.meal(id,name,description) "
                + "VALUES(0,'"+p_strName+"','"+p_strDescription+"'); ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public int deleteMealRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId,"meal");
        return iRows;
    }

    public MealObj getMealById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.meal "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        MealObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescription;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    strDescription = CResult.getString("description");
                    
                    CTemp = new MealObj(p_iId, strName, strDescription);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
    }

    public int updateMealRows(int p_iId, String p_strName, String p_strDescription) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update travelsys.meal "
                + "set name = '"+p_strName+"',description = '"+p_strDescription+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
