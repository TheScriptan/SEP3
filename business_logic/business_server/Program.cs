using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace business_server
{
    class Program
    {
        static void Main(string[] args)
        {
            //Server initialization
            byte[] adr = {127, 0, 0, 1};
            IPAddress ipAdr = new IPAddress(adr);
            TcpListener listener = new TcpListener(ipAdr, 5000);
            listener.Start();

            //Continuos wait for client connection
            while(true){
                System.Console.WriteLine("Waiting for client connection...");
                TcpClient client = listener.AcceptTcpClient();
                Thread clientThread = new Thread(() => ClientHandler.handleClient(client));
                clientThread.Start();
            }
        }
    }
}
