package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@Suite.SuiteClasses({ColorTest.class, MaxHotelRatingTest.class, MaxPriceTest.class, MoscowHotelsTest.class})
@RunWith(Suite.class)

public class BookingSuit {

/*    public void myTest() {
        System.out.println("Test");
    }

    @Test
    public void run10() {
        for (int i = 0; i < 10; i++) {
            myTest();
        }
    }*/
}
