package bal.travelsyswebapp.objects;

public class MealObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strDescription;

    public MealObj(int p_iId, String p_strName, 
            String p_strDescription) 
    {
        setId(p_iId);
        setName(p_strName);
        setDescription(p_strDescription);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public String getName() 
    {
        return m_strName;
    }

    private void setName(String p_strName) 
    {
        m_strName = p_strName;
    }

    public String getCode() 
    {
        return m_strDescription;
    }

    private void setDescription(String p_strCode) 
    {
        m_strDescription = p_strCode;
    }

    public String getDescription() 
    {
        return m_strDescription;
    }

    
}
