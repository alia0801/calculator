
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.*;

//new
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Button extends GridBagConstraints {
	JButton b;
	ImageIcon image;
	int food = 0;
	int firelevel;
	int clickCount=0;
	int ignite=0;
	int bomb=0;
	String content;
    //JButton b= new JButton();
	public Button() {

	}

	public Button(int newgridx, int newgridy,String id) {
		
		b= new JButton(id);
		b.setFont(new Font("Calibri",Font.ITALIC ,32));
		
		gridx = newgridx;
		gridy = newgridy;
		gridwidth = 50;
		gridheight = 50;
		weightx = 1;
		weighty = 1;
		//gridwidth = newgridwidth;
		//gridheight = newgridheight;
		//weightx = newweightx;
		//weighty = newweighty;
		//fill = newfill;
		//anchor = newanchor;
		fill =GridBagConstraints.BOTH;
	    anchor = GridBagConstraints.WEST;
	    content=new String(id);
	}
	public Button(int newgridx, int newgridy,int newgridwidth,int newgridheight,String id) {
		b= new JButton(id);
		b.setFont(new Font("Calibri",Font.ITALIC ,32));
		content=new String(id);
		gridx = newgridx;
		gridy = newgridy;
		gridwidth = newgridwidth;
		gridheight = newgridheight;
		weightx = 1;
		weighty = 1;
		fill =GridBagConstraints.BOTH;
	    anchor = GridBagConstraints.WEST;
	}
	//new
	public Button(int newgridx, int newgridy,ImageIcon icon,String id) {//for fire bomb water button
		
		image=icon;
		b=new JButton(image);
		b.setText(id);
		b.setFont(new Font("Calibri",Font.ITALIC ,32));
		gridx = newgridx;
		gridy = newgridy;
		gridwidth = 50;
		gridheight = 50;
		weightx = 1;
		weighty = 1;
		fill =GridBagConstraints.BOTH;
	    anchor = GridBagConstraints.WEST;

	}


}