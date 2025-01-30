import java.io.*;
import java.util.*;

public class FollowBack {
    PrintWriter out;
    TreeSet<String> following = new TreeSet<String>();
    TreeSet<String> followers = new TreeSet<String>();


    public FollowBack(String follows, String follower) throws FileNotFoundException { 
        out = new PrintWriter(new File("out.txt"));
        
        Scanner scan = new Scanner(followSpitter(follows));
        while (scan.hasNextLine()) following.add(scan.nextLine());

        
        scan = new Scanner(followSpitter(follower));
        while (scan.hasNextLine()) followers.add(scan.nextLine());
        scan.close();

        following.removeAll(followers);
    }

    public void toFile() {
        Iterator<String> it = following.iterator();
        do out.println(it.next()); while (it.hasNext());
        out.close();
    }

    public int getGhosters() {
        return following.size();
    }

    public static String followSpitter(String file) throws FileNotFoundException {
        File fi = new File(file);
        Scanner scam = new Scanner(fi);
        String out = "";
        while (scam.hasNext()) {
            String bean = scam.nextLine().trim();
            if (bean.indexOf("value") != -1) out += bean.substring(10, bean.length()-2)+"\n";
        }
        return out;
    }
}
