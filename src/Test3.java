import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.text.DecimalFormat;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.net.URL;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.applet.AudioClip;
import java.applet.Applet;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Timer;

public class Test3 extends JFrame implements ActionListener {

	private String[] ans = new String[1000000];
	private String[] operator = new String[10000];
	private int numbers = 0;// the amount of the number we key in that are waiting for calculating
	private int ope_num = 0;// the amount of operator
	private double answer = 0;// the final answer
	private Button bag_equal, bag_C, bag_Del, bag_Add, bag_Sub, bag_Time, bag_Div, bag_Sig, bag_Deci;
	private Button bag_0, bag_1, bag_2, bag_3, bag_4, bag_5, bag_6, bag_7, bag_8, bag_9;
	private TextField bag_text;
	// newButton
	private Button bag_Fire, bag_Bomb, bag_Water, bag_Meat;
	public static final int SMALL_WIDTH = 400;
	public static final int SMALL_HEIGHT = 250;
	//int control = 0;
	private int burnMode = 0;

	public Test3() {
		super("閮���");// JFrame's construcor
		// 600,600 to 800,800
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		int x = 50;
		int y = 50;

		bag_text = new TextField();
		bag_text.text = new JTextField("");
		bag_text.text.setFont(new Font("Calibri", Font.ITALIC, 32));
		add(bag_text.text, bag_text);// this represents GUI

		bag_equal = new Button(0, 5 * y, 2 * x, y, "=");
		add(bag_equal.b, bag_equal);
		bag_equal.b.addActionListener(this);

		bag_C = new Button(x, y, 2 * x, y, "C");
		add(bag_C.b, bag_C);
		bag_C.b.addActionListener(this);

		bag_Del = new Button(3 * x, y, "Del");
		add(bag_Del.b, bag_Del);
		bag_Del.b.addActionListener(this);

		bag_Add = new Button(0, 1 * y, "+");
		add(bag_Add.b, bag_Add);
		bag_Add.b.addActionListener(this);

		bag_7 = new Button(x, 2 * y, "7");
		add(bag_7.b, bag_7);
		bag_7.b.addActionListener(this);

		bag_8 = new Button(2 * x, 2 * y, "8");
		add(bag_8.b, bag_8);
		bag_8.b.addActionListener(this);

		bag_9 = new Button(3 * x, 2 * y, "9");
		add(bag_9.b, bag_9);
		bag_9.b.addActionListener(this);

		bag_Sub = new Button(0, 2 * y, "-");
		add(bag_Sub.b, bag_Sub);
		bag_Sub.b.addActionListener(this);

		bag_4 = new Button(x, 3 * y, "4");
		add(bag_4.b, bag_4);
		bag_4.b.addActionListener(this);

		bag_5 = new Button(2 * x, 3 * y, "5");
		add(bag_5.b, bag_5);
		bag_5.b.addActionListener(this);

		bag_6 = new Button(3 * x, 3 * y, "6");
		add(bag_6.b, bag_6);
		bag_6.b.addActionListener(this);

		bag_Time = new Button(0, 3 * y, "*");
		add(bag_Time.b, bag_Time);
		bag_Time.b.addActionListener(this);

		bag_1 = new Button(x, 4 * y, "1");
		add(bag_1.b, bag_1);
		bag_1.b.addActionListener(this);

		bag_2 = new Button(2 * x, 4 * y, "2");
		add(bag_2.b, bag_2);
		bag_2.b.addActionListener(this);

		bag_3 = new Button(3 * x, 4 * y, "3");
		add(bag_3.b, bag_3);
		bag_3.b.addActionListener(this);

		bag_Div = new Button(0, 4 * y, "/");
		add(bag_Div.b, bag_Div);
		bag_Div.b.addActionListener(this);

		bag_0 = new Button(2 * x, 5 * y, "0");
		add(bag_0.b, bag_0);
		bag_0.b.addActionListener(this);

		bag_Deci = new Button(3 * x, 5 * y, ".");
		add(bag_Deci.b, bag_Deci);
		bag_Deci.b.addActionListener(this);

		// new add
		try {
			ImageIcon iconFire = new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559966730-1546507518.gif"));

			bag_Fire = new Button(0, 6 * y, iconFire, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(bag_Fire.b, bag_Fire);
		bag_Fire.b.addActionListener(this);

		try {
			ImageIcon iconBomb = new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559970908-2934651104.png"));
			bag_Bomb = new Button(1 * x, 6 * y, iconBomb, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(bag_Bomb.b, bag_Bomb);
		bag_Bomb.b.addActionListener(this);

		try {
			ImageIcon iconWater = new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559967826-1053975745.gif"));
			bag_Water = new Button(2 * x, 6 * y, iconWater, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(bag_Water.b, bag_Water);
		bag_Water.b.addActionListener(this);

		try {
			ImageIcon iconMeat = new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560004539-4239002879.png"));
			bag_Meat = new Button(3 * x, 6 * y, iconMeat, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(bag_Meat.b, bag_Meat);
		bag_Meat.b.addActionListener(this);

		addMouseListener(new MouseListener() { // �閬�憓���辣���
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == e.BUTTON3) {

					setCursor(Cursor.getDefaultCursor());
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (getMode() == 0) {

			if (e.getSource() == bag_1.b) {
				Music Do = new Music("Do");
				Do.play();
				numIn(1);
			}
			else if (e.getSource() == bag_0.b) {
				numIn(0);
			} else if (e.getSource() == bag_2.b) {
				Music Re = new Music("Re");
				Re.play();
				numIn(2);
			}
			else if (e.getSource() == bag_3.b){
				Music Mi = new Music("Mi");
				Mi.play();
				numIn(3);
			}
			else if (e.getSource() == bag_4.b){
				Music Fa = new Music("Fa");
				Fa.play();
				numIn(4);
			}
			else if (e.getSource() == bag_5.b){
				Music Sol = new Music("Sol");
				Sol.play();
				numIn(5);
			}
			else if (e.getSource() == bag_6.b){
				Music La = new Music("La");
				La.play();
				numIn(6);
			}
				
			else if (e.getSource() == bag_7.b){
				Music Si = new Music("Si");
				Si.play();
				numIn(7);
			}
			else if (e.getSource() == bag_8.b) {
				Music Do_1 = new Music("Do_1");
				Do_1.play();
				numIn(8);
			}
			else if (e.getSource() == bag_9.b)
				numIn(9);
			else if (e.getSource() == bag_Add.b) {
				if (ans[numbers] == null) {
					signIn("+");
				} else {
					opeIn("+");
				}

			} else if (e.getSource() == bag_Sub.b) {
				if (ans[numbers] == null) {
					signIn("-");
				} else {
					opeIn("-");
				}
			} else if (e.getSource() == bag_Time.b)
				opeIn("*");
			else if (e.getSource() == bag_Div.b)
				opeIn("/");
			else if (e.getSource() == bag_equal.b)
				opeIn("=");
			else if (e.getSource() == bag_Deci.b)
				deciIn(".");
			else if (e.getSource() == bag_C.b)
				Clear();
			else if (e.getSource() == bag_Del.b)
				Delete();
			else if (e.getSource() == bag_Fire.b) {
				setMode(1);
				new Sound(1);
			}
				
			else if (e.getSource() == bag_Bomb.b)
				setMode(2);

			else if (e.getSource() == bag_Water.b) {
				setMode(3);
				new Sound(3);
			}
				
			else if (e.getSource() == bag_Meat.b) {
				setMode(4);// BBQing
			}

		} else {
			if (getMode() == 1) {// in burn mode
				if (e.getSource() == bag_Fire.b) {// reset to original
					setMode(0);
				} else if (e.getSource() == bag_Bomb.b) {// chanege into bomb mode
					setMode(2);
				} else if (e.getSource() == bag_Water.b) {// change into water mode
					setMode(3);
					new Sound(3);
				} else if (e.getSource() == bag_Meat.b) {
					setMode(4);
				} else if (e.getSource() == bag_Del.b) {
					if (bag_Del.bomb == 0) {
						
						bag_Del.clickCount++;
						fireLevel(bag_Del, bag_Del.clickCount);
					} else if (bag_Del.bomb == 1) {
						fireBomb(bag_Del);
					}
				} else if (e.getSource() == bag_0.b) {
					if (bag_0.bomb == 0) {// if there is no bomb on the button
						bag_0.clickCount++;
						fireLevel(bag_0, bag_0.clickCount);
					} else if (bag_0.bomb == 1) {
						fireBomb(bag_0);
					}
				} else if (e.getSource() == bag_1.b) {
					if (bag_1.bomb == 0) {
						bag_1.clickCount++;
						fireLevel(bag_1, bag_1.clickCount);
					} else if (bag_1.bomb == 1) {
						fireBomb(bag_1);
					}
				} else if (e.getSource() == bag_2.b) {
					if (bag_2.bomb == 0) {
						bag_2.clickCount++;
						fireLevel(bag_2, bag_2.clickCount);
					} else if (bag_2.bomb == 1) {
						fireBomb(bag_2);
					}
				} else if (e.getSource() == bag_3.b) {
					if (bag_3.bomb == 0) {
						bag_3.clickCount++;
						fireLevel(bag_3, bag_3.clickCount);
					} else if (bag_3.bomb == 1) {
						fireBomb(bag_3);
					}
				} else if (e.getSource() == bag_4.b) {
					if (bag_4.bomb == 0) {
						bag_4.clickCount++;
						fireLevel(bag_4, bag_4.clickCount);
					} else if (bag_4.bomb == 1) {
						fireBomb(bag_4);
					}
				} else if (e.getSource() == bag_5.b) {
					if (bag_5.bomb == 0) {
						bag_5.clickCount++;
						fireLevel(bag_5, bag_5.clickCount);
					} else if (bag_5.bomb == 1) {
						fireBomb(bag_5);
					}
				} else if (e.getSource() == bag_6.b) {
					if (bag_6.bomb == 0) {
						bag_6.clickCount++;
						fireLevel(bag_6, bag_6.clickCount);
					} else if (bag_6.bomb == 1) {
						fireBomb(bag_6);
					}
				} else if (e.getSource() == bag_7.b) {
					if (bag_7.bomb == 0) {
						bag_7.clickCount++;
						fireLevel(bag_7, bag_7.clickCount);
					} else if (bag_7.bomb == 1) {
						fireBomb(bag_7);
					}
				} else if (e.getSource() == bag_8.b) {
					if (bag_8.bomb == 0) {
						bag_8.clickCount++;
						fireLevel(bag_8, bag_8.clickCount);
					} else if (bag_8.bomb == 1) {
						fireBomb(bag_8);
					}
				} else if (e.getSource() == bag_9.b) {
					if (bag_9.bomb == 0) {
						bag_9.clickCount++;
						fireLevel(bag_9, bag_9.clickCount);
					} else if (bag_9.bomb == 1) {
						fireBomb(bag_9);
					}
				} else if (e.getSource() == bag_Add.b) {
					if (bag_Add.bomb == 0) {
						bag_Add.clickCount++;
						fireLevel(bag_Add, bag_Add.clickCount);
					} else if (bag_Add.bomb == 1) {
						fireBomb(bag_Add);
					}
				} else if (e.getSource() == bag_Sub.b) {
					if (bag_Sub.bomb == 0) {
						bag_Sub.clickCount++;
						fireLevel(bag_Sub, bag_Sub.clickCount);
					} else if (bag_Sub.bomb == 1) {
						fireBomb(bag_Sub);
					}
				} else if (e.getSource() == bag_Div.b) {
					if (bag_Div.bomb == 0) {
						bag_Div.clickCount++;
						fireLevel(bag_Div, bag_Div.clickCount);
					} else if (bag_Div.bomb == 1) {
						fireBomb(bag_Div);
					}
				} else if (e.getSource() == bag_Time.b) {
					if (bag_Time.bomb == 0) {
						bag_Time.clickCount++;
						fireLevel(bag_Time, bag_Time.clickCount);
					} else if (bag_Time.bomb == 1) {
						fireBomb(bag_Time);
					}
				} else if (e.getSource() == bag_Deci.b) {
					if (bag_Deci.bomb == 0) {
						bag_Deci.clickCount++;
						fireLevel(bag_Deci, bag_Deci.clickCount);
					} else if (bag_Deci.bomb == 1) {
						fireBomb(bag_Deci);
					}
				}
			} else if (getMode() == 2) {
				if (e.getSource() == bag_Bomb.b) {					
					setMode(0);
				} else if (e.getSource() == bag_Water.b) {
					setMode(3);
				} else if (e.getSource() == bag_Fire.b) {
					setMode(1);
				} else if (e.getSource() == bag_Meat.b) {
					setMode(4);
				} else if (e.getSource() == bag_0.b) {
					putBomb(bag_0);
				} else if (e.getSource() == bag_1.b) {
					putBomb(bag_1);
				}
			} else if (getMode() == 3) {
				if (e.getSource() == bag_Water.b) {
					setMode(0);
				} else if (e.getSource() == bag_Bomb.b) {
					setMode(2);
				} else if (e.getSource() == bag_Fire.b) {
					setMode(1);
				} else if (e.getSource() == bag_Meat.b) {
					setMode(4);
				} else if (e.getSource() == bag_0.b) {
					// if (bag_0.clickCount > 0) {// on fire
					--bag_0.clickCount;
					fireLevel(bag_0, (bag_0.clickCount));// reduce the level of fire
					//System.out.println(bag_0.clickCount);
					// }else {

					// }
				} else if (e.getSource() == bag_1.b) {
					//if (bag_1.clickCount > 0) {// on fire
						fireLevel(bag_1, (--bag_1.clickCount));// reduce the level of fire
					//}
				}
			} else if (getMode() == 4) {
				long roast_time = 8000;
				Timer t = new Timer();
				if (e.getSource() == bag_Meat.b)
					setMode(0);
				else if (e.getSource() == bag_Fire.b) {
					setMode(1);
				} else if (e.getSource() == bag_Bomb.b) {
					setMode(2);
				} else if (e.getSource() == bag_Water.b) {
					setMode(3);
				} else {// ready to BBQ
					if (e.getSource() == bag_0.b) {
						try {
							bag_0.b.setIcon(
									new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560003661-2630803586.gif")));
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						t.schedule(new TimeTest(bag_0), roast_time / bag_0.clickCount);
					} else if (e.getSource() == bag_1.b) {
						try {
							bag_1.b.setIcon(
									new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560003661-2630803586.gif")));
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						t.schedule(new TimeTest(bag_1), roast_time / bag_1.clickCount);

					} else if (e.getSource() == bag_2.b) {
						try {
							bag_2.b.setIcon(
									new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560003661-2630803586.gif")));
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						t.schedule(new TimeTest(bag_2), roast_time / bag_2.clickCount);
					}

				}
			}
		}
	}

	public void fireBomb(Button btn) {// change btn icon when bomb is fired
		btn.ignite = 1;
		btn.b.setText("");
		switch (btn.content) {
		case "0":
			try {
				new Sound(2);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560050932-1442226465.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "1":
			try {
				new Sound(2);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560050939-2145355573.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public void setMode(int mode) {
		burnMode = mode;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if (mode == 0) {
			Cursor cu = new Cursor(Cursor.DEFAULT_CURSOR);
			setCursor(cu);
		} else if (mode == 1) {
			try {
				Image i1 = toolkit.getImage(new URL("https://pic.pimg.tw/cpw00444/1559967867-3502217962.png"));
				Cursor c1 = toolkit.createCustomCursor(i1, new Point(0, 0), "");
				setCursor(c1);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (mode == 2) {
			try {
				Image i1 = toolkit.getImage(new URL("https://pic.pimg.tw/cpw00444/1559970908-2934651104.png"));
				Cursor c1 = toolkit.createCustomCursor(i1, new Point(0, 0), "");
				setCursor(c1);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (mode == 3) {
			try {
				Image i1 = toolkit.getImage(new URL("https://pic.pimg.tw/cpw00444/1559967841-3792721794.png"));
				Cursor c1 = toolkit.createCustomCursor(i1, new Point(0, 0), "");
				setCursor(c1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (mode == 4) {
			System.out.println(4);
			try {
				Image i1 = toolkit.getImage(new URL("https://pic.pimg.tw/cpw00444/1560004539-4239002879.png"));
				Cursor c1 = toolkit.createCustomCursor(i1, new Point(0, 0), "");
				setCursor(c1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (mode == 5) {
			System.out.println("finish");
		}
		System.out.println("mode:" + burnMode);
	}

	public int getMode() {
		return burnMode;
	}

	public void fireLevel(Button btn, int level) {
		btn.b.setText("");
		// btn.b.getText();
		btn.firelevel = level;
		switch (level) {
		case -4:
			new Sound(3);
			btn.b.setIcon(null);
			btn.b.setText("wasted!");
			break;
		case -3:
			try {
				new Sound(3);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560050079-2186390575.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case -2:
			try {
				new Sound(3);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559967826-1053975745.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case -1:
			try {
				new Sound(3);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560050239-4213471693.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}break;
		case 1:
			// btn.firelevel = 1;
			try {
				new Sound(1);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559971185-4231137559.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// btn.b.setIcon(new ImageIcon("d:\\fire65%.gif"));
			break;
		case 2:
			// btn.firelevel = 2;
			try {
				new Sound(1);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559966730-1546507518.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// btn.b.setIcon(new ImageIcon("d:\\newfire1.gif"));
			break;
		case 3:
			// btn.firelevel = 3;
			try {
				new Sound(1);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559971229-2121803134.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// btn.b.setIcon(new ImageIcon("d:\\fire135%.gif"));
			break;
		case 4:
			// btn.firelevel = 4;
			try {
				new Sound(1);
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559971390-1545771208.gif")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// btn.b.setIcon(new ImageIcon("d:\\fire300%.gif"));
			break;
		default: {// you can find other rule
//			btn.firelevel = 0;
//			btn.b.setText(btn.content);
//			btn.b.getText();
//			btn.b.setIcon(null);
//			btn.clickCount = 0;
			reset(btn);
		}
		}

	}

	public void reset(Button btn) {
		btn.firelevel = 0;
		btn.b.setText(btn.content);
		btn.b.getText();
		btn.b.setIcon(null);
		btn.clickCount = 0;
		System.out.println("reset");
	}

	public void putBomb(Button btn) {
		if (btn.clickCount < 1) {
			try {
				btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1559970908-2934651104.png")));
				btn.bomb = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			fireBomb(btn);
		}
	}

	private class CheckOnExit implements WindowListener {
		public void windowOpened(WindowEvent e) {

		}

		public void windowClosing(WindowEvent e) {
			ConfirmWindow checkers = new ConfirmWindow();
			checkers.setVisible(true);
		}

		public void windowClosed(WindowEvent e) {

		}

		public void windowIconified(WindowEvent e) {

		}

		public void windowDeiconified(WindowEvent e) {

		}

		public void windowActivated(WindowEvent e) {

		}

		public void windowDeactivated(WindowEvent e) {

		}
	}

	public void sound() {
//	   try{
//		   InputStream in = new FileInputStream("d:\\water.wav");
//		   AudioStream as = new AudioStream(in);
//		   AudioPlayer.player.start(as);
//		   //AudioPlayer.player.stop(as);
//		   }catch(FileNotFoundException e){
//		   }
//		   catch(IOException e){
//		   }

	}

	private class ConfirmWindow extends JFrame implements ActionListener {
		public ConfirmWindow() {
			this.setTitle("嚙確嚙緹");
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setLayout(null);
			JLabel confirmLabel = new JLabel("Are you sure you want to exit?");
			confirmLabel.setLocation(0, 0);
			confirmLabel.setSize(400, 150);
			confirmLabel.setFont(new Font("Calibri", Font.ITALIC, 28));
			this.add(confirmLabel);

			JButton exitButton = new JButton("Yes");
			exitButton.setLocation(0, 150);
			exitButton.setSize(200, 50);
			exitButton.addActionListener(this);
			exitButton.setFont(new Font("Calibri", Font.ITALIC, 18));
			this.add(exitButton);

			JButton cancelButton = new JButton("No");
			cancelButton.setLocation(200, 150);
			cancelButton.setSize(200, 50);
			cancelButton.addActionListener(this);
			cancelButton.setFont(new Font("Calibri", Font.ITALIC, 18));
			this.add(cancelButton);
		}

		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			if (actionCommand.equals("Yes"))
				System.exit(0);
			else if (actionCommand.equals("No"))
				dispose();
			else
				System.out.println("Unexcepted Error in ConfirWindow.");
		}
	}

	public void numIn(int i) {

		if (i == 10 && bag_text.text.getText().equals(""))
			bag_text.text.setText("");

		else {
			if (ans[numbers] == null)
				ans[numbers] = Integer.toString(i);
			else
				ans[numbers] += Integer.toString(i);

			bag_text.text.setText(bag_text.process + ans[numbers]);

		}

	}

	public void signIn(String sg) {
		if (sg.equals("-"))
			ans[numbers] = "-";
		else {
			ans[numbers] = "+";
		}
		bag_text.text.setText(bag_text.process + ans[numbers]);
	}

	public void deciIn(String point) {
		if (point == ".") {
			ans[numbers] += ".";
			bag_text.text.setText(bag_text.process + ans[numbers]);
		}
	}

	public void Delete() {
		if (!bag_text.text.getText().equals("")) {
			String del = bag_text.text.getText().substring(bag_text.text.getText().length() - 1);
			if (bag_text.text.getText().length() == 1) {
				Clear();
			} else {
				if (del.equals("+") || del.equals("-") || del.equals("*") || del.equals("/")) {
					bag_text.process = bag_text.process.substring(0, bag_text.process.length() - 1);
					operator[ope_num--] = "";
					ans[numbers] = "";
					numbers--;
					bag_text.process = bag_text.process.substring(0, bag_text.process.length() - ans[numbers].length());
					bag_text.text.setText(bag_text.process + ans[numbers]);
				} else {

					if (ans[numbers].length() != 1) {
						ans[numbers] = ans[numbers].substring(0, ans[numbers].length() - 1);
						bag_text.text.setText(bag_text.process + ans[numbers]);
					} else {
						ans[numbers] = "";
						bag_text.text.setText(bag_text.process);
					}

				}
			}
		}
	}

	public void Clear() {
		ans = new String[1000000];
		operator = new String[10000];
		numbers = 0;// the amount of the number we key in that are waiting for calculating
		ope_num = 0;// the amount of operator
		answer = 0;
		bag_text.process = "";
		bag_text.text.setText("");
	}

	public void opeIn(String ope) {
		numbers++;// move to next ans[]
		String current = bag_text.text.getText();
		bag_text.process = current + ope;

		if (ope.equals("+")) {
			operator[ope_num++] = "+";
			bag_text.text.setText(bag_text.process);
		} else if (ope.equals("-")) {
			operator[ope_num++] = "-";
			bag_text.text.setText(bag_text.process);
		} else if (ope.equals("*")) {
			operator[ope_num++] = "*";
			bag_text.text.setText(bag_text.process);
		} else if (ope.equals("/")) {
			operator[ope_num++] = "/";
			bag_text.text.setText(bag_text.process);
		} else if (ope.equals("=")) {

			for (int i = 0; i < ope_num; i++) {
				if (operator[i].equals("*")) {
					double mul1 = Double.valueOf(ans[i]);
					double mul2 = Double.valueOf(ans[i + 1]);

					double temp = mul1 * mul2;

					ans[i] = "0";
					ans[i + 1] = Double.toString(temp);
					// why we use above assignment method
					// because we consider if there are continuous multiplication or division

					if (i > 0 && operator[i - 1].equals("-"))
						operator[i] = "-";// remember it is still in subtraction
					else
						operator[i] = "+";

				} else if (operator[i].equals("/")) {
					double div1 = Double.valueOf(ans[i]);
					double div2 = Double.valueOf(ans[i + 1]);
					double temp = div1 / div2;
					ans[i] = "0";
					ans[i + 1] = Double.toString(temp);
					if (i > 0 && operator[i - 1].equals("-")) {

						operator[i] = "-";
					} else
						operator[i] = "+";
				}
			}

			answer = Double.valueOf(ans[0]);// give the first number which in the ans array to answer

			// when run into "+" answer += the number in ans[],vice versa
			for (int i = 0; i < ope_num; i++) {

				if (operator[i].equals("+")) {

					answer += Double.valueOf(ans[i + 1]);

				} else if (operator[i] == "-") {

					answer -= Double.valueOf(ans[i + 1]);
				}

			}
			if (answer > 1000) {

				System.out.println(111);
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				try {
					Image i1 = toolkit.getImage("d:\\wedcrab.png");
					Cursor c1 = toolkit.createCustomCursor(i1, new Point(0, 0), "");
					setCursor(c1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// control the print format by using DecimalFormat
			DecimalFormat output = new DecimalFormat("#.#####");
			System.out.println(output.format(answer));
			bag_text.text.setText(output.format(answer));
			String tmp = output.format(answer);

			// Finally , reset the state of calculator
			Clear();
			bag_text.text.setText(tmp);
			ans[0] = tmp;

		}
	}
}