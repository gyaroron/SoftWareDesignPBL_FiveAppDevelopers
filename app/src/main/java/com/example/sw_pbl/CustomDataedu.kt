package com.example.sw_pbl.edu

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
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'dataedu'.
 * Generated code; do not edit directly
 */
@Composable
fun CustomDataedu(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        Rectangle37(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f))
        FrameEdu(
            modifier = Modifier
                .boxAlign(
                    alignment = Alignment.CenterStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
                .rowWeight(1.0f)
        ) {
            HeadEdu(modifier = Modifier.rowWeight(1.0f)) {
                LogoLogin(modifier = Modifier.rowWeight(1.0f))
            }
            MapEdu()
            ScrollableDataedu()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun CustomDataeduPreview() {
    MaterialTheme {
        RelayContainer {
            CustomDataedu(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
        }
    }
}

@Composable
fun Rectangle37(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.dataedu_rectangle_37),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun LogoLogin(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.dataedu_logo_login),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun HeadEdu(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun MapEdu(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.dataedu_map_edu),
        radius = 10.0,
        strokeColor = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        strokeWidth = 1.0,
        borderAlignment = BorderAlignment.Outside,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(280.0.dp)
            .requiredHeight(280.0.dp)
    )
}

@Composable
fun Pic1Edu(modifier: Modifier = Modifier) {
    RelayVector( // pic1_edu
        vector = painterResource(R.drawable.pic1_edu),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun Pic2Edu(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic2_edu),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun Pic3Edu(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic3_edu),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun PiclistEdu(
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
fun FrameEdu(
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
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(640.0.dp)
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
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun ScrollableDataedu() {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(vertical = 0.dp)){
        item {
            Spacer(Modifier.width(24.dp))
        }
        item {
            PiclistEdu{
                Pic1Edu()
                Pic2Edu()
                Pic3Edu()
            }
        }
        item {
            Spacer(Modifier.width(24.dp))
        }
    }
}
