package texteditor;

import javax.swing.*;
import java.awt.*;

public class function_Format extends JFrame{

    public boolean wordwrap(boolean isWordWrapON, JTextArea area, JMenuItem wordwrap){
        if(!isWordWrapON){
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
            wordwrap.setText("Word Wrap : On");
            return true;


        }
        else if (isWordWrapON) {
            area.setLineWrap(false);
            area.setWrapStyleWord(false);
            wordwrap.setText("Word Wrap : Off");
            return false;
        }
        return isWordWrapON;


    }

    public void setFont(int defaultFontsize, String selectedFont, JTextArea area, int defaultFontstyle){
        area.setFont(new Font(selectedFont, defaultFontstyle, defaultFontsize));

        }
    }

