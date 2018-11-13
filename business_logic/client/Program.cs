using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

namespace client
{
    class Program
    {
        static void Main(string[] args)
        {
            String test = "1, ainis skominas";
            System.Console.WriteLine(test.Substring(0, 1));
            String adr = "127.0.0.1";
            try{
                TcpClient client = new TcpClient(adr, 5000);

                //Connect to end point
                System.Console.WriteLine("Connecting to server...");
                NetworkStream stream = client.GetStream();

                //Sending a message
                System.Console.Write("Enter a message: ");
                String message = Console.ReadLine();
                byte[] abyString = Encoding.ASCII.GetBytes(message);
                stream.Write(abyString, 0, abyString.Length);
                System.Console.WriteLine("Message sent");
                int login = stream.ReadByte();
                if(login == 1)
                    System.Console.WriteLine("Login successful!");
                else System.Console.WriteLine("Invalid Credentials");

                

                //Closing connection
                System.Console.WriteLine("Closing connection to server...");
                stream.Close();
                client.Close();
            } catch(Exception e){
                System.Console.WriteLine(e.StackTrace);
                System.Console.WriteLine(e.Message);
            }
        }
    }
}
