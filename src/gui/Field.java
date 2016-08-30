package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Field  extends JPanel {
	
	private static Dimension dim;

	@Override
	public Dimension getPreferredSize() {
		return dim;
	}

	public static void setDim(int size) {
		dim = new Dimension(size, size);
	}

	public static Dimension getDim() {
		return dim;
	}

	public static void setDim(Dimension dim) {
		Field.dim = dim;
	}
	
	
}