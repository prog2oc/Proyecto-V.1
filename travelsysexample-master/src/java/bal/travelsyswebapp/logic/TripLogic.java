package bal.travelsyswebapp.logic;

import bal.travelsyswebapp.database.DatabaseX;
import bal.travelsyswebapp.objects.TripObj;
import bal.travelsyswebapp.objects.TripViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TripLogic extends Logic
{

    public ArrayList<TripViewObj> getAllTrips() 
    {
        //select * from travelsys.trip;
        DatabaseX database = getDatabase();
        String strSql = "select * from travelsys.trip_view ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<TripViewObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strClient;
            String strCountryFrom;
            String strCountryDest;
            String strMeal;
            double dCost;
            
            TripViewObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strClient = CResult.getString("client");
                    strCountryFrom = CResult.getString("countryfrom");
                    strCountryDest = CResult.getString("countrydest");
                    strMeal = CResult.getString("meal");
                    dCost = CResult.getDouble("cost");
                    
                    CTemp = new TripViewObj(iId, strClient, strCountryFrom, strCountryDest, strMeal, dCost);
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

    public int insertTripRows(int p_iIdClient, int p_iCountryFrom, int p_iCountryDest,
            int p_iMeal,double p_dCost) 
    {
        //
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO travelsys.trip"
                + "(id,idclient,idcountryfrom, idcountrydestination,idmeal,cost) "
                + "VALUES(0,"+p_iIdClient+","+p_iCountryFrom+","+p_iCountryDest+","
                + ""+p_iMeal+","+p_dCost+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
