import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebReader {
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter ID");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String n = br.readLine();
		br.close();
		//System.out.println("https://www.ecs.soton.ac.uk/people/"+n);
		URL webpage = new URL("https://www.ecs.soton.ac.uk/people/"+n);
		URLConnection conn = webpage.openConnection();
		InputStreamReader webcontent = new InputStreamReader(conn.getInputStream(), "UTF8");
		BufferedReader buffer = new BufferedReader(webcontent);
		String line="";
		for (int i = 0;i!=14;i++) {
			line = buffer.readLine();
			//System.out.println(line);
		}
		
		int endIndex = line.indexOf("/>");
		System.out.println(line.substring(35,endIndex-2));
		buffer.close();
	}
}
