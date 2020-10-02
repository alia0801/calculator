import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class TextField extends GridBagConstraints {
	JTextField text = new JTextField("");
	String process = "";

	public TextField() {
		
		text.setFont(new Font("Calibri",Font.ITALIC ,32) ) ;
		gridx = 0;
		gridy = 0;
		gridwidth = 200;
		gridheight = 50;
		weightx = 1;
		weighty = 1;
		fill = GridBagConstraints.BOTH;
		anchor = GridBagConstraints.WEST;

	}
}
