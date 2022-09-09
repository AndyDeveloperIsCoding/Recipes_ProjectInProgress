package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entity.Recipe;
import recipes.repository.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // Save to database operation
    @Override
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    /* Previous code:
        @Override
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }
     */

    // Read by ID operation
    @Override
    public Optional<Recipe> fetchRecipeById(int recipeId){ // Previously return type was Recipe
        return recipeRepository.findById(recipeId);
    }

    // Delete by ID operation
    @Override
    public void deleteRecipeById(int recipeId){
        recipeRepository.deleteById(recipeId);
    }

}
