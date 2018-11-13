using System;
using System.Text;
using System.Net.Sockets;
using Newtonsoft.Json;

namespace business_server{

    class ClientHandler{

        enum Requests : int {Login = 1, AddShift = 2};

        public static void handleClient(TcpClient client){
            //Initialize client connection
            bool isConnected = true;
            bool isLoggedIn = false;
            PersistenceHandler persistenceHandler = new PersistenceHandler();
            NetworkStream stream = client.GetStream();
            System.Console.WriteLine("Client Accepted" );

            //Client communication loop
            while(isConnected){
                //Accept a message
                byte[] bufferedClientMessage = new byte[1024];
                int bytesRead = stream.Read(bufferedClientMessage, 0, bufferedClientMessage.Length);
                String clientMessage = Encoding.ASCII.GetString(bufferedClientMessage, 0, bytesRead);

                //Determine the client request
                int request = StringUtils.FindFirstInt(clientMessage);
                //LOGIN Request
                if(request == (int) Requests.Login){
                    String username = "";
                    String password = "";
                    StringUtils.ConvertLoginCredentials(clientMessage, ref username, ref password);
                    bool validation = persistenceHandler.CheckIfValidCredentials(username, password);
                    if(validation) 
                        isLoggedIn = true;
                    byte message = Convert.ToByte(validation);
                    stream.WriteByte(message);
                }

                //ADD SHIFT
                else if(request == (int) Requests.AddShift && isLoggedIn){
                    System.Console.WriteLine(clientMessage);
                    User user = StringUtils.GetJSONObject<User>(clientMessage) as User;
                    System.Console.WriteLine(user.username);
                    System.Console.WriteLine(user.password);
                }

                //Kill client connection TEMPORARILY
                isConnected = false;
            }
            

            //Closing communication
            System.Console.WriteLine("Closing communication with");
            stream.Close();
            client.Close();
        }
    }
}