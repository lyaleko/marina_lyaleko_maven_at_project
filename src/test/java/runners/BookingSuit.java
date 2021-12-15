package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@Suite.SuiteClasses({ToolTipTest.class, ColorTest.class, MaxHotelRatingTest.class, MaxPriceTest.class, MoscowHotelsTest.class})
@RunWith(Suite.class)

public class BookingSuit {

}
