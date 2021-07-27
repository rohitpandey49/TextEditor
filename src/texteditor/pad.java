package texteditor;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/*
* @author Rohit Pandey
* Created : 27-07-2021
*/

public class pad implements ActionListener {
    JFrame window;
    public JTextArea area;
    boolean isWordWrapON = false;
    String text;
    String defaultFont = "Arial";
    int defaultFontstyle = 0;
    int defaultFontsize = 20;
    JScrollPane pane;
    JMenuItem saveas;
    JMenuItem wordwrap;
    UndoManager um = new UndoManager( );

    FunctionFile objFile = new FunctionFile( );
    functionColor objColor = new functionColor( );

pad() {

        window = new JFrame( );
        window.setTitle("Untitled - Notepad");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1536, 864);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/texteditor/notepad.png");
        window.setIconImage(icon);

        JMenuBar menu = new JMenuBar( );
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");
        JMenu format = new JMenu("Format");
        JMenu fontsize = new JMenu("Font Size");
        JMenu font = new JMenu("Font");
        JMenu fontstyle = new JMenu("Font Style");
        JMenu color = new JMenu("Color");
        menu.add(file);
        menu.add(edit);
        menu.add(format);
        menu.add(color);
        menu.add(help);

        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);

        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);

        saveas = new JMenuItem("Save as");
        saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + InputEvent.SHIFT_DOWN_MASK));
        saveas.addActionListener(this);

        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exit.addActionListener(this);

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(this);

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        paste.addActionListener(this);

        JMenuItem all = new JMenuItem("Select All");
        all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        all.addActionListener(this);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);

        wordwrap = new JMenuItem("Word Wrap : Off");
        wordwrap.addActionListener(this);
        wordwrap.setActionCommand("Word Wrap");

        JMenuItem fontArial = new JMenuItem("Arial");
        fontArial.addActionListener(this);

        JMenuItem fontCSMS = new JMenuItem("Sans Serif");
        fontCSMS.addActionListener(this);

        JMenuItem fontTMR = new JMenuItem("Times New Roman");
        fontTMR.addActionListener(this);

        JMenuItem fontCalibri = new JMenuItem("Calibri");
        fontCalibri.addActionListener(this);

        JMenuItem fontLucida = new JMenuItem("Lucida Console");
        fontLucida.addActionListener(this);

        JMenuItem font8 = new JMenuItem("8");
        font8.addActionListener(this);
        JMenuItem font12 = new JMenuItem("12");
        font12.addActionListener(this);
        JMenuItem font16 = new JMenuItem("16");
        font16.addActionListener(this);
        JMenuItem font20 = new JMenuItem("20");
        font20.addActionListener(this);
        JMenuItem font24 = new JMenuItem("24");
        font24.addActionListener(this);
        JMenuItem font28 = new JMenuItem("28");
        font28.addActionListener(this);
        JMenuItem font32 = new JMenuItem("32");
        font32.addActionListener(this);
        JMenuItem font36 = new JMenuItem("36");
        font36.addActionListener(this);
        JMenuItem font40 = new JMenuItem("40");
        font40.addActionListener(this);
        JMenuItem font44 = new JMenuItem("44");
        font44.addActionListener(this);

        JMenuItem regular = new JMenuItem("Regular");
        regular.addActionListener(this);
        JMenuItem bold = new JMenuItem("Bold");
        bold.addActionListener(this);
        JMenuItem oblique = new JMenuItem("Oblique");
        oblique.addActionListener(this);
        JMenuItem boldoblique = new JMenuItem("Bold Oblique");
        boldoblique.addActionListener(this);

        JMenuItem backgroundcolor = new JMenuItem("Background Color");
        backgroundcolor.addActionListener(this);

        JMenuItem fontcolor = new JMenuItem("Font Color");
        fontcolor.addActionListener(this);

        JMenuItem undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo.addActionListener(this);


        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(print);
        file.add(exit);
        edit.add(undo);
        edit.add(redo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(all);
        help.add(about);
        format.add(wordwrap);
        format.add(fontsize);
        format.add(font);
        format.add(fontstyle);
        font.add(fontCSMS);
        font.add(fontArial);
        font.add(fontLucida);
        font.add(fontCalibri);
        font.add(fontTMR);
        fontsize.add(font8);
        fontsize.add(font12);
        fontsize.add(font16);
        fontsize.add(font20);
        fontsize.add(font24);
        fontsize.add(font28);
        fontsize.add(font32);
        fontsize.add(font36);
        fontsize.add(font40);
        fontsize.add(font44);
        fontstyle.add(regular);
        fontstyle.add(oblique);
        fontstyle.add(bold);
        fontstyle.add(boldoblique);
        color.add(backgroundcolor);
        color.add(fontcolor);

        JTextField TextF = new JTextField(30);
        TextF.setBounds(10, 10, 120, 20);
        window.setJMenuBar(menu);
        area = new JTextArea( );
        area.getDocument( ).addUndoableEditListener(e -> um.addEdit(e.getEdit( )));
        pane = new JScrollPane(area);
        area.setBackground(Color.white);
        area.setFont(new Font(defaultFont, defaultFontstyle, 20));
        window.add(pane, BorderLayout.CENTER);
        pane.setBorder(BorderFactory.createEmptyBorder( ));


    }


    public static void main(String[] args) {
        new pad( ).window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand( )) {
            case "New":
                objFile.newTextEditor(area, window);
                break;
            case "Open":
                objFile.open(area, window);

                break;
            case "Save":
                objFile.save(saveas, area);

                break;
            case "Save as":
                objFile.saveAs(window, area);

                break;
            case "Print":
                objFile.print(area);

                break;
            case "Copy":
                text = area.getSelectedText( );

                break;
            case "Paste":
                area.insert(text, area.getCaretPosition( ));
                break;
            case "Cut":
                text = area.getSelectedText( );
                area.replaceRange("", area.getSelectionStart( ), area.getSelectionEnd( ));
                break;
            case "Select All":
                area.selectAll( );

                break;
            case "About":
                new aboutTextEditor( ).setVisible(true);

                break;
            case "Exit":
                System.exit(0);
            case "Word Wrap":
                isWordWrapON = new function_Format( ).wordwrap(isWordWrapON, area, wordwrap);
                break;
            case "8":
                defaultFontsize = 8;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "12":
                defaultFontsize = 12;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "16":
                defaultFontsize = 16;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "20":
                defaultFontsize = 20;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "24":
                defaultFontsize = 24;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "28":
                defaultFontsize = 28;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "32":
                defaultFontsize = 32;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "36":
                defaultFontsize = 36;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "40":
                defaultFontsize = 40;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "44":
                defaultFontsize = 44;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Arial":
                defaultFont = "Arial";
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Sans Serif":
                defaultFont = "Sans Serif";
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Calibri":
                defaultFont = "Calibri";
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Times New Roman":
                defaultFont = "Times New Roman";
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Lucida Console":
                defaultFont = "Lucida Console";
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Regular":
                defaultFontstyle = 0;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Bold":
                defaultFontstyle = 1;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Oblique":
                defaultFontstyle = 2;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Bold Oblique":
                defaultFontstyle = 3;
                new function_Format( ).setFont(defaultFontsize, defaultFont, area, defaultFontstyle);
                break;
            case "Background Color":
                objColor.setbgColor(area);
                break;
            case "Font Color":
                objColor.setfontColor(area);
                break;
            case "Undo":
                new functionEdit( ).undo(um);
                break;
            case "Redo":
                new functionEdit( ).redo(um);
                break;
        }

    }
}
