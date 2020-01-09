package pl.gardziel;

import org.junit.jupiter.api.Test;
public class AccountTest {

    @Test
    public void myTest () {

        Account newAccount = new Account();
        assertFalse(newAccount.isActive());





    }
@Test
    public void myTest2 () {
    Account newAccount = new Account();
    assertFalse(newAccount.isActive());
    newAccount.activate();
    assertTrue(newAccount.isActive());

}



}
