package classwork20;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        SimpleJsonParser simpleJsonParser = new SimpleJsonParser();
        simpleJsonParser.parseJSON();
        simpleJsonParser.parseGSON();
        simpleJsonParser.toGSON();
    }
}