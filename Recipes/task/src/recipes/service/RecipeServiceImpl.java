package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.entity.Recipe;
import recipes.repository.RecipeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // Save to database operation
    @Override
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    // Update recipe in the database operation
    @Override
    public Recipe updateRecipe(Recipe recipe, int recipeId) {
        Recipe currentDbRecipe = recipeRepository.findById(recipeId).get();

        currentDbRecipe.setName(recipe.getName());
        currentDbRecipe.setCategory(recipe.getCategory());
        currentDbRecipe.setDate(LocalDateTime.now());
        currentDbRecipe.setDescription(recipe.getDescription());
        currentDbRecipe.setIngredients(recipe.getIngredients());
        currentDbRecipe.setDirections(recipe.getDirections());

        return recipeRepository.save(currentDbRecipe);
    }

    // Read by ID operation
    @Override
    public Recipe fetchRecipeById(int recipeId){ // Previously return type was Recipe
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unfortunately recipe with such id is not found"));
    }

    // Search by category or name (returns list of recipes)
    public List<Recipe> search(searchParam type, String arg){
        if (type.equals(searchParam.CATEGORY)){
            return mapRecipesToList(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(arg));
        }
        return mapRecipesToList(recipeRepository.findByNameContainingIgnoreCaseOrderByDateDesc(arg));
    }

    public List<Recipe> mapRecipesToList(List<Recipe> dbList) {
        List<Recipe> dtoList = new ArrayList<>();
        dtoList.addAll(dbList);
        return dtoList;
    }

    // Delete by ID operation
    @Override
    public void deleteRecipeById(int recipeId){
        recipeRepository.deleteById(recipeId);
    }

}
