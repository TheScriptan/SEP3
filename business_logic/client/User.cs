using System;

namespace client{

    //Temporary class for handling dummy Persistence Database
    class User{
        public String username {get; set;}
        public String password {get; set;}

        public User(String username, String password){
            this.username = username;
            this.password = password;
        }
    }
}