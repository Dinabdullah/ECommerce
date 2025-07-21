package com.example.ecommerce.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerce.R

@Composable
fun CartBox(
    modifier: Modifier = Modifier,
    quantity: Int,
    onCartClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(12.dp)
            .clickable { onCartClick() }
    ) {
        Icon(
            //painter = painterResource(id = R.drawable.fa_shopping_basket),
            painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
            tint = Color(0xFFF08626),
            contentDescription = null,
            modifier = Modifier
                .size(54.dp)
                .fillMaxSize()
        )
        if (quantity > 9) {
            Box(
                modifier = Modifier
                    .padding(start = 36.dp, top = 4.dp)
                    .size(24.dp)
                    .background(Color.Red, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "9+",
                    color = Color.White,
                )
            }


        } else if (quantity > 0) {
            Box(
                modifier = Modifier
                    .padding(start = 36.dp, top = 4.dp)
                    .size(24.dp)
                    .background(Color.Red, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quantity.toString(),
                    color = Color.White,
                )
            }


        }

    }
}


@Preview
@Composable
private fun CartRowPreview() {
    CartBox(
        modifier = Modifier.padding(16.dp),
        quantity = 3,
        onCartClick = {}
    )
}