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

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class Application {

	public static void main(String[] argv) throws Exception {

		JFrame application = createNewJFrame();

	}

	public static JFrame createNewJFrame() {

		JFrame jFrame = new JFrame();

		jFrame.add(createNewNoteCard());

		jFrame.setSize(300, 300);


		jFrame.setVisible(true);

		return jFrame;
	}

	public static JTextArea createNewNoteCard() {

		JTextArea jTextArea = new JTextArea();

		Color color = new Color(238, 238, 0);
		jTextArea.setBackground(color);

		return jTextArea;

	}

	public static class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}

	}

	public static class MyKeyboardListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			System.out.println(e.getKeyCode());

		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static class MyFocusListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
		}

	}

	public static class MyMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX() + " " + e.getY());
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}

}
