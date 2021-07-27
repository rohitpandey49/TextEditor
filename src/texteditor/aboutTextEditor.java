package texteditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aboutTextEditor extends JFrame implements ActionListener {
    JButton ok;
    aboutTextEditor(){
        setBounds(130,70,600,500);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("texteditor/windows.png"));
        Image i2 =i1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon( i2 );
        JLabel l1= new JLabel( i3 );
        l1.setBounds(100,40, 400,80);
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("texteditor/notepad.png"));
        Image i5 =i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon( i5 );
        JLabel l2= new JLabel( i6 );
        l2.setBounds(50,180, 70,70);
        add(l2);

        JLabel l3 = new JLabel( "<html>Created by Rohit Pandey <br> Version 1.0.0 <br> Rohit Pandey, All Rights Reserved <br> Notepad is a word processing program <br> which allow changing of text in computer file.<br> Notepad is simple text editor for basic text editing program which enables computer used to create documents" );
        l3.setBounds(150,130,400,300);
        add(l3);
        l3.setFont(new Font("San Serif", Font.PLAIN , 16));

        ok = new JButton( "OK" );
        ok.setBounds(480,400,80,25);
        add(ok);
        ok.addActionListener(this);








    }

    public static void main(String[] args) {
        aboutTextEditor obj = new aboutTextEditor();
        obj.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OK")){
            this.setVisible(false);

        }

    }
}
