import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CatppuccinTextField extends JTextField {
    public CatppuccinTextField(int columns) {
        super(columns);
        setForeground(new Color(205, 214, 244));
        setBackground(new Color(49, 50, 68));
        setCaretColor(new Color(205, 214, 244));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(border, padding));
    }
}
