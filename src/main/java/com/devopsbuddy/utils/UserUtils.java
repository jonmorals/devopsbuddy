package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;

/**
 * Created by Jonathan on 11/3/2016.
 */
public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }

    public static User createBasicUser() {

        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("bu@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("2015432233");
        user.setCountry("GA");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("https://blobs.images.com/basicuser");

        return user;
    }
}
