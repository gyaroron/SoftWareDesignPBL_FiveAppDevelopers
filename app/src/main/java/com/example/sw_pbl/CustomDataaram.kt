package com.example.sw_pbl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.sw_pbl.R
import com.example.sw_pbl.cen.BreakfastPg1
import com.example.sw_pbl.cen.DinnerPg1
import com.example.sw_pbl.cen.ListPg1
import com.example.sw_pbl.cen.LunchPg1
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'dataaram'.
 * Generated code; do not edit directly
 */
@Composable
fun CustomDataaram(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        Rectangle35(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        FrameAram(
            modifier = Modifier.boxAlign(
                alignment = Alignment.CenterStart,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            ).rowWeight(1.0f)
        ) {
            HeadAram(modifier = Modifier.rowWeight(1.0f)) {
                LogoAram(modifier = Modifier.rowWeight(1.0f))
            }
            MapAram()
            ScrollableDataaram()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun CustomDataaramPreview() {
    MaterialTheme {
        RelayContainer {
            CustomDataaram(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun Rectangle35(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.dataaram_rectangle_35),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LogoAram(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.dataaram_logo_aram),
        contentScale = ContentScale.Fit,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(44.0.dp)
    )
}

@Composable
fun HeadAram(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(44.0.dp)
    )
}

@Composable
fun MapAram(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.dataaram_map_aram),
        radius = 10.0,
        strokeColor = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        strokeWidth = 1.0,
        borderAlignment = BorderAlignment.Outside,
        contentScale = ContentScale.Fit,
        modifier = modifier.requiredWidth(280.0.dp).requiredHeight(280.0.dp)
    )
}

@Composable
fun Pic1Aram(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic1_aram),
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(250.0.dp)
    )
}

@Composable
fun Pic2Aram(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic2_aram),
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(250.0.dp)
    )
}

@Composable
fun Pic3Jaram(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic3_aram),
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(250.0.dp)
    )
}

@Composable
fun PiclistAram(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 20.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun FrameAram(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 8.0.dp,
            end = 0.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(640.0.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun ScrollableDataaram() {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(vertical = 0.dp)){
        item {
            Spacer(Modifier.width(24.dp))
        }
        item {
            PiclistAram {
                Pic1Aram()
                Pic2Aram()
                Pic3Jaram()
            }
        }
        item {
            Spacer(Modifier.width(24.dp))
        }
    }
}
