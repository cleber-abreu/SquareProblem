package global;

import java.util.ArrayList;

import model.Direction;
import model.Field;
import model.Piece;

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
	
	public void start() {
		
		pieces = new ArrayList<Piece>();
		
		fillNorthwest(fields.length-2, fields.length-2, 0, 0, fields.length, fields.length);
//		fillSoutheast(fields.length/2, fields.length/2, 0, fields.length);
//		fillNortheast(fields.length/2-2, fields.length/2+1, 0, fields.length);
//		fillSouthwest(fields.length/2+1, fields.length/2-2, 0, fields.length);
		
//		fillNorthwest(2, 10);
//		fillNortheast(0, size-1, size/2-1);
//		fillSouthwest(size/2+1, size/2-2, size/2-1);
		
	}
	
	private void fillNorthwest(int row, int col, int minRow, int minCol, int maxRow, int maxCol) {
		Field[] fieldsTmp;
		
		if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
			&& fields[row][col].notFilled()
			&& fields[row][col+1].notFilled()
			&& fields[row+1][col].notFilled()) {
		
			fields[row][col].setFill(1);
			fields[row][col+1].setFill(1);
			fields[row+1][col].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row][col+1];
			fieldsTmp[2] = fields[row+1][col];
			
			pieces.add(new Piece(fieldsTmp, Direction.NORTHWEST));
			
			row--;
			col--;
			
			if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
					&& fields[row][col].notFilled()
					&& fields[row][col+1].notFilled()
					&& fields[row+1][col].notFilled()) {
				
				fillNorthwest(row, col, minRow, minCol, maxRow, maxCol);
				fillNortheast(row, col+3, minRow, col-1, row+2, maxCol);
//				System.out.println(row+","+col+" "+minRow+"~"+maxRow+" "+minCol+"~"+maxCol);
				fillSouthwest(row+3, col, minRow, minCol, maxRow, col+2);
			}
		}
		
	}
	
	private void fillNortheast(int row, int col, int minRow, int minCol, int maxRow, int maxCol) {
		Field[] fieldsTmp;
		
		if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
				&& fields[row][col].notFilled()
				&& fields[row][col-1].notFilled()
				&& fields[row+1][col].notFilled()) {
			
			fields[row][col].setFill(1);
			fields[row][col-1].setFill(1);
			fields[row+1][col].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row][col-1];
			fieldsTmp[2] = fields[row+1][col];
			
			pieces.add(new Piece(fieldsTmp, Direction.NORTHEAST));
			
			row--;
			col++;
			
			if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
					&& fields[row][col].notFilled()
					&& fields[row][col-1].notFilled()
					&& fields[row+1][col].notFilled()) {
				
				fillNortheast(row, col, minRow, minCol, maxRow, maxCol);
				fillNorthwest(row, col-3, minRow, minCol, maxRow, maxCol);
				fillSoutheast(row+3, col, minRow, minCol, maxRow, maxCol);
			}
		}
		
	}
	
	private void fillSouthwest(int row, int col, int minRow, int minCol, int maxRow, int maxCol) {
		Field[] fieldsTmp;
		
		if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
				&& fields[row][col].notFilled()
				&& fields[row-1][col].notFilled()
				&& fields[row][col+1].notFilled()) {
			
			fields[row][col].setFill(1);
			fields[row-1][col].setFill(1);
			fields[row][col+1].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row-1][col];
			fieldsTmp[2] = fields[row][col+1];
			
			pieces.add(new Piece(fieldsTmp, Direction.SOUTHWEST));
			
			row++;
			col--;
			
			if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
					&& fields[row][col].notFilled()
					&& fields[row-1][col].notFilled()
					&& fields[row][col+1].notFilled()) {
				
				fillSouthwest(row, col, minRow, minCol, maxRow, maxCol);
				fillNorthwest(row-3, col, minRow, minCol, maxRow, maxCol);
				fillSoutheast(row, col+3, minRow, minCol, maxRow, maxCol);

			}
		}
	}
	
	private void fillSoutheast(int row, int col, int minRow, int minCol, int maxRow, int maxCol) {
		Field[] fieldsTmp;
		
		if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
				&& fields[row][col].notFilled()
				&& fields[row-1][col].notFilled()
				&& fields[row][col-1].notFilled()) {
			
			fields[row][col].setFill(1);
			fields[row-1][col].setFill(1);
			fields[row][col-1].setFill(1);
			
			fieldsTmp = new Field[3];
			fieldsTmp[0] = fields[row][col]; 
			fieldsTmp[1] = fields[row-1][col];
			fieldsTmp[2] = fields[row][col-1];
			
			pieces.add(new Piece(fieldsTmp, Direction.SOUTHEAST));
			
			row++;
			col++;

			if (row >= minRow && col >= minCol && row < maxRow && col < maxCol
					&& fields[row][col].notFilled()
					&& fields[row-1][col].notFilled()
					&& fields[row][col-1].notFilled()) {
				
				fillSoutheast(row, col, minRow, minCol, maxRow, maxCol);
				fillSouthwest(row, col-3, minRow, minCol, maxRow, maxCol);
				fillNortheast(row-3, col, minRow, minCol, maxRow, maxCol);
			}
		}
		
	}

	
	public Field[][] getFields() {
		return fields;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
}
