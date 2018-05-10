import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class NetClient {
    static Socket sock[];
    static InetAddress Serveraddr[];

    static DataInputStream datain[];
    static DataOutputStream dataout[];
    static int numServers;

    public static void main(String args[]) throws IOException{
        int i;
        DataInputStream ServerConfigFile;
        String IntString = null, Servernames[];

        ServerConfigFile = new DataInputStream(new FileInputStream("srvcfg.txt"));

        try{
            IntString = ServerConfigFile.readLine();
        }catch (IOException ioe){
            System.out.println("Error reading the # Servers");
            System.exit(1);
        }
        try{
            numServers = Integer.parseInt(IntString);
        }catch (NumberFormatException nfe){
            System.out.println("r servers is not an integer");
            System.exit(1);
        }

        Servernames = new String[numServers];
        sock = new Socket[numServers];
        Serveraddr = new InetAddress[numServers];
        datain = new DataInputStream[numServers];
        dataout = new DataOutputStream[numServers];

        for (i = 0; i < numServers; i++){
            try{
                Servernames[i] = ServerConfigFile.readLine();
            }catch (IOException ioe){
                System.out.println("Error reading server names");
                System.exit(1);
            }
            Servernames[i] = Servernames[i].trim();
        }

        try{
            ServerConfigFile.close();
        }catch (IOException ioe){
            System.out.println("Error reading server names");
            System.exit(1);
        }

        try{
            for(i = 0; i < numServers; i++){
                Serveraddr[i] = InetAddress.getByName(Servernames[i]);
                sock[i] = new Socket(Serveraddr[i],1237);
                datain[i] = new DataInputStream(new BufferedInputStream(sock[i].getInputStream()));
                dataout[i] = new DataOutputStream(new BufferedOutputStream(sock[i].getOutputStream()));
            }
        }catch (IOException ioe){
            System.out.println("I/O Error");
            System.exit(1);
        }

        ClientBody();
        try{
            for (i = 0; i < numServers; i++){
                dataout[i].close();
                datain[i].close();
                sock[i].close();
            }
        }catch (IOException e){
            System.out.println("error closing");
            System.exit(1);
        }
    }

    public static void ClientBody() throws IOException{
        int i,j,k;
        int totNum = 0,numRows = 0;
        int a[][],b[][],c[][];

        DataInputStream clientConfigfile;
        String intString = null;

        clientConfigfile = new DataInputStream(new FileInputStream("clicfg.txt"));
        try{
            intString = clientConfigfile.readLine();
        }catch (IOException ioe){
            System.exit(1);
        }
        try{
            clientConfigfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        numRows = totNum/ numServers;
        a = new int[numRows][numRows];
        b = new int[numRows][numRows];
        c = new int[numRows][numRows];

        for (i = 0; i < totNum; i++)
            for (j = 0; i < totNum; j++){
                a[i][j] = i;
                b[i][j] = j;
                c[i][j] = 0;
            }

        System.out.println("Sending information to servers");
        try{
            for (i = 0; i < numServers; i++){
                dataout[i].write(totNum);
                dataout[i].write(numRows);
                dataout[i].flush();

                for (j = )
            }
        }
    }
}
