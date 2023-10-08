package uz.gita.newsapp_practice.presenter.screens.main.componentsimport androidx.compose.foundation.BorderStrokeimport androidx.compose.foundation.clickableimport androidx.compose.foundation.layout.paddingimport androidx.compose.foundation.shape.RoundedCornerShapeimport androidx.compose.material.Cardimport androidx.compose.material.Textimport androidx.compose.runtime.Composableimport androidx.compose.ui.Modifierimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.res.colorResourceimport androidx.compose.ui.text.TextStyleimport androidx.compose.ui.text.font.Fontimport androidx.compose.ui.text.font.FontFamilyimport androidx.compose.ui.text.font.FontWeightimport androidx.compose.ui.tooling.preview.Previewimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport uz.gita.newsapp_practice.R@Composablefun CategoryItem(    categoryName: String,    isSelected: Boolean = false,    onItemClick: () -> Unit,) {    Card(        modifier = Modifier            .padding(8.dp)            .clickable { onItemClick() },        elevation = 4.dp,        shape = RoundedCornerShape(16.dp),        border = BorderStroke(1.dp, Color(0xFF6D6265)),        backgroundColor = if (isSelected) colorResource(id = R.color.category_selected) else colorResource(            id = R.color.white        )    ) {        Text(            text = categoryName,            fontSize = 16.sp,            fontWeight = FontWeight.Bold,            style = TextStyle(                color = Color.White,                fontSize = 20.sp,                fontFamily = FontFamily(Font(R.font.inter_semi_bold))            ),            color = if (isSelected) colorResource(id = R.color.white) else colorResource(id = R.color.black),            modifier = Modifier                .padding(16.dp)        )    }}@Preview@Composablefun PreviewCategoryItem() {    CategoryItem(        categoryName = "",        onItemClick = {}    )}