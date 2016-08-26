package global;

public class Field {
	
	private int row;
	private int col;
	private int fill;

	public Field(int row, int col, int fill) {
		this.row = row;
		this.col = col;
		this.fill = fill;
	}

	public Field(int row, int col) {
		this.row = row;
		this.col = col;
		this.fill = 0;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getFill() {
		return fill;
	}
	
	public void setFill(int fill) {
		this.fill = fill;
	}
	
}
