package tomaszjanik98.com.stazapplication;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UsernameTest {


    @Test
    public void username_correct(){
        assertTrue(UsernameValidator.isValidUsername("username"));
    }

    @Test
    public void username_empty(){
        assertFalse(UsernameValidator.isValidUsername(""));
    }

    @Test
    public void username_null(){
        assertFalse(UsernameValidator.isValidUsername(null));
    }
}


