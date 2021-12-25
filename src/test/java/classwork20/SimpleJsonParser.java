package classwork20;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SimpleJsonParser {
    private static final String JSON = "src/test/resources/recipe.json";
    private static final String JSON_1 = "src/test/resources/recipe1.json";

    File file = new File(JSON);

    public void parseJSON() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(JSON)));
        JSONObject obj = new JSONObject(input);
        System.out.println(obj.getString("recipename"));
    }

    public void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.recipename);
    }

    public void toGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = new Recipe("Borsch", new Ingredient[]{}, 120);
        System.out.println(gson.toJson(recipe));
        Files.write(Paths.get(JSON_1), gson.toJson(recipe).getBytes());
    }

}