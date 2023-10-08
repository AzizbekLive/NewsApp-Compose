package uz.gita.newsapp_practice.data.source.remote.apiimport retrofit2.Responseimport retrofit2.http.GETimport retrofit2.http.Queryimport uz.gita.newsapp_practice.data.source.remote.response.category.CategoryResponseimport uz.gita.newsapp_practice.data.source.remote.response.slider.SliderResponseimport uz.gita.newsapp_practice.utils.Constants.API_KEYimport uz.gita.newsapp_practice.utils.Constants.COUNTRYinterface NewsApi {    @GET("top-headlines")    suspend fun getSliderNews(        @Query("country") country: String = COUNTRY,        @Query("apiKey") apiKey: String = API_KEY,    ): Response<SliderResponse>    @GET("top-headlines")    suspend fun getNewsByCategories(        @Query("sources") category: String,        @Query("apiKey") apiKey: String = API_KEY,    ): Response<CategoryResponse>}