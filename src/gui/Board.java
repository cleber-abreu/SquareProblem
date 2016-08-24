package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class Board extends JFrame {
	
	public Board(int size) {

		JPanel pnlBoard = new JPanel();
		GridBagConstraints grid = new GridBagConstraints();
		Border border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
		Field[][] fields = new Field[size][size];
		
		pnlBoard.setLayout(new GridBagLayout());
		pnlBoard.setBackground(Color.LIGHT_GRAY);
		pnlBoard.setBorder(new MatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
		
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields.length; col++) {
				grid.gridx = col;
				grid.gridy = row;
				fields[row][col] = new Field();
				fields[row][col].setBorder(border);
				pnlBoard.add(fields[row][col], grid);
			}
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		//setBounds(100, 100, 450, 300);
//		JScrollPane scrollBar = new JScrollPane(pnlBoard, 
//				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		pnlBoard.add(scrollBar);
		add(pnlBoard, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
