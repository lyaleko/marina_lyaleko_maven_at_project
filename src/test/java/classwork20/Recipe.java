package classwork20;

public class Recipe {

    public String recipename;
    public Ingredient[] ingredlist;
    public int preptime;

    public Recipe(String borsch, Ingredient[] ingredients, int i) {
        this.recipename = borsch;
        this.ingredlist = ingredients;
        this.preptime = i;
    }
}