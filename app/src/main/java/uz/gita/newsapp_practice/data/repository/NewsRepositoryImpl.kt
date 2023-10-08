package uz.gita.newsapp_practice.data.repositoryimport android.util.Logimport kotlinx.coroutines.flow.Flowimport kotlinx.coroutines.flow.catchimport kotlinx.coroutines.flow.flowimport uz.gita.newsapp_practice.data.mapper.toParamimport uz.gita.newsapp_practice.data.source.remote.api.NewsApiimport uz.gita.newsapp_practice.domain.models.CategoryParamimport uz.gita.newsapp_practice.domain.models.SliderParamimport uz.gita.newsapp_practice.domain.repository.NewsRepositoryimport javax.inject.Injectclass NewsRepositoryImpl @Inject constructor(    private val api: NewsApi,) : NewsRepository {    override fun getSliderNews(): Flow<List<SliderParam>> = flow {        val response = api.getSliderNews()        if (response.isSuccessful && response.body() != null) {            response.body()?.let {                emit(response.body()!!.articles!!.map {                    it.toParam()                })            }        } else {            //...        }    }.catch { Log.d("TTT", "Network Error") }    override fun getCategories(category: String): Flow<List<CategoryParam>> = flow {        val response = api.getNewsByCategories(category)        if (response.isSuccessful && response.body() != null) {            emit(response.body()!!.articles!!.map { it.toParam() })        } else {            //...        }    }.catch { Log.d("TTT", "Network Error") }}