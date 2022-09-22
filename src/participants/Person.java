package participants;

import java.io.Serializable;

public class Person implements Serializable {
    //идентивикатор сериализации
    protected static final long serialVersionUID = 1L;

    private String m_info;

    public Person(String info) {
        m_info = info;
    }
    public String getInfo() {
        return m_info;
    }
}
