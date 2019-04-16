package bal.travelsyswebapp.objects;

public class CountryObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strCode;

    public CountryObj(int p_iId, String p_strName, 
            String p_strCode) 
    {
        setId(p_iId);
        setName(p_strName);
        setCode(p_strCode);
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
        return m_strCode;
    }

    private void setCode(String p_strCode) 
    {
        m_strCode = p_strCode;
    }
    
    
}
