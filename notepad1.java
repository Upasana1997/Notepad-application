/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
/*Notepad application*/
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class notepad1 implements ActionListener
{
JMenuBar mbar;
JMenu file,edit,format,help;
JMenuItem fnew,open,save,saveAs,page,print,exit;
JMenuItem undo,cut,copy,paste,delete,find,findnext,selectall,timedate;
JMenuItem wordwrap,font;
JMenuItem about,topics;
JTextArea ta;
JFrame f;
  final Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
   String wholeText,findString;
     int ind=0;
public notepad1()
{
f=new JFrame("Notepad");
mbar=new JMenuBar();
f.setJMenuBar(mbar);
ta=new JTextArea();
f.add(ta);

file=new JMenu("File");
file.setMnemonic(KeyEvent.VK_F);
edit=new JMenu("Edit");
edit.setMnemonic(KeyEvent.VK_E);
format=new JMenu("Format");
format.setMnemonic(KeyEvent.VK_O);
help=new JMenu("Help");
help.setMnemonic(KeyEvent.VK_H);
fnew=new JMenuItem("New");
fnew.setAccelerator(KeyStroke.getKeyStroke(
KeyEvent.VK_N, ActionEvent.CTRL_MASK));
fnew.addActionListener(this);
open=new JMenuItem("Open");
open.setAccelerator(KeyStroke.getKeyStroke(
KeyEvent.VK_O, ActionEvent.CTRL_MASK));
open.addActionListener(this);
save=new JMenuItem("Save");
save.setAccelerator(KeyStroke.getKeyStroke(
KeyEvent.VK_S, ActionEvent.CTRL_MASK));
save.addActionListener(this);
saveAs=new JMenuItem("SaveAs");
saveAs.addActionListener(this);
page=new JMenuItem("Page Setup...");
page.addActionListener(this);
print=new JMenuItem("Print...");
print.addActionListener(this);
exit=new JMenuItem("Exit");
exit.addActionListener(this);
undo=new JMenuItem("Undo");
undo.addActionListener(this);
cut=new JMenuItem("Cut");
cut.addActionListener(this);
copy=new JMenuItem("Copy");
copy.addActionListener(this);
paste=new JMenuItem("Paste");
paste.addActionListener(this);
delete=new JMenuItem("Delete");
delete.addActionListener(this);
find=new JMenuItem("Find");
find.addActionListener(this);
findnext=new JMenuItem("Find Next");
findnext.addActionListener(this);
selectall=new JMenuItem("Select All");
selectall.addActionListener(this);
timedate=new JMenuItem("Time/Date");
timedate.addActionListener(this);
wordwrap=new JMenuItem("Word Wrap");
wordwrap.addActionListener(this);
font=new JMenuItem("Font...");
font.addActionListener(this);
about=new JMenuItem("About Notepad");
about.addActionListener(this);
topics=new JMenuItem("Help topics");
topics.addActionListener(this);
file.add(fnew);
file.add(open);
file.add(save);
file.add(saveAs);
file.addSeparator();
file.add(page);
file.add(print);
file.addSeparator();
file.add(exit);
edit.add(undo);
edit.addSeparator();
edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(delete);
edit.addSeparator();
edit.add(find);
edit.add(findnext);
edit.addSeparator();
edit.add(selectall);
edit.add(timedate);
format.add(wordwrap);
format.add(font);
help.add(topics);
help.addSeparator();
help.add(about);
mbar.add(file);
mbar.add(edit);
mbar.add(format);
mbar.add(help);
f.setBounds(100,100,600,500);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public static void main(String args[])
{
new notepad1();
}
public void actionPerformed(ActionEvent ae)
{
JMenuItem mi=(JMenuItem)ae.getSource();
try
{
/*if(mi==fnew)
{
ta.setText("new is clicked");
}
else if(mi==open)
{
ta.setText("open is clicked");
}
else if(mi==save)
{
}
else if(mi==saveAs)
{
}
else if(mi==page)
{
}
else if(mi==cut)
{
}
else if(mi==copy)
{
}
else if(mi==paste)
{
}
else if(mi==delete)
{
}
else if(mi==find)
{
}
else if(mi==findnext)
{
}
else if(mi==selectall)
{
ta.selectAll();
}
else if(mi==timedate)
{
}
else if(mi==print)
{
}
else if(mi==exit)
{
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
else if(mi==wordwrap)
{
}
else if(mi==font)
{
}*/

if(mi==fnew)
{
ta.setText("");
}
else if(mi==open)
{
FileDialog fd=new FileDialog(f,"OPEN",FileDialog.LOAD);
fd.setVisible(true);
File file=new File(fd.getDirectory()+"\\"+fd.getFile());
Reader r=new BufferedReader(new FileReader(file));
char ch[]=new char[(int)file.length()];
r.read(ch,0,ch.length);
String s=new String(ch);
ta.setText(s);
r.close();
f.setTitle(fd.getFile()+" -Notepad");
}
else if(mi==save)
{
FileDialog fds=new FileDialog(f,"Save",FileDialog.SAVE);
fds.setVisible(true);
System.out.println("get dir==="+fds.getDirectory());
    Writer w=new FileWriter(fds.getDirectory()+"\\"+fds.getFile());
String str=ta.getText();
w.write(str);
w.close();
f.setTitle(fds.getFile()+" -Notepad2");
//mi.setEnabled(false);
}
else if(mi==saveAs)
{
FileDialog fds=new FileDialog(f,"Save",FileDialog.SAVE);
fds.setVisible(true);
System.out.println("get dir==="+fds.getDirectory());
Writer w=new FileWriter(fds.getDirectory()+"\\"+fds.getFile());
String str=ta.getText();
w.write(str);
w.close();
f.setTitle(fds.getFile()+" -Notepad2");
//mi.setEnabled(false);
}
else if(mi==cut)
{
String selection=ta.getSelectedText();
    StringSelection data=new StringSelection(selection);
clip.setContents(data,null);
//1 parameter stringselection,myclipboardowner
ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());
}
else if(mi==copy)
{
String selection=ta.getSelectedText();
//A Transferable which implements the capability required to transfer a string
//java.?awt.?datatransfer

StringSelection data=new StringSelection(selection);
clip.setContents(data,null);
}
else if(mi==paste)
{
    Transferable clipData=clip.getContents(clip);
/*defines the interface for classes that can be used to provide data for a transfer operation.*/
try
{
if(clipData.isDataFlavorSupported(DataFlavor.stringFlavor))
{
String s=(String)(clipData.getTransferData(DataFlavor.stringFlavor));
ta.replaceSelection(s);
}
}
catch(Exception a)
{}
}
else if(mi==find)
{
wholeText=ta.getText();
findString=JOptionPane.showInputDialog(f,"Find what","Findtitle",JOptionPane.INFORMATION_MESSAGE);
ind=wholeText.indexOf(findString,0);
if(ind>=0)
{
ta.setCaretPosition(ind);
ta.setSelectionStart(ind);
int a=ind+findString.length();
ta.setSelectionEnd(a);
}
}
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}


}

