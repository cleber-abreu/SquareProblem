package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import global.Piece;
import global.SquareProblem;

@SuppressWarnings("serial")
public class Board extends JFrame {
	
	public Board(int size) {
		
		size = (int) Math.pow(2, size);

		JPanel pnlBoard = new JPanel();
		GridBagConstraints grid = new GridBagConstraints();
		Border border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
		Field[][] fields = new Field[size][size];
		
		pnlBoard.setLayout(new GridBagLayout());
		pnlBoard.setBackground(Color.LIGHT_GRAY);
		pnlBoard.setBorder(new MatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
		
		SquareProblem problem = new SquareProblem(size);
		problem.start(size);
		
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields.length; col++) {
				grid.gridx = col;
				grid.gridy = row;
				fields[row][col] = new Field();
				fields[row][col].setBorder(border);
				pnlBoard.add(fields[row][col], grid);
			}
		}
		
		ArrayList<Piece> pieces = problem.getPieces();
		Border[] borderPieces = new MatteBorder[3];
		
		for (Piece piece : pieces) {
			
			if (piece.getPos() == 0) {
				for (int i = 0; i < borderPieces.length; i++) {
					borderPieces[0] = new MatteBorder(1, 1, 0, 0, Color.WHITE);
					borderPieces[1] = new MatteBorder(1, 0, 1, 1, Color.WHITE);
					borderPieces[2] = new MatteBorder(0, 1, 1, 1, Color.WHITE);
				}
			}
			else if (piece.getPos() == 1) {
				borderPieces[0] = new MatteBorder(1, 0, 0, 1, Color.WHITE);
				borderPieces[1] = new MatteBorder(1, 1, 1, 0, Color.WHITE);
				borderPieces[2] = new MatteBorder(0, 1, 1, 1, Color.WHITE);
			}
			else if (piece.getPos() == 2) {
				borderPieces[0] = new MatteBorder(0, 1, 1, 0, Color.WHITE);
				borderPieces[1] = new MatteBorder(1, 1, 0, 1, Color.WHITE);
				borderPieces[2] = new MatteBorder(1, 0, 1, 1, Color.WHITE);
			}
			
			for (int i = 0; i < borderPieces.length; i++) {
				fields[piece.getField(i).getRow()][piece.getField(i).getCol()].setBackground(Color.RED);
				fields[piece.getField(i).getRow()][piece.getField(i).getCol()].setBorder(borderPieces[i]);
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
