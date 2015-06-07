package com.clinkworks.stickpad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import com.clinkworks.neptical.util.Common;

@SuppressWarnings("unused")
public class Application {

	public static void main(String[] argv) throws Exception {
		JFrame application = createNewJFrame();
	}

	
	public static JFrame createNewJFrame() {

		JFrame jFrame = new JFrame();
		jFrame.addWindowListener(new MyWindowListener());
		//Notecard Creation
		jFrame.add(createNewNoteCard());
		jFrame.setSize(300, 300);
		jFrame.setVisible(true);
		return jFrame;
		
		
	}

	public static JTextArea createNewNoteCard() {

		// Add text area
		JTextArea jTextArea = new JTextArea();
		
		// Set Color
		Color color = new Color(238, 238, 0);
		jTextArea.setBackground(color);
		
		// Load document for current notecard
		
		MyDocumentListener myDocumentListener = new MyDocumentListener(new File("c:/dev/MyTestFile.txt"), jTextArea);
		// Add listener to document
		jTextArea.getDocument().addDocumentListener(myDocumentListener);

		return jTextArea;

	}

	static class MyDocumentListener implements DocumentListener {

		private File file;
		private JTextArea jTextArea;
		
		/**
		 * 
		 * @param file Notecard Display File
		 * @param jTextArea Rendered JTextArea
		 */
		MyDocumentListener(File file, JTextArea jTextArea){
			this.file = file;
			this.jTextArea = jTextArea;
			if(!file.exists()){
				updateFile();
			}
			jTextArea.append(Common.readFile(file));	
		}
		
		
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			displayEditInfo(arg0);
			updateFile();
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			displayEditInfo(arg0);
			updateFile();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			displayEditInfo(arg0);
			updateFile();
		}
		
		public void updateFile(){
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(jTextArea.getText());
				fileWriter.close();
			} catch (IOException e) {
				try {
					this.file.createNewFile();
					updateFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e.getMessage());	
				}
				
			}
		}
		
		
		
	    private void displayEditInfo(DocumentEvent e) {
            Document document = (Document)e.getDocument();
            String changedString = e.getType().toString() + ": ";
            int changeLength = e.getLength();
                        
            if(changeLength == 1){
            	changedString = changedString + " character";
            }else{
            	changedString = changedString + " characters.";
            }
            
            changedString = changedString +
                " Text length = " + document.getLength()
                + ".\n";
            
            System.out.println(changedString);
    }
		
	}
	
	public static class MyWindowListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		System.out.print("Activate");
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			System.out.print("Closed");

			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print("Closing");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print("Deactivated");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print("DeIconified");
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print("Iconified");
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.print("Opened");
		}
	
}
}	