using System;
using System.Collections.Generic;

namespace business_server{
    
    
    class PersistenceHandler{
        List<User> userList = new List<User>();

        public PersistenceHandler(){
            userList.Add(new User("ainis", "skominas"));
            userList.Add(new User("jonas", "tomas"));
        }

        //Checks if client login credentials are existing in database. For now in Dummy persistence List
        public Boolean CheckIfValidCredentials(String username, String password){
            for(int i = 0; i < userList.Count; i++){
                if(userList[i].username.Equals(username) && userList[i].password.Equals(password)){
                    return true;
                }
            }
            return false;
        }
    }
}