package com.example.bike_sharing.service;

import com.example.bike_sharing.domain.BikeSharingUser;
import com.example.bike_sharing.domain.BikeSharingUser.Role;

import com.example.bike_sharing.enums.UserServiceStatus;
import com.example.bike_sharing.model.UserCreate;
import com.example.bike_sharing.model.UserLogin;

import java.util.List;

public interface UserService {


    UserServiceStatus registerUser(UserCreate userRegistrationDto);
    UserServiceStatus loginUser(UserLogin userLoginDto);
    UserServiceStatus logoutUser(String token);
    BikeSharingUser fetchUserByEmail(String emailAddress);

    List<BikeSharingUser> fetchAllRegularUsers();
    List<BikeSharingUser> fetchAllServiceman();

    UserServiceStatus changeUserRole(Role role);

}
