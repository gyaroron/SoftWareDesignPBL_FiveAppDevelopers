package com.example.sw_pbl.cen

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
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'datacen'.
 * Generated code; do not edit directly
 */
@Composable
fun CustomDatacen(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        BackgLoc(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f))
        FrameLoc(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            HeadLoc(modifier = Modifier.rowWeight(1.0f)) {
                LogoLogin(modifier = Modifier.rowWeight(1.0f))
            }
            MapJA()
            ScrollableDatacen()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun CustomDatacenPreview() {
    MaterialTheme {
        RelayContainer {
            CustomDatacen(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
        }
    }
}

@Composable
fun BackgLoc(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.datacen_backg_loc),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun BreakfastPg1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic1_ja),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun LunchPg1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic2_ja),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun DinnerPg1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.pic3_ja),
        modifier = modifier
            .requiredWidth(250.0.dp)
            .requiredHeight(250.0.dp)
    )
}

@Composable
fun ListPg1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 15.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun LogoLogin(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.datacen_logo_login),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun HeadLoc(
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
fun MapJA(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.datacen_map_ja),
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
fun FrameLoc(
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
            .requiredWidth(360.0.dp)
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
fun ScrollableDatacen() {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(vertical = 0.dp)){
        item {
            Spacer(Modifier.width(24.dp))
        }
        item {
            ListPg1{
                BreakfastPg1()
                LunchPg1()
                DinnerPg1()
            }
        }
        item {
            Spacer(Modifier.width(24.dp))
        }
    }
}
