package com.example.ecommerce.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.ecommerce.R
import com.example.ecommerce.model.Meal

@Composable
fun IconBox(modifier: Modifier = Modifier, meal: Meal, onfavItemClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.dp_8))


    ) {
        if (meal.isFavorite) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                tint = Color(0xFFF08626),
                contentDescription = null,
                modifier = modifier
                    .clickable {
                        onfavItemClick()
                    }
                    .align (alignment = Alignment.TopEnd)

            )

        } else {
            Icon(
                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                contentDescription = null,
                tint = Color(0xFFF08626),
                modifier = modifier
                    .clickable {
                        onfavItemClick()
                    }

            )
        }

    }
}

