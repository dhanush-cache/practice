import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CatppuccinDateSpinner extends JSpinner {
    public CatppuccinDateSpinner() {
        super(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(this, "dd/MM/yyyy");
        dateEditor.getTextField().setForeground(new Color(205, 214, 244));
        dateEditor.getTextField().setBackground(new Color(49, 50, 68));
        dateEditor.getTextField().setCaretColor(new Color(205, 214, 244));
        setEditor(dateEditor);
        Border border = BorderFactory.createLineBorder(new Color(17, 17, 27), 2, true);
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        dateEditor.getTextField().setBorder(padding);
        setBorder(border);
    }

    public String getDate() {
        return new SimpleDateFormat("dd MMMM yyyy").format(getValue());
    }

}
