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

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("texteditor/notepad.png"));
        Image i5 =i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon( i5 );
        JLabel l2= new JLabel( i6 );
        l2.setBounds(50,180, 70,70);
        add(l2);

        JLabel l3 = new JLabel( "<html>Created by Rohit Pandey <br> Version 1.0.0 <br> <br> Text Editor is a word processing program <br> which allow changing of text in computer file.<br> <br> It is for basic text editing program which enables computer used to create documents" );
        l3.setBounds(150,30,400,300);
        add(l3);
        l3.setFont(new Font("San Serif", Font.PLAIN , 20));

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
