package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity

        //Store used by controller
    private UserPersistanceService persistanceService = new UserPersistanceService();

        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);

            Validation myUser = new Validation();

            boolean checkUser = myUser.checkUser(user);


            if(!checkUser) {
                return "ERROR";
            }

            persistanceService.saveUser(user);

            return "SUCCESS";
        }


 }

