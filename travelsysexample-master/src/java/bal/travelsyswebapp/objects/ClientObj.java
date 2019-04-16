package bal.travelsyswebapp.objects;

public class ClientObj 
{
    private int m_iId;
    private String m_strName;
    private int m_iAge;

    public ClientObj(int p_iId, String p_strName, int p_iAge) 
    {
        setId(p_iId);
        setName(p_strName);
        setAge(p_iAge);
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

    public int getAge() 
    {
        return m_iAge;
    }

    private void setAge(int p_iAge) 
    {
        m_iAge = p_iAge;
    }
    
}
