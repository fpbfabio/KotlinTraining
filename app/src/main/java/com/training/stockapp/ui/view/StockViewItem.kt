package com.training.stockapp.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.training.stockapp.R
import com.training.stockapp.data.model.Stock
import com.training.stockapp.ui.theme.StockAppTheme


@Composable
fun StockViewItem(stock: Stock) {
    val expanded = remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .padding(5.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.spacing_10x))) {
            Column {
                Row {
                    AsyncImage(
                        modifier = Modifier.size(70.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(stock.url)
                            .placeholder(R.drawable.ic_launcher_background)
                            .crossfade(true)
                            .crossfade(1000)
                            .error(R.drawable.ic_launcher_background)
                            .build(),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Image"
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                    Column(modifier = Modifier.align(CenterVertically)) {
                        Row {
                            Text(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colors.onBackground,
                                text = stock.label
                            )
                            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                            Text(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colors.onBackground,
                                text = "R$${stock.price}"
                            )
                        }
                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_10x)))
                        Row(modifier = Modifier.clickable {
                            expanded.value = !expanded.value
                        }) {
                            Row {
                                Icon(
                                    painter = rememberVectorPainter(image = Icons.Default.ExpandMore),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_5x)))
                                Text(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colors.onBackground,
                                    text = stringResource(
                                        id = R.string.stock_item_more_details,
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                            Text(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = if (stock.today >= 0) Color.Green else Color.Red,
                                text = "%${stock.today}"
                            )
                        }
                    }
                }
                if (expanded.value) {
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_10x)))
                    Row {
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            text = stringResource(id = R.string.last_day)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            color = if (stock.today >= 0) Color.Green else Color.Red,
                            text = "%${stock.today}"
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_10x)))
                    Row {
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            text = stringResource(id = R.string.last_week)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            color = if (stock.today >= 0) Color.Green else Color.Red,
                            text = "%${stock.today}"
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_10x)))
                    Row {
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            text = stringResource(id = R.string.last_month)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_10x)))
                        Text(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            color = if (stock.today >= 0) Color.Green else Color.Red,
                            text = "%${stock.today}"
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun StockItemPreview() {
    StockAppTheme {
        StockViewItem(Stock())
    }
}