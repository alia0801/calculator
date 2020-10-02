import java.util.TimerTask;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.net.URL;

public class TimeTest extends TimerTask {
	Button btn;

	public TimeTest(Button btn) {
		this.btn = btn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			btn.b.setIcon(new ImageIcon(new URL("https://pic.pimg.tw/cpw00444/1560003661-3243794495.png")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		btn.food=1;
		btn.b.setText("");
		//System.out.println("finish");

		// System.out.println("start");
	}
}