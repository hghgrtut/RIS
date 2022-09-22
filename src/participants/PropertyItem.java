package participants;

import java.io.Serializable;

public class PropertyItem implements Serializable {
    //идентивикатор сериализации
    protected static final long serialVersionUID = 1L;

    private String m_info;

    public PropertyItem(String info) {
        m_info = info;
    }
    public String getInfo() {
        return m_info;
    }

}
