/** 
 * The FollowBack class provides a means of providing the user with a file of Instagram users who do not follow the account back (given a following and following text file containing respective users).
 * @author Lauren Vu
 */
import java.util.*;

public class FollowBack {
    public static void main (String[] args) throws FileNotFoundException {
        try {
            System.out.println("instagram followback checker! for those who like to keep their following:follower ratio in check... ");
            System.out.println("NOTE! to use this, you must have pre-existing text files for both following and follower usernames.");
            PrintWriter out = new PrintWriter(new File("out.txt"));
            Scanner in = new Scanner(System.in);

            System.out.print("please input following file name: ");
            String follows = in.next();
            TreeSet<String> following = new TreeSet<String>();
            Scanner scan = new Scanner(new File(follows));
            while (scan.hasNextLine()) following.add(scan.nextLine());

            System.out.print("please input follower file name: ");
            String follower = in.next();
            in.close();
            TreeSet<String> followers = new TreeSet<String>();
            scan = new Scanner(new File(follower));
            while (scan.hasNextLine()) followers.add(scan.nextLine());
            scan.close();

            following.removeAll(followers);
            System.out.print("wow! " + following.size() + " accounts don't follow you back! ");

            Iterator<String> it = following.iterator();
            
            do out.println(it.next()); while (it.hasNext());
            out.close();

            System.out.println("accounts printed to out.txt.");
        } catch (FileNotFoundException e) {
            System.out.println("oops! file not found... run program again.");
        }
    }
}
