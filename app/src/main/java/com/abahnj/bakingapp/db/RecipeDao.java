package com.abahnj.bakingapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.abahnj.bakingapp.model.Ingredient;
import com.abahnj.bakingapp.model.Recipe;
import com.abahnj.bakingapp.model.RecipeView;
import com.abahnj.bakingapp.model.Step;

import java.util.List;

@Dao
public abstract class RecipeDao {
    @Insert
    public abstract void _insertRecipes(List<Recipe> recipes);

    @Insert
    public abstract void _insertIngredients(List<Ingredient> ingredients);

    @Insert
    public abstract void _insertSteps(List<Step> steps);

    public void insertRecipes(List<Recipe> recipes) {
        for (Recipe recipe : recipes) {

            List<Ingredient> ingredients = recipe.getIngredients();
            for (Ingredient ingredient : ingredients) {
                ingredient.setRecipeId(recipe.getId());
            }
            _insertIngredients(ingredients);

            List<Step> steps = recipe.getSteps();
            for (Step step : steps) {
                step.setRecipeId(recipe.getId());
            }
            _insertSteps(steps);
        }
        _insertRecipes(recipes);
    }

    @Transaction
    @Query("SELECT * FROM Recipe")
    public abstract LiveData<List<RecipeView>> getRecipes();

    @Transaction
    @Query("SELECT * FROM Recipe WHERE id = :id")
    public abstract RecipeView getRecipe(int id);
}

