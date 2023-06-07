package com.example.sw_pbl.customadmin

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.sw_pbl.R
import com.example.sw_pbl.admin.dINAlternate
import com.example.sw_pbl.admin.istokWeb
import com.example.sw_pbl.admin.sansita
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RowScopeInstance.boxAlign
import com.google.relay.compose.tappable

/**
 * This composable was generated from the UI Package 'admin'.
 * Generated code; do not edit directly
 */
@Composable
fun CustomAdmin(
    context: Context,
    collectionName: String,
    documentName: String,
    fieldName: String,
    db: FirebaseFirestore,
    upNews: DocumentReference,
    modifier: Modifier = Modifier,
    onResetAllTapped2: () -> Unit = {},
    onUploadNewsTapped: () -> Unit = {},
    onUploadPicTapped: () -> Unit = {},
    newstext: String,
    onnewsValueChange: (String) -> Unit
) {
    FirebaseApp.initializeApp(context)

    TopLevel(modifier = modifier) {
        Group18(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            LoadingviewBg(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f)) {}
            TitleLoadingview(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
            ResetAll(
                onResetAllTapped2 = onResetAllTapped2,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            ) {
                LoginTxtbox {
                    TxtLogin()
                }
            }
            TitleLoadingview1(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
            TitleLoadingview2(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
            UploadNews(
                onUploadNewsTapped = onUploadNewsTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.0.dp,
                        y = 292.0.dp
                    )
                )
            ) {
                LoginTxtbox1(modifier = Modifier.columnWeight(1.0f)) {
                    TxtLogin1()
                }
            }
            UploadPic(
                onUploadPicTapped = onUploadPicTapped,
                modifier = Modifier
                    .boxAlign(
                        alignment = Alignment.CenterStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 131.0.dp
                        )
                    )
                    .rowWeight(1.0f)
            ) {
                FreeIconPhotoCameraInterfaceSymbolForButton450101(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.5.dp
                        )
                    )
                )
                UploadPicSynth {}
            }
            FrameLogin(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f)) {
                HeadLogin(modifier = Modifier.rowWeight(1.0f)) {
                    LogoLogin(modifier = Modifier.rowWeight(1.0f))
                }
            }
            NewsTextField(newstext = newstext, onnewsValueChange = onnewsValueChange)
            AdminTitle()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun CustomAdminPreview() {
    var newstext by remember { mutableStateOf("") }
    val onnewsValueChange = { it: String ->
        newstext = it
    }
    MaterialTheme {
        RelayContainer {
            CustomAdmin(
                onResetAllTapped2 = {},
                onUploadNewsTapped = {},
                onUploadPicTapped = {},
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f),
                newstext = newstext,
                onnewsValueChange = onnewsValueChange
            )
        }
    }
}

