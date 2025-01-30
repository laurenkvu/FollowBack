import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;

public class FollowBackViewer
{
	/** Dimensions of frame */
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String[] be = {"instructions for extracting .json files please...", "i have my files!"};
		String msg = "instagram followback checker! for those who like to keep their following:follower ratio in check...\nNOTE! to use this, you must have the pre-existing .json files from instagram for both following and follower usernames.";
		// JOptionPane.showMessageDialog(null, "instagram followback checker! for those who like to keep their following:follower ratio in check...\nNOTE! to use this, you must have the pre-existing .json files from instagram for both following and follower usernames.");
		int option = JOptionPane.showOptionDialog(null, msg, "FollowBack", 2, 3, null, be, 0);
		if (option == 0) {
			JOptionPane.showMessageDialog(null, 
			"ok! follow these steps on your desktop:\ngo to this link: https://accountscenter.instagram.com/info_and_permissions/ (no you won't get a virus trustmebro)\nclick on \"Download your information\", then \"Download or transfer information\"\nselect the account(s) you want to use, and hit next\nselect \"Some of your information\", then scroll down click \"Followers and following\" under the \"Connections\" category, and hit next\nclick \"Download to device\"\nin the \"Data range\" and \"Format\" drop-downs that follow , select the \"All Time\" and \"JSON\" options and hit save on both. the other two drop-downs are irrelevant.\nhit \"Create Files\" and you wait!");
	}

		String following = getString(
				"Enter following file name:");
		String followers = getString(
				"Enter follower file name:");
		
		FollowBack ig = new FollowBack(following, followers);
				JOptionPane.showMessageDialog(null, 
				"wow! " + ig.getGhosters() + " accounts don't follow you back!\naccounts printed to the file 'out.txt'.");
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("FollowBack");
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/** Retrieve a valid file from the user with a given prompt
	 *  @param prompt the request to be given to the user
	 *  @return an integer
	 */
	public static String getString(String prompt) 
	{
		String in;
		while (true) 
		{
			try 
			{
				in = JOptionPane.showInputDialog(null, prompt);
				if (new File(in).exists()) return in;
				else throw new FileNotFoundException();
			} 
			catch (FileNotFoundException e) 
			{
				JOptionPane.showMessageDialog(null, "File not found. Please make sure you enter the EXACT file name (extension included).");
			}
		}
	}
}
