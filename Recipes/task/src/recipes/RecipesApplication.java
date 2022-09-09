package recipes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.entity.IdForReturn;
import recipes.entity.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;

@SpringBootApplication
public class RecipesApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }

    // Recipe REST controller

    @RestController
    public class RecipeController {

        // Annotation
        @Autowired
        private RecipeService recipeService;

        // Endpoint: Save to database operation
        @PostMapping("/api/recipe/new")
        public IdForReturn postRecipe(@Valid @RequestBody Recipe recipe) { //ResponseEntity<IdForReturn>
                recipeService.saveRecipe(recipe);
                IdForReturn newId = new IdForReturn(recipe.getRecipeId());
                return newId;
        }

        // Endpoint: Read by recipe ID
        @GetMapping("/api/recipe/{id}")
        public Recipe getRecipe(@PathVariable int id) {
            return recipeService.fetchRecipeById(id).
                    orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unfortunately recipe with such id is not found"));
        }

        // Endpoint: Delete by recipe ID
        @DeleteMapping("api/recipe/{id}")
        public ResponseEntity<String> deleteRecipeById(@PathVariable("id") int recipeId){
            try {
                recipeService.deleteRecipeById(recipeId);
                System.out.println("Deleted Successfully");
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>("Recipe not found",HttpStatus.NOT_FOUND);
            }
        }
        
    }
}