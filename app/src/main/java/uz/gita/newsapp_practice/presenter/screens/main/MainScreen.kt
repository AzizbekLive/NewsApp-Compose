package uz.gita.newsapp_practice.presenter.screens.mainimport android.content.Contextimport android.net.ConnectivityManagerimport androidx.compose.foundation.backgroundimport androidx.compose.foundation.layout.*import androidx.compose.foundation.lazy.LazyColumnimport androidx.compose.foundation.lazy.LazyRowimport androidx.compose.foundation.lazy.itemsimport androidx.compose.material3.*import androidx.compose.runtime.*import androidx.compose.ui.Alignmentimport androidx.compose.ui.Modifierimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.platform.LocalContextimport androidx.compose.ui.text.TextStyleimport androidx.compose.ui.text.font.Fontimport androidx.compose.ui.text.font.FontFamilyimport androidx.compose.ui.tooling.preview.Previewimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport cafe.adriel.voyager.androidx.AndroidScreenimport cafe.adriel.voyager.hilt.getViewModelimport com.google.accompanist.pager.ExperimentalPagerApiimport uz.gita.newsapp_practice.Rimport uz.gita.newsapp_practice.presenter.screens.main.components.CategoryItemimport uz.gita.newsapp_practice.presenter.screens.main.components.MainItemsimport uz.gita.newsapp_practice.presenter.screens.main.components.carousel.ViewPagerSliderimport uz.gita.newsapp_practice.ui.theme.NewsApppracticeThemeimport uz.gita.newsapp_practice.utils.isNetworkConnectedimport java.text.SimpleDateFormatimport java.util.Localeclass MainScreen : AndroidScreen() {    @Composable    override fun Content() {        val mainViewModel: MainContract.ViewModel = getViewModel<MainViewModel>()        NewsApppracticeTheme {            MainScreenContent(                mainViewModel.uiState.collectAsState().value,                mainViewModel::onEventDispatcher            )        }    }}@OptIn(ExperimentalPagerApi::class)@Composableprivate fun MainScreenContent(    uiState: MainContract.UIState = MainContract.UIState(),    onEventDispatcher: (MainContract.Intent) -> Unit = {},) {    val context = LocalContext.current    val connectivityManager =        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager    val isNetworkConnected by rememberUpdatedState(        connectivityManager.isNetworkConnected()    )    Column(modifier = Modifier.fillMaxSize()) {        Column(            modifier = Modifier                .background(Color(0xFFE9EEFA))                .padding(top = 36.dp)        ) {            GreetingWithTime()        }        if (isNetworkConnected) {            if (uiState.sliderNews.isEmpty() && uiState.newsList.isEmpty()) {                Box(                    modifier = Modifier.fillMaxSize()                ) {                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))                }            } else {                LazyColumn(modifier = Modifier) {                    item(uiState.sliderNews) {                        Box (modifier = Modifier.height(200.dp)){                            ViewPagerSlider(data = uiState.sliderNews, onItemClick = {                                onEventDispatcher.invoke(MainContract.Intent.SliderDetail(it))                            })                        }                    }                    item {                        LazyRow(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {                            items(uiState.categoriesList) {                                CategoryItem(                                    categoryName = it, it == uiState.selectedCategory                                ) {                                    onEventDispatcher.invoke(MainContract.Intent.SelectCategory(it))                                }                            }                        }                    }                    items(uiState.newsList) {                        MainItems(it) {                            onEventDispatcher.invoke(MainContract.Intent.NewsDetail(it))                        }                    }                }            }        } else {            NoInternetMessage()        }    }}@Composablefun NoInternetMessage() {    Box(modifier = Modifier.fillMaxSize()) {        Text(            text = "No internet connection", modifier = Modifier                .align(Alignment.Center)        )    }}@Composablefun GreetingWithTime() {    val currentTime = rememberUpdatedState(System.currentTimeMillis())    val currentDayTime =        SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault()).format(currentTime.value)    val currentHour = SimpleDateFormat("HH", Locale.getDefault()).format(currentTime.value).toInt()    val greeting = "Good Day"    /*when {    currentHour < 13 -> "Good Day"    currentHour < 18 -> "Good Day"    else -> "Good Day"    }*/    Column(        modifier = Modifier            .padding(16.dp)            .fillMaxWidth(),    ) {        Text(            text = "$greeting,\nDear User",            style = TextStyle(                fontSize = 14.sp,                color = Color(0xFF6D6265),                fontFamily = FontFamily(Font(R.font.inter_light))            ),            color = Color(0xFF6D6265)        )        Text(            text = currentDayTime,            style = TextStyle(                fontSize = 18.sp,                color = Color(0xFF231F20),                fontFamily = FontFamily(Font(R.font.inter_regular))            ),            color = Color(0xFF231F20)        )    }}@Composable@Preview(showBackground = true)fun MainScreenContentPreview() {    MainScreenContent()}