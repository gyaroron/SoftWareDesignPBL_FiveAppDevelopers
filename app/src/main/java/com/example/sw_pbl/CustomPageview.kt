package com.example.sw_pbl.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.sw_pbl.R
import com.example.sw_pbl.page1.istokWeb
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.google.relay.compose.ColumnScope
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable
import kotlinx.coroutines.launch

/**
 * This composable was generated from the UI Package 'pageview'.
 * Generated code; do not edit directly
 */
@Composable
fun CustomPageview(
    modifier: Modifier = Modifier,
    onLocPg1Tapped: () -> Unit = {},
    newsadmin: String
) {
    val storage: FirebaseStorage = Firebase.storage
    val storageRef: StorageReference = storage.reference
    val imgRef: StorageReference = storageRef.child("${newsadmin}/foodImage.png")

    val scope = rememberCoroutineScope()
    val imageUrl = remember { mutableStateOf("") }

    LaunchedEffect(imgRef) {
        scope.launch {
            imgRef.downloadUrl.addOnSuccessListener {
                imageUrl.value = it.toString()
            }
        }
    }


    TopLevel(modifier = modifier) {
        FramePg1(
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
            HeadPg1(modifier = Modifier.rowWeight(1.0f)) {
                LogoPg1(modifier = Modifier.rowWeight(1.0f))
            }
            ScrollablePageView()
            Group22 {
                AnnouncePg1 {
                    AnnPg1(modifier = Modifier.rowWeight(1.0f), firestore = FirebaseFirestore.getInstance(), newsadmin = newsadmin)
                }
                AnnouncePg2(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 110.0.dp
                        )
                    )
                ) {
                    AnnPg2(modifier = Modifier.rowWeight(1.0f))
                }

                LocPg1(
                    onLocPg1Tapped = onLocPg1Tapped,
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 301.0.dp
                        )
                    )
                ) {
                    LoctxtPg1()
                }
                if (imageUrl.value.isNotEmpty()) {
                    Image(
                        painter = rememberImagePainter(data = imageUrl.value),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(1.0f)
                            .requiredHeight(181.dp)
                    )
                }

            }
        }
    }
}


@Composable
fun LogoPg1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.page_1_logo_pg1),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(46.0.dp)
    )
}

@Composable
fun HeadPg1(
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
            .requiredHeight(46.0.dp)
    )
}

@Composable
fun BreakfastPg1(modifier: Modifier = Modifier, firestore: FirebaseFirestore) {
    val fieldValueState = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val docRef = firestore.collection("Upload_news").document("ARAM")
        docRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val field = documentSnapshot.getString("news")
                field?.let {
                    // 필드 값을 가져왔으므로 표시할 수 있습니다.
                    fieldValueState.value = it
                }
            }
        }
    }
    Box(
        modifier = modifier
        .requiredWidth(340.0.dp)
        .requiredHeight(161.0.dp)
    ) {
        RelayVector(
            vector = painterResource(R.drawable.page_1_breakfast_pg1),
            modifier = modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ){
            RelayText(
                content = fieldValueState.value,
                fontFamily = istokWeb,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                maxLines = Int.MAX_VALUE
            )
        }
    }
}

@Composable
fun LunchPg1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
        .requiredWidth(340.0.dp)
        .requiredHeight(161.0.dp)
    ) {
        RelayVector(
            vector = painterResource(R.drawable.page_1_lunch_pg1),
            modifier = modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ){
            RelayText(
                content = "Lunch",
                fontFamily = istokWeb,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                maxLines = Int.MAX_VALUE
            )
        }
    }
}

@Composable
fun DinnerPg1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(340.0.dp)
            .requiredHeight(161.0.dp)
    ) {
        RelayVector(
            vector = painterResource(R.drawable.page_1_dinner_pg1),
            modifier = modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ){
            RelayText(
                content = "Dinner",
                fontFamily = istokWeb,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                maxLines = Int.MAX_VALUE
            )
        }

    }
}

@Composable
fun ListPg1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit,
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
fun AnnPg1(modifier: Modifier = Modifier, firestore: FirebaseFirestore, newsadmin: String) {
    val fieldValueState = remember { mutableStateOf("") }
    // 공지사항 Retrieve
    LaunchedEffect(Unit) {
        val docRef = firestore.collection("Upload_news").document(newsadmin)
        docRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val field = documentSnapshot.getString("news")
                field?.let {
                    // 필드 값을 가져왔으므로 표시할 수 있습니다.
                    fieldValueState.value = it
                }
            }
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(100.dp)
    ) {
        RelayVector(
            vector = painterResource(R.drawable.page_1_ann_pg1),
            modifier = Modifier.fillMaxWidth()
        )
        RelayText(
            content = fieldValueState.value.ifEmpty {"공지사항이 없습니다."},
            fontFamily = istokWeb,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
            ,
            maxLines = 4
        )
    }
}

@Composable
fun AnnouncePg1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(336.0.dp)
    )
}

@Composable
fun AnnPg2(modifier: Modifier = Modifier) {
    RelayVector( // pageview_ann_pg2
        vector = painterResource(R.drawable.page_1_ann_pg1),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(181.0.dp)
    )
}

@Composable
fun AnnouncePg2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(340.0.dp)
    )
}

@Composable
fun LoctxtPg1(modifier: Modifier = Modifier) {
    RelayText(
        content = "건물 외관",
        fontSize = 25.0.sp,
        fontFamily = istokWeb,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.439453125.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(320.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun LocPg1(
    onLocPg1Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        radius = 10.0,
        strokeWidth = 1.0,
        strokeColor = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        content = content,
        modifier = modifier
            .tappable(onTap = onLocPg1Tapped)
            .relayDropShadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                borderRadius = 10.0.dp,
                blur = 4.0.dp,
                offsetX = 0.0.dp,
                offsetY = 4.0.dp,
                spread = 0.0.dp
            )
    )
}

@Composable
fun Group22(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(340.0.dp)
            .requiredHeight(357.0.dp)
    )
}

@Composable
fun FramePg1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        padding = PaddingValues(
            start = 10.0.dp,
            top = 8.0.dp,
            end = 10.0.dp,
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
fun ScrollablePageView() {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(vertical = 0.dp)){
        item {
            Spacer(Modifier.width(24.dp))
        }
        item {
            ListPg1 {
                BreakfastPg1(firestore = FirebaseFirestore.getInstance())
                LunchPg1()
                DinnerPg1()
            }
        }
        item {
            Spacer(Modifier.width(24.dp))
        }
    }
}
