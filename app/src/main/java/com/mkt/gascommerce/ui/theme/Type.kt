package com.mkt.gascommerce.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mkt.gascommerce.R

// Set of Material typography styles to start with
val nunitoFamily = FontFamily(
    Font(R.font.nunito_light,FontWeight.Light),
    Font(R.font.nunito_regular,FontWeight.Medium),
    Font(R.font.nunito_bold,FontWeight.Bold)
)

val Typography = Typography(
    defaultFontFamily = nunitoFamily
)