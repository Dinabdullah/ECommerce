package com.example.ecommerce.componants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.model.Meal
import com.example.ecommerce.viewmodel.MainContract
import kotlinx.coroutines.launch

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    meals: List<Meal>,
    filteredMeals: () -> List<Meal>,
    categories: List<String>,
    onEvent: (MainContract.MealEvents) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 0) { categories.size }
    val scope = rememberCoroutineScope()

    Column() {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = 1.dp, color = Color(0xFFF08626)
                )
            }) {
            categories.forEachIndexed { index, category ->
                val isSelected = pagerState.currentPage == index
                Tab(
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black.copy(alpha = 0.6f),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                        onEvent(MainContract.MealEvents.CategoryClick(index))

                    },
                    text = {
                        Text(
                            categories[index],
                            // color = if (isSelected) Color.Black else Color.Black.copy(alpha = 0.6f),
                            fontSize = if (isSelected) 16.sp else 12.sp,
                            fontWeight = FontWeight.W500
                        )
                    }


                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            CategoryList(
                meals = filteredMeals(),
                onEvent = onEvent,
            )
        }

    }
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    meals: List<Meal>,
    onEvent: (MainContract.MealEvents) -> Unit
) {
    LazyRow {
        items(meals) { meal ->
            CustomMealItem(
                modifier = Modifier.padding(horizontal = 8.dp),
                meal = meal,
                onEvent = onEvent
            )
        }
    }
}

//@Preview
//@Composable
//private fun CategoryRowPreview() {
//    CategoryRow(
//        meals = listOf(),
//        onEvent = {}
//    )
//}
