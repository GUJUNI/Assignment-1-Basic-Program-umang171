import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.Buffer;

public class clientEcho {
    public static void main(String[] args) throws Exception {
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        Socket s = new Socket(server, port);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int i = 0;
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        System.out.println("Enter message for server:");
        for (i = 0; i < 50; i++) {
            str = br.readLine();
            dos.writeUTF(str);
            if (str.equals("stop"))
                break;
        }
        System.out.println("Message goes to server");
        System.out.println(i);
    }
}
