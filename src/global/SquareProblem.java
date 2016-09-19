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
		
//		if (fields.length >= 32) {
//		
//			for (int i = 4; i < fields.length/2-2; i*=2) {
//				fillNorthwest(i-2, i-2, 0, 0, i+1, i+1);
//				fillNortheast(i-2, i+1, 0, 0, i, i*2);
//				fillSouthwest(i+1, i-2, i, 0, i*2, i);
//				fillNorthwest(i*2-2, i*2-2, i-2, i-2, i*2, i*2);
//				
////				fillSouthwest(i+1, i-2, i, i-16, i+16, i);
////				fillNorthwest(i+14, i+14, i-1, i, i+16, i+16);
//			}
//			for (int row = 4, col = fields.length-1; row < fields.length/2; row*=2, col/=2) {
//				System.out.println(row+","+col);
//				fillNortheast(row-2, col-2, 0, 0, fields.length, fields.length);
//			}
//		}
//		else {
//			fillNorthwest(fields.length-2, fields.length-2, 0, 0, fields.length, fields.length);
//		}
		
		quadrantNorthwest(fields.length-2, fields.length-2, 0, 0, fields.length, fields.length);
		
//		fillSoutheast(fields.length/2, fields.length/2, 0, fields.length);
//		fillNortheast(fields.length/2-2, fields.length/2+1, 0, fields.length);
//		fillSouthwest(fields.length/2+1, fields.length/2-2, 0, fields.length);
		
//		fillNorthwest(2, 10);
//		fillNortheast(0, size-1, size/2-1);
//		fillSouthwest(size/2+1, size/2-2, size/2-1);
		
	}
	
	private void quadrantNorthwest(int row, int col, int minRow, int minCol, int maxRow, int maxCol) {
		if ((maxRow - minRow) > 16) {
//			row = row / 2 - 2;
//			col = col / 2 - 2;
//			maxRow /= 2;
//			maxCol /= 2;
//			quadrantNorthwest(row, col, minRow, minCol, maxRow, maxCol);
			quadrantNorthwest(row/2-2, col/2-2, minRow, minCol, maxRow/2, maxCol/2);
//			quadrantNortheast(row, col+3, minRow, minCol, maxRow, maxCol*4-1);
		}
		fillNorthwest(row, col, minRow, minCol, maxRow, maxCol);
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
				fillNortheast(row, col+3, minRow, col+1, row+2, maxCol);
//				System.out.println(row+","+col+" "+minRow+"~"+maxRow+" "+minCol+"~"+maxCol);
				fillSouthwest(row+3, col, row+1, minCol, maxRow, col+2);
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
				fillNorthwest(row, col-3, minRow, minCol, row+2, col-1);
				fillSoutheast(row+3, col, row+1, col-1, maxRow, maxCol);
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
				fillSoutheast(row, col+3, row-1, col+1, maxRow, maxCol);
				fillNorthwest(row-3, col, minRow, minCol, row-1, col+2);

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
				fillSouthwest(row, col-3, row-1, minCol, maxRow, col-1);
				fillNortheast(row-3, col, minRow, col-1, row-1, maxCol);
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
