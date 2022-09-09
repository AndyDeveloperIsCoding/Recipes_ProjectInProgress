package recipes.service;

import org.springframework.stereotype.Service;
import recipes.entity.Recipe;

import java.util.Optional;


public interface RecipeService {

    // Save operation
    Recipe saveRecipe(Recipe recipe);
    /* Previous code:
        Recipe saveRecipe(Recipe recipe);
     */

    // Read by ID operation
    Optional<Recipe> fetchRecipeById(int recipeId);

    // Delete by ID operation
    void deleteRecipeById(int recipeId);

}



