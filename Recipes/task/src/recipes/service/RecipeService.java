package recipes.service;

import recipes.entity.Recipe;

import java.util.List;


public interface RecipeService {

    public enum searchParam {
        CATEGORY, NAME
    }

    // Save operation
    Recipe saveRecipe(Recipe recipe);

    // Update operation
    Recipe updateRecipe(Recipe recipe, int recipeId);

    // Read by ID operation
    Recipe fetchRecipeById(int recipeId);

    // Search by category or name (returns list of recipes)
    List<Recipe> search(searchParam type, String arg);

    List<Recipe> mapRecipesToList(List<Recipe> dbList);

    // Delete by ID operation
    void deleteRecipeById(int recipeId);

}



