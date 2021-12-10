package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@Suite.SuiteClasses({DemoqaTest.class, GoogleResultTest.class})
@RunWith(Suite.class)
public class GoogleSuit {
}
