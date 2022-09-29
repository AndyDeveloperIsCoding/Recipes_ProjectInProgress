package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import recipes.entity.IdForReturn;
import recipes.entity.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    // Annotation
    @Autowired
    private RecipeService recipeService;

    // Endpoint: Save to database operation
    @PostMapping("/api/recipe/new")
    public IdForReturn postRecipe(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody Recipe recipe) {
        String authorEmail = userDetails.getUsername();
        recipe.setAuthorEmail(authorEmail);
        recipeService.saveRecipe(recipe);
        return new IdForReturn(recipe.getRecipeId());
    }

    // Endpoint: Update a recipe in the database
    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<String> updateRecipe(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody Recipe recipe, @PathVariable("id") int recipeId) { // Previous type: Recipe
        String authorEmail = userDetails.getUsername();

        if (authorEmail.equals(recipeService.fetchRecipeById(recipeId).getAuthorEmail())){
            recipeService.updateRecipe(recipe, recipeId);
            return new ResponseEntity<>("Updated successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("User is not authorized to update this recipe",HttpStatus.FORBIDDEN);
        }
    }

    // Endpoint: Delete by recipe ID
    @DeleteMapping("api/recipe/{id}")
    public ResponseEntity<String> deleteRecipeById(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") int recipeId){
        String authorEmail = userDetails.getUsername();

        if (authorEmail.equals(recipeService.fetchRecipeById(recipeId).getAuthorEmail())){
            recipeService.deleteRecipeById(recipeId);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("User is not authorized to delete this recipe",HttpStatus.FORBIDDEN);
        }
    }

    // Endpoint: Read by recipe ID
    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return recipeService.fetchRecipeById(id);
    }

    @GetMapping("/api/recipe/search")
    public ResponseEntity<List<Recipe>> searchRecipe(
            @Param("category") Optional<String> category,
            @Param("name") Optional<String> name) {

        if (category.isPresent() && name.isEmpty()) {
            return new ResponseEntity<>(
                    recipeService.search(RecipeService.searchParam.CATEGORY, category.get()),
                    HttpStatus.OK);
        } else if (name.isPresent() && category.isEmpty()) {
            return new ResponseEntity<>(
                    recipeService.search(RecipeService.searchParam.NAME, name.get()),
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Recipe>>(HttpStatus.BAD_REQUEST);
    }
}