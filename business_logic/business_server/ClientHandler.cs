using System;
using System.Text;
using System.Net.Sockets;
using Newtonsoft.Json;

namespace business_server{

    class ClientHandler{

        enum Requests : int {Login = 1, AddShift = 2, GetShiftList = 3};

        public static void handleClient(TcpClient client){
            //Initialize client connection
            bool isLoggedIn = false;
            PersistenceHandler persistenceHandler = new PersistenceHandler();
            NetworkStream stream = client.GetStream();
            System.Console.WriteLine("Client Accepted" );

            //Client communication loop
            while(client.Connected){
                //Accept a message
                try{
                    System.Console.WriteLine("LOOP");
                    byte[] bufferedClientMessage = new byte[4096];
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
                        if(validation){
                            System.Console.WriteLine("Login successful");
                            isLoggedIn = true;
                        } else {
                            System.Console.WriteLine("Invalid Credentials");
                        }
                            
                        byte message = Convert.ToByte(validation);
                        stream.WriteByte(message);
                    }

                    //ADD SHIFT Sends me json so I send it to Persistence Logic
                    else if(request == (int) Requests.AddShift && isLoggedIn){
                        var splitted = clientMessage.Split(new [] {' '});
                        String json = splitted[1];
                        //persistenceHandler.AddShift();
                        /*User user = StringUtils.GetJSONObject<User>(clientMessage) as User;
                        System.Console.WriteLine(user.username);
                        System.Console.WriteLine(user.password);*/
                    }

                    //GET SHIFT 
                    else if(request == (int) Requests.GetShiftList){
                        String listJson = "{\"shiftList\": []}";
                        byte[] jsonBytes = Encoding.ASCII.GetBytes(listJson);
                        stream.Write(jsonBytes, 0, jsonBytes.Length);
                    }

                    //Kill client connection TEMPORARILY
                    //isConnected = false;
                } 
                catch(Exception e){
                    System.Console.WriteLine(e.Message);
                }
            }
            

            //Closing communication
            System.Console.WriteLine("Closing communication with");
            stream.Close();
            client.Close();
        }
    }
}