import javax.swing.*;

public class HelloWorld 
{
	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null, "Hello " + name 
				+ ", welcome to Java!");
//		System.out.println("" + (int) (2.5 * 2.0 + 5 / 3 / 2.0 * (5 + 2.5)));
	}
}
