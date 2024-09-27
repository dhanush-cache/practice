import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CatppuccinList<T> extends JList<T> {
    public CatppuccinList(T[] listData) {
        super(listData);
        setForeground(new Color(205, 214, 244));
        setBackground(new Color(49, 50, 68));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(border, padding));
    }
}
