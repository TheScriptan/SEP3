using System;
using Newtonsoft.Json;

namespace business_server{

    class StringUtils{
        //Helps find first int in client request message where 1st symbol is integer that defines message type
        public static int FindFirstInt(String str){
            var splitted = str.Split(new [] {' '});
            int i = Int32.Parse(splitted[0]);
            return i;
        }

        //Converts Login Request Message into splitted variables like username, password for sending it to persistence handler
        public static void ConvertLoginCredentials(String str, ref String username, ref String password){
            var splitted = str.Split(new[] {' '});
            username = splitted[1];
            password = splitted[2];
        }

        public static Object GetJSONObject<T>(String str){
            var splitted = str.Split(new [] {' '});
            String json = splitted[1];
            Object obj = JsonConvert.DeserializeObject<T>(json);
            return obj;
        }
    }
}