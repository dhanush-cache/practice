import javax.swing.*;
import java.awt.*;

public class CatppuccinCheckBox extends JCheckBox {
    public CatppuccinCheckBox(String text) {
        super(text);
        setForeground(new Color(205, 214, 244));
        setOpaque(false);
    }
}
