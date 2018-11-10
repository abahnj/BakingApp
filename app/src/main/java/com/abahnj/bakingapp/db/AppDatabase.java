package com.abahnj.bakingapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.abahnj.bakingapp.model.Ingredient;
import com.abahnj.bakingapp.model.Recipe;
import com.abahnj.bakingapp.model.Step;

@Database(entities = {Recipe.class, Ingredient.class, Step.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    abstract public RecipeDao recipeDao();
}
