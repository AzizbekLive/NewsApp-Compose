package uz.gita.newsapp_practice.presenter.screens.mainimport uz.gita.newsapp_practice.domain.models.CategoryParamimport uz.gita.newsapp_practice.domain.models.SliderParamimport uz.gita.newsapp_practice.presenter.screens.detail.news.NewsScreenimport uz.gita.newsapp_practice.presenter.screens.detail.slider.SliderDetailScreenimport uz.gita.newsapp_practice.utils.navigation.AppNavigatorimport javax.inject.Injectinterface MainDirection {    suspend fun openSliderDetailScreen(data: SliderParam)    suspend fun openNewsDetailScreen(data: CategoryParam)}class MainDirectionImpl @Inject constructor(    private val appNavigator: AppNavigator,) : MainDirection {    override suspend fun openSliderDetailScreen(data: SliderParam) {        appNavigator.openWithSave(SliderDetailScreen(data))    }    override suspend fun openNewsDetailScreen(data: CategoryParam) {        appNavigator.openWithSave(NewsScreen(data))    }}