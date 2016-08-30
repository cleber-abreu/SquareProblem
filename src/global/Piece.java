package global;

import model.Direction;

public class Piece {

	private Field[] fields;
	private Direction dir;
	
	public Piece(Field[] fields, Direction dir) {
		this.fields = fields;
		this.dir = dir;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public Field getField(int i) {
		return fields[i];
	}
	
	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}
	
}
