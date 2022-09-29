package participants;

import java.io.Serializable;

public class Company implements Serializable {
    //идентивикатор сериализации
    protected static final long serialVersionUID = 1L;

    private String m_info;

    public Company(String info) {
        m_info = info;
    }
    public String getInfo() {
        return m_info;
    }
}
