package global;

public class Piece {

	private Field[] fields;
	private int pos;

	public Piece(Field[] fields, int position) {
		this.fields = fields;
		pos = position;
	}
	
	public int getPos() {
		return pos;
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
