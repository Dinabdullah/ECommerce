package com.example.ecommerce.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.model.Meal

@Composable
fun PriceRow(
    modifier: Modifier = Modifier, meal: Meal,
    onPlusClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.dp_16))
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$${meal.price}",
            fontSize = 14.sp,
            color = Color(0xFFF08626),
        )
        Box(
            modifier = modifier
                .size(dimensionResource(id = R.dimen.dp_24))
                .background(
                    Color(0xFFFFF2E7),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_100))
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = null,
                modifier
                    .align(Alignment.Center)
                    .clickable {
                        onPlusClick()
                    },
            )
        }

    }
}

