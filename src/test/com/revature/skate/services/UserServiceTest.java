package com.revature.skate.services;

import com.revature.skate.daos.UserDAO;
import com.revature.skate.util.custom_exceptions.InvalidUserException;

//import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService user = new UserService(new UserDAO());

    @Test
    void isValidUsername() {
        assertEquals(true, user.isValidUsername("paytondavis"));
        assertEquals(true, user.isValidUsername("abcdefghijklmnop"));
        assertEquals(true, user.isValidUsername("123456789"));
        assertEquals(true, user.isValidUsername("doglover123"));
        assertThrows(InvalidUserException.class, () -> {user.isValidUsername("payton");});
        assertThrows(InvalidUserException.class, () -> {user.isValidUsername("abcdefghijklmnopqrstuvwxyz");});
    }

    @Test
    void isValidPassword() {
        assertEquals(true, user.isValidPassword("Hockey34$"));
        assertEquals(true, user.isValidPassword("Password%78"));
        assertEquals(true, user.isValidPassword("%%%%%%%%Wa4"));
        assertEquals(true, user.isValidPassword("343434@@@@@@WWWWpp"));
        assertThrows(InvalidUserException.class, () -> {user.isValidPassword("payton");});
        assertThrows(InvalidUserException.class, () -> {user.isValidPassword("Dogs1#");});
        assertThrows(InvalidUserException.class, () -> {user.isValidPassword("Password87");});
    }

    @Test
    public void isDuplicateUsername_willThrowExceptionIfThereIsADupUsername() {
        String username = "paytondavis";
        boolean isTrue = user.isNotDuplicate(username);
        assertTrue(isTrue);
    }
    @Test
    void register(){
        assertNotNull(user);
    }

}