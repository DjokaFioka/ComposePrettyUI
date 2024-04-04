package rs.djokafioka.composeprettyui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

/**
 * Created by Djordje on 2.4.2024..
 */
data class Document(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
