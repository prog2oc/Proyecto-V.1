package bal.travelsyswebapp.objects;

public class TripViewObj 
{
    private int m_iId;
    private String m_strClient;
    private String m_strCountryFrom;
    private String m_strCountryDest;
    private String m_strMeal;
    private double m_dCost;

    public TripViewObj(int p_iId, String p_strClient, String p_strCountryFrom, 
            String p_strCountryDest, String p_strMeal, double p_dCost) 
    {
        setId(p_iId);
        setClient(p_strClient);
        setCountryFrom(p_strCountryFrom);
        setCountryDest(p_strCountryDest);
        setMeal(p_strMeal);
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

    public String getClient() 
    {
        return m_strClient;
    }

    private void setClient(String p_strClient) 
    {
        m_strClient = p_strClient;
    }

    public String getCountryFrom() 
    {
        return m_strCountryFrom;
    }

    private void setCountryFrom(String p_strCountryFrom) 
    {
        m_strCountryFrom = p_strCountryFrom;
    }

    public String getCountryDest() 
    {
        return m_strCountryDest;
    }

    private void setCountryDest(String p_strCountryDest) 
    {
        m_strCountryDest = p_strCountryDest;
    }

    public String getMeal() 
    {
        return m_strMeal;
    }

    private void setMeal(String p_strMeal) 
    {
        m_strMeal = p_strMeal;
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
