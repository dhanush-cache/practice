import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CatppuccinButton extends JButton {
    public CatppuccinButton(String text) {
        super(text);
        setForeground(new Color(30, 30, 46));
        setBackground(new Color(137, 180, 250));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(border, padding));
    }

    public CatppuccinButton(char symbol) {
        super(String.valueOf(symbol));
        setForeground(new Color(205, 214, 244));
        setBackground(new Color(49, 50, 68));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(border, padding));
    }

    public CatppuccinButton(int number) {
        super(String.valueOf(number));
        setForeground(new Color(205, 214, 244));
        setBackground(new Color(49, 50, 68));
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(border, padding));
    }
}
