package com.example.ecommerce.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Meal
import com.example.ecommerce.viewmodel.MainContract

@Composable
fun CustomMealItem(
    modifier: Modifier = Modifier, meal: Meal,
    onEvent: (MainContract.MealEvents) -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(dimensionResource(id = R.dimen.dp_152))
            .height(dimensionResource(id = R.dimen.dp_183))
            .background(
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)),
                color = meal.backGroundColor
            ),

        ) {
        Row(modifier = modifier.align(Alignment.End),) {
            IconBox(
                meal = meal,
                onfavItemClick = { onEvent.invoke(MainContract.MealEvents.FavouriteClick(meal.id)) },
            )
        }

        Image(
            painter = painterResource(id = meal.imageRes),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.dp_36))
                .width(dimensionResource(id = R.dimen.dp_80))
                .height(dimensionResource(id = R.dimen.dp_80))
                .align(Alignment.CenterHorizontally)

        )
        Text(
            meal.name,
            fontSize = 10.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color(0xFF27214D),
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen.dp_16),
                vertical = dimensionResource(id = R.dimen.dp_8)
            )
        )
        PriceRow(
            modifier = modifier,
            meal = meal,
            onPlusClick = {
                onEvent.invoke(MainContract.MealEvents.PlusClick(meal.id))
            }
        )
    }
}

@Preview
@Composable
private fun CustomMealItemPreview() {
    CustomMealItem(
        modifier = Modifier,
        meal = Meal(
            id = 1,
            name = "Sample Meal",
            imageRes = R.drawable.honey,
            price = 9.99,
            isFavorite = false,
            quantity = 1,
            backGroundColor = Color.White,
            category = Category.Hottest
        ),
    )
}