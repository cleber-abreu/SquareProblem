package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Field  extends JPanel {

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(32, 32);
	}

}