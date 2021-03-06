package edu.uc.forbesne.shoppingsidekick.dao
// based onp professor's code - https://github.com/discospiff/MyPlantDiaryQ

import edu.uc.forbesne.shoppingsidekick.dto.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used by Retrofit instance to get make http requests
 *
 */
interface IProductDAO {
    @GET("shop_1.php")
    fun getAllProductsFromOneStore(): Call<ArrayList<Product>>

    @GET("shop_2.php")
    fun getAllProductsFromTwoStore(): Call<ArrayList<Product>>

    @GET("shop_3.php")
    fun getAllProductsFromThreeStore(): Call<ArrayList<Product>>

/*    @GET()
    fun getProductsFromOneStore(@Query(")) : Call<ArrayList<Product>>*/
}