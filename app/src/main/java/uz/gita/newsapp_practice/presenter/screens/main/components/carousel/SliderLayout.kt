package uz.gita.newsapp_practice.presenter.screens.main.components.carousel

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import uz.gita.newsapp_practice.R
import uz.gita.newsapp_practice.domain.models.SliderParam
import kotlin.math.absoluteValue


@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("AutoboxingStateCreation")
@ExperimentalPagerApi
@Composable
fun ViewPagerSlider(
    data: List<SliderParam>,
    onItemClick: (SliderParam) -> Unit,
) {
    val pagerState = rememberPagerState(
        initialPage = 0
    )

    val chunkedData = data.chunked(10)
    val currentChunk = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000L)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % 10,
                animationSpec = tween(600)
            )
        }
    }

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(top = 20.dp),
            count = 10,
        ) { page ->
            val itemIndex = (currentChunk.value * 10 + page) % 10
            if (itemIndex < data.size) {
                val data1 = data[itemIndex]
                Card(
                    modifier = Modifier
                        .clickable { onItemClick(data1) }
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                            lerp(
                                start = 0.85f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_placeholder), contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp)),
                        )

                        GlideImage(
                            model = data1.urlToImage ?: "",
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp)),
                            loading = placeholder(R.drawable.img_placeholder)
                        )


                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(15.dp)
                        ) {
                            Text(
                                text = data1.author ?: "",
                                style = MaterialTheme.typography.h6,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = data1.title ?: "",
                                style = MaterialTheme.typography.body2,
                                color = Color.White,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                            )
                        }
                    }
                }
            }
        }

        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == 9 && currentChunk.value < chunkedData.size - 1) {
                currentChunk.value++
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSlider() {
    ViewPagerSlider(data = emptyList()) {}
}