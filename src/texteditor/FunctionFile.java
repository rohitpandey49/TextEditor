package texteditor;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.print.PrinterException;
import java.io.*;

public class FunctionFile {

     String filegetname = null;
     File filename = null;
     String filegetdir = null;
     BufferedWriter outfile = null;

     //Open new text editor
     public void newTextEditor(JTextArea area, JFrame window){
          area.setText("");
          window.setTitle("Untitled - Notepad");
          filegetname = null;
     }
     //Open existing file in text editor
     public void open(JTextArea area , JFrame window){
          JFileChooser choose = new JFileChooser( );
          choose.setAcceptAllFileFilterUsed(false);
          FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
          choose.addChoosableFileFilter(restrict);
          int action = choose.showOpenDialog(window);
          if (action != JFileChooser.APPROVE_OPTION) {
               return;
          }
          filename = choose.getSelectedFile( );
          filegetname = filename.getName( );
          filegetdir = filename.getPath( );
          try {
               BufferedReader infile = new BufferedReader(new FileReader(filename));
               area.read(infile, null);
               window.setTitle(filegetname + " - Notepad");
          } catch (Exception r) {
               System.out.println(r);
          }
     }

     //Save file
     public void save(JMenuItem saveas, JTextArea area){
          if (filegetname == null) {
               saveas.doClick( );
          } else {
               try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(filegetdir, false));
                    System.out.println("aT SAVE " + filegetdir);
                    area.write(bw);

               } catch (Exception f) {
                    System.out.println(f);
               }
          }
     }
     //Save as new file
     public void saveAs(JFrame window , JTextArea area){
          JFileChooser savefinal = new JFileChooser( );
          savefinal.setApproveButtonText("Save");
          savefinal.setDialogTitle("Save As");
          int action = savefinal.showOpenDialog(window);
          if (action != JFileChooser.APPROVE_OPTION) {
               return;
          }

          filename = new File(savefinal.getSelectedFile( ) + ".txt");
          filegetname = filename.getName( );
          filegetdir = filename.getPath( );
          System.out.println(filegetdir);
          window.setTitle(filegetname + "- Notepad");

          try {
               outfile = new BufferedWriter(new FileWriter(filename));
               area.write(outfile);

          } catch (Exception f) {
               System.out.println(f);
          }

     }
     //
     public  void print(JTextArea area){
          try {
               area.print( );
          } catch (PrinterException printerException) {
               printerException.printStackTrace( );
          }
     }

}
