import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CatppuccinComboBox<T> extends JComboBox<T> {
    public CatppuccinComboBox(T[] items) {
        super(items);
        setForeground(new Color(205, 214, 244));
        setBackground(new Color(49, 50, 68));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        setBorder(border);
    }
}
