package com.abahnj.bakingapp.api;

import android.arch.lifecycle.LiveData;

import com.abahnj.bakingapp.model.Recipe;

import java.util.List;

import retrofit2.http.GET;

public interface WebService {
    @GET("baking.json")
    LiveData<ApiResponse<List<Recipe>>> getRecipes();
}