@Composable
fun LoadingviewBg(
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
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun TitleLoadingview(modifier: Modifier = Modifier) {
    RelayText(
        content = "메뉴 사진",
        fontSize = 24.0.sp,
        fontFamily = istokWeb,
        color = Color(
            alpha = 255,
            red = 72,
            green = 72,
            blue = 72
        ),
        height = 1.439453125.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 132.99951171875.dp,
                    top = 349.3994140625.dp,
                    end = 130.00048828125.dp,
                    bottom = 255.6005859375.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun TxtLogin(modifier: Modifier = Modifier) {
    RelayText(
        content = "내용 전체삭제",
        fontSize = 20.0.sp,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        fontWeight = FontWeight(500.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun LoginTxtbox(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 24.0.dp,
            top = 10.0.dp,
            end = 24.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ResetAll(
    onResetAllTapped2: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 158,
            red = 130,
            green = 0,
            blue = 0
        ),
        itemSpacing = 8.0,
        radius = 10.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 19.0.dp,
                    top = 524.0.dp,
                    end = 17.0.dp,
                    bottom = 76.0.dp
                )
            )
            .tappable(onTap = onResetAllTapped2)
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun TitleLoadingview1(modifier: Modifier = Modifier) {
    RelayText(
        content = "공지사항",
        fontSize = 24.0.sp,
        fontFamily = istokWeb,
        color = Color(
            alpha = 255,
            red = 72,
            green = 72,
            blue = 72
        ),
        height = 1.439453125.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 136.99951171875.dp,
                    top = 133.4013671875.dp,
                    end = 134.00048828125.dp,
                    bottom = 471.5986328125.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun TitleLoadingview2(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = sansita,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append(" ")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = sansita,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("관리자입니다.")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = sansita,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append(" ")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = dINAlternate,
        color = Color(
            alpha = 255,
            red = 72,
            green = 72,
            blue = 72
        ),
        height = 1.171875.em,
        textAlign = TextAlign.Right,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 180.0.dp,
                    top = 61.0.dp,
                    end = 18.0.dp,
                    bottom = 515.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun TxtLogin1(modifier: Modifier = Modifier) {
    RelayText(
        content = "등록",
        fontSize = 20.0.sp,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        fontWeight = FontWeight(500.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun LoginTxtbox1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 24.0.dp,
            top = 10.0.dp,
            end = 24.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxHeight(1.0f)
    )
}

@Composable
fun UploadNews(
    onUploadNewsTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 158,
            red = 72,
            green = 72,
            blue = 72
        ),
        mainAxisAlignment = MainAxisAlignment.End,
        itemSpacing = 8.0,
        clipToParent = false,
        radius = 10.0,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier
            .tappable(onTap = onUploadNewsTapped)
            .requiredWidth(325.0.dp)
            .requiredHeight(50.0.dp)
    )
}

@Composable
fun FreeIconPhotoCameraInterfaceSymbolForButton450101(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.admin_free_icon_photo_camera_interface_symbol_for_button_45010_1),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .requiredWidth(100.0.dp)
            .requiredHeight(77.0.dp)
            .alpha(alpha = 0.6f)
    )
}

@Composable
fun UploadPicSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 10.0.dp,
            end = 0.0.dp,
            bottom = 51.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        radius = 10.0,
        content = content,
        modifier = modifier
            .requiredWidth(324.0.dp)
            .heightIn(116.0.dp, 116.0.dp)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun UploadPic(
    onUploadPicTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 236,
            green = 230,
            blue = 240
        ),
        isStructured = false,
        clipToParent = false,
        radius = 10.0,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 19.0.dp,
                    top = 0.0.dp,
                    end = 17.0.dp,
                    bottom = 0.0.dp
                )
            )
            .tappable(onTap = onUploadPicTapped)
            .fillMaxWidth(1.0f)
            .requiredHeight(116.0.dp)
    )
}

@Composable
fun LogoLogin(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.admin_logo_login),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun HeadLogin(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun FrameLogin(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 8.0.dp,
            end = 0.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 25.0,
        clipToParent = false,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 18.99951171875.dp,
                    top = 0.0.dp,
                    end = 18.00048828125.dp,
                    bottom = 598.400390625.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Group18(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
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
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTextField(
    newstext:String,
    onnewsValueChange: (String) -> Unit
){

    TextField(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 1.5.dp,
                y = 110.0.dp
            )
        )
            .fillMaxWidth()
            .height(180.dp)
            .padding(15.dp)
            .border(width = 1.0.dp, color = Color.White, shape = RoundedCornerShape(1.dp))
        ,
        value = newstext,
        onValueChange = onnewsValueChange,
        placeholder = {Text("공지사항 작성(최대 4줄)")},
        maxLines = 4
    ) //: NewsField
}

@Composable
fun AdminTitle(modifier: Modifier = Modifier){
    RelayText(
        content = "예시",
        fontSize = 30.0.sp,
        fontFamily = istokWeb,
        color = Color(
            alpha = 255,
            red = 72,
            green = 72,
            blue = 72
        ),
        height = 1.439453125.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 80.0.dp,
                    top = 73.0.dp,
                    end = 18.0.dp,
                    bottom = 515.0.dp
                )
            )
            .fillMaxHeight(1.0f)
    )
}
