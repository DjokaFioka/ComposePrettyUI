package rs.djokafioka.composeprettyui.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import rs.djokafioka.composeprettyui.BottomMenuContent
import rs.djokafioka.composeprettyui.Document
import rs.djokafioka.composeprettyui.R
import rs.djokafioka.composeprettyui.standardQuadFromTo
import rs.djokafioka.composeprettyui.ui.theme.*

/**
 * Created by Djordje on 1.4.2024..
 */

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    onShowSnackbar: (String) -> Job
) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSearchSection()
            TabSection(
                tabs = listOf(
                    stringResource(R.string.tab_invoices),
                    stringResource(R.string.tab_orders),
                    stringResource(R.string.tab_visits),
                    stringResource(R.string.feature_surveys),
                    stringResource(R.string.bottom_menu_notes),
                    stringResource(R.string.tab_notifications),
                    stringResource(R.string.tab_promotions),
                    stringResource(R.string.tab_reports)
                )
            )
            FinancialState()
            DocumentsSection(
                documents = listOf(
                    Document(
                        title = stringResource(R.string.feature_invoices),
                        R.drawable.ic_invoices,
                        Red1,
                        Red2,
                        Red3
                    ),
                    Document(
                        title = stringResource(R.string.feature_orders),
                        R.drawable.ic_orders,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Document(
                        title = stringResource(R.string.feature_visits),
                        R.drawable.ic_visits,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Document(
                        title = stringResource(R.string.feature_surveys),
                        R.drawable.ic_surveys,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                ),
                onShowSnackbar = onShowSnackbar
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent(stringResource(R.string.bottom_menu_home), R.drawable.ic_home),
                BottomMenuContent(
                    stringResource(R.string.bottom_menu_products),
                    R.drawable.ic_products
                ),
                BottomMenuContent(stringResource(R.string.bottom_menu_notes), R.drawable.ic_notes),
                BottomMenuContent(
                    stringResource(R.string.bottom_menu_settings),
                    R.drawable.ic_settings
                ),
                BottomMenuContent(
                    stringResource(R.string.bottom_menu_profile),
                    R.drawable.ic_profile
                ),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSearchSection(
    name: String = "Pretty UI Compose"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Customer: $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "123, West Unknown St, 11000 Belgrade",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(R.string.search),
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun TabSection(
    tabs: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(tabs.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(16.dp)

            ) {
                Text(
                    text = tabs[it],
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
fun FinancialState(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Financial balance",
                style = MaterialTheme.typography.h2
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = "Outstanding 52,436.78",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
                Text(
                    text = "Total 88,368.77",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_list),
                contentDescription = stringResource(R.string.more),
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun DocumentsSection(
    documents: List<Document>,
    onShowSnackbar: (String) -> Job
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.documents),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(documents.size) {
                DocumentItem(document = documents[it], onShowSnackbar)
            }
        }
    }
}

@Composable
fun DocumentItem(
    document: Document,
    onShowSnackbar: (String) -> Job
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(document.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumPoint1 = Offset(0f, height * 0.3f)
        val mediumPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumPoint1.x, mediumPoint1.y)
            standardQuadFromTo(mediumPoint1, mediumPoint2)
            standardQuadFromTo(mediumPoint2, mediumPoint3)
            standardQuadFromTo(mediumPoint3, mediumPoint4)
            standardQuadFromTo(mediumPoint4, mediumPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        //Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = document.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = document.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = document.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 24.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = document.iconId),
                contentDescription = document.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(36.dp)
            )
            Text(
                text = stringResource(R.string.btn_start),
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        onShowSnackbar("Go to ${document.title}")
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(12.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(16.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(
                    if (isSelected)
                        activeHighlightColor
                    else
                        Color.Transparent
                )
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = item.iconId
                ),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}