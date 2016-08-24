package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow {

	public static void main(String[] args) {
		
		JFrame frmMain = new JFrame("Problema dos quadrados");
		JTextField txtSize = new JTextField("8");
		JButton btnStart = new JButton("Iniciar");
		JPanel panel = new JPanel();
		txtSize.setPreferredSize(new Dimension(48, 26));
		
		btnStart.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Board(Integer.parseInt(txtSize.getText()));
				super.mouseClicked(e);
			}
		});
		
		panel.add(new JLabel("Tamanho do tabuleiro (N x N);  N="));
		panel.add(txtSize);
		panel.add(btnStart);
		
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setLayout(new BorderLayout());
		frmMain.setBackground(Color.DARK_GRAY);
		frmMain.add(panel, BorderLayout.CENTER);
		frmMain.pack();
		frmMain.setLocationRelativeTo(null);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | 
                		InstantiationException | 
                		IllegalAccessException | 
                		UnsupportedLookAndFeelException e) {
                }
				
				frmMain.setVisible(true);
				
			}
		});
	}

}
