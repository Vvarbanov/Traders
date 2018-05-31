package com.diplomna.diplomna.http;


import com.diplomna.diplomna.DTOs.CategoryDTO;
import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.DTOs.SubCategoryDTO;
import com.diplomna.diplomna.DTOs.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @POST("/login")
    Call<Void> login(@Body UserDTO userDTO);

    @POST("/subcategories/create")
    Call<Void> createNewListing(@Body ItemDTO itemDTO);

    @GET("/categories/")
    Call<List<CategoryDTO>> getAllCategories();

    @GET("/subcategories/{categoryName}")
    Call<List<SubCategoryDTO>> getAllSubCategoriesByCategory(@Query("categoryName") String categoryName);
}
