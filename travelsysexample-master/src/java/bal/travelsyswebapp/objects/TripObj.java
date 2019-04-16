package bal.travelsyswebapp.objects;

public class TripObj 
{
    private int m_iId;
    private int m_iIdClient;
    private int m_iIdCountryFrom;
    private int m_iIdCountryDestination;
    private int m_iIdMeal;
    private double m_dCost;

    public TripObj(int p_iId, int p_iIdClient, int p_iIdCountryFrom, 
            int p_iIdCountryDestination, int p_iIdMeal, double p_dCost) 
    {
        setId(p_iId);
        setIdClient(p_iIdClient);
        setIdCountryFrom(p_iIdCountryFrom);
        setIdCountryDestination(p_iIdCountryDestination);
        setIdMeal(p_iIdMeal);
        setCost(p_dCost);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public int getIdClient() 
    {
        return m_iIdClient;
    }

    private void setIdClient(int p_iIdClient) 
    {
        m_iIdClient = p_iIdClient;
    } 
    
    public int getIdCountryFrom() 
    {
        return m_iIdCountryFrom;
    }

    private void setIdCountryFrom(int p_iIdCountryFrom) 
    {
        m_iIdCountryFrom = p_iIdCountryFrom;
    }  
    
    public int getIdCountryDestination() 
    {
        return m_iIdCountryDestination;
    }

    private void setIdCountryDestination(int p_iIdCountryDestination) 
    {
        m_iIdCountryDestination = p_iIdCountryDestination;
    } 

    public int getIdMeal() 
    {
        return m_iIdMeal;
    }

    private void setIdMeal(int p_iIdMeal) 
    {
        m_iIdMeal = p_iIdMeal;
    }

    public double getCost() 
    {
        return m_dCost;
    }

    private void setCost(double p_dCost) 
    {
        m_dCost = p_dCost;
    }

    
}
