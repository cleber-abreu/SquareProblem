package global;

import java.util.ArrayList;

public class SquareProblem {
	
	private Field[][] fields;
	private ArrayList<Piece> pieces;
	
	public SquareProblem(int size) {
		fields = new Field[size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				fields[row][col] = new Field(row, col);
			}
		}
		
	}
	
	public void start(int size) {
		
		pieces = new ArrayList<Piece>();
		Field[] fieldsTmp;
		
		for (int i = 0; i < size-1; i++) {
			fields[i][i].setFill(1);
			fields[i][i+1].setFill(1);
			fields[i+1][i].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[i][i]; 
			fieldsTmp[1] = fields[i][i+1];
			fieldsTmp[2] = fields[i+1][i];
			
			pieces.add(new Piece(fieldsTmp, 0));
		}
		
		for (int row = 0, col=size-1; row < size/2-1; row++, col--) {
			fields[row][col].setFill(1);
			fields[row][col-1].setFill(1);
			fields[row+1][col].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row][col-1];
			fieldsTmp[2] = fields[row+1][col];
			
			pieces.add(new Piece(fieldsTmp, 1));
		}
		
		for (int row = size-1, col=0; col < size/2-1; row--, col++) {
			fields[row][col].setFill(1);
			fields[row-1][col].setFill(1);
			fields[row][col+1].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row-1][col];
			fieldsTmp[2] = fields[row][col+1];
			
			pieces.add(new Piece(fieldsTmp, 2));
		}
		
		
		
	}

	public Field[][] getFields() {
		return fields;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
}
