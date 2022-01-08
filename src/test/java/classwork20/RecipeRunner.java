package classwork20;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class RecipeRunner {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({ Recipe.class, Ingredient.class, SimpleJsonParser.class})

    public class SimpleParser {

    }
}