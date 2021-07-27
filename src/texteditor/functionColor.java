package texteditor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class functionColor {
    JColorChooser cc;
    JColorChooser fontcc;
    Color newColor;

    public void setbgColor(JTextArea area) {

        JFrame colorframe = new JFrame("Change Background Color");
        colorframe.setBounds(100, 100, 650, 350);
        colorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorframe.setLayout(null);

        JPanel colorChooserPanel = new JPanel( );
        colorChooserPanel.setBounds(0, 50, 650, 350);
        colorframe.add(colorChooserPanel);

        cc = new JColorChooser( );
        cc.getSelectionModel( ).addChangeListener(new ChangeListener( ) {
            @Override
            public void stateChanged(ChangeEvent e) {
                newColor = cc.getColor( );
                area.setBackground(newColor);
            }
        });
        //To Remove Preview Color Panel
        cc.setPreviewPanel(new JPanel( ));
        //To Remove Color Chooser Panel
        colorChooserPanel.add(cc);
        cc.removeChooserPanel(cc.getChooserPanels( )[4]);
        cc.removeChooserPanel(cc.getChooserPanels( )[1]);
        cc.removeChooserPanel(cc.getChooserPanels( )[0]);
        cc.removeChooserPanel(cc.getChooserPanels( )[0]);

        colorframe.setVisible(true);
    }

    public void setfontColor(JTextArea area) {
        JFrame fontcolorframe = new JFrame("Change Font Color");
        fontcolorframe.setBounds(100, 100, 650, 350);
        fontcolorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fontcolorframe.setLayout(null);

        JPanel fontColorChooserPanel = new JPanel( );
        fontColorChooserPanel.setBounds(0, 50, 650, 350);
        fontcolorframe.add(fontColorChooserPanel);

        fontcc = new JColorChooser( );
        fontcc.getSelectionModel( ).addChangeListener(new ChangeListener( ) {
            @Override
            public void stateChanged(ChangeEvent e) {
                area.setForeground(fontcc.getColor( ));
            }
        });
        //To Remove Preview Color Panel
        fontcc.setPreviewPanel(new JPanel( ));
        //To Remove Color Chooser Panel
        fontColorChooserPanel.add(fontcc);
        fontcc.removeChooserPanel(fontcc.getChooserPanels( )[4]);
        fontcc.removeChooserPanel(fontcc.getChooserPanels( )[1]);
        fontcc.removeChooserPanel(fontcc.getChooserPanels( )[0]);
        fontcc.removeChooserPanel(fontcc.getChooserPanels( )[0]);

        fontcolorframe.setVisible(true);
    }
}
