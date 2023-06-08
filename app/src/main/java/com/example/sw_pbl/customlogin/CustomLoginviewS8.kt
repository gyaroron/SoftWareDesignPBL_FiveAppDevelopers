package com.example.sw_pbl.customlogin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.sw_pbl.R
import com.example.sw_pbl.login.Login
import com.example.sw_pbl.login.dINAlternate
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

/**
 * This composable was generated from the UI Package 'login'.
 * Generated code; do not edit directly
 *
 * @param onBtnLogin Login Button
 */
@Composable
fun CustomLoginviewS8(
    modifier: Modifier = Modifier,
    onBtnLogin: () -> Unit = {},
    idtext: String,
    onidValueChange: (String) -> Unit,
    pwtext: String,
    onpwValueChange: (String) -> Unit
) {
    TopLevel(modifier = modifier) {
        Group21(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            Rectangle33(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            Group20(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            ) {
                HeadLogin {
                    LogoLogin(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 8.0.dp
                            )
                        )
                    )
                    HeadLoginSynth {}
                }
                BtnLogin(
                    onBtnLogin = onBtnLogin,
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = 0.5.dp,
                            y = 457.0.dp
                        )
                    )
                ) {
                    TxtLoginbtn()
                }
                TitleLogin(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 150.4208984375.dp
                        )
                    )
                ) {
                    TxtLogin()
                }

                IdTextField(idtext = idtext, onidValueChange = onidValueChange)

                PWTextField(pwtext = pwtext, onpwValueChange = onpwValueChange)

            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun LoginPreview() {
    MaterialTheme {
        RelayContainer {
            Login(
                onBtnLogin = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Rectangle33(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.login_rectangle_33),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(640.0.dp)
    )
}

@Composable
fun LogoLogin(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.login_logo_login),
        contentScale = ContentScale.Fit,
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun HeadLoginSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(77.150390625.dp).alpha(alpha = 100.0f)
    )
}

@Composable
fun HeadLogin(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(77.150390625.dp)
    )
}

@Composable
fun TxtLoginbtn(modifier: Modifier = Modifier) {
    RelayText(
        content = "로그인",
        fontSize = 20.0.sp,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.171875.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun BtnLogin(
    onBtnLogin: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 135,
            green = 132,
            blue = 136
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        radius = 10.0,
        content = content,
        modifier = modifier.tappable(onTap = onBtnLogin).requiredWidth(329.0.dp).requiredHeight(58.0.dp)
    )
}

@Composable
fun TxtLogin(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 50.0.sp)) {
                append("관리자")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 50.0.sp,
                    letterSpacing = 10.0.sp
                )
            ) {
                append(" ")
            }
            withStyle(style = SpanStyle(fontSize = 50.0.sp)) {
                append("로그인")
            }
        },
        fontSize = 50.0.sp,
        fontFamily = dINAlternate,
        color = Color(
            alpha = 255,
            red = 72,
            green = 72,
            blue = 72
        ),
        height = 1.1640625.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun TitleLogin(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredHeight(114.5029296875.dp)
    )
}

@Composable
fun Group20(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(515.0.dp)
    )
}

@Composable
fun Group21(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(640.0.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdTextField(
    idtext:String,
    onidValueChange: (String) -> Unit
){

    TextField(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 42.0.dp,
                y = 260.0.dp
            )
        )//: modifier
        ,
        value = idtext,
        onValueChange = onidValueChange,
        maxLines = 1,
        label = { Text(text = "ID") },
        singleLine = true
    ) //: TextField
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PWTextField(
    pwtext:String,
    onpwValueChange: (String) -> Unit
){

    TextField(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 42.0.dp,
                y = 360.0.dp
            )
        ),
        value = pwtext,
        onValueChange = onpwValueChange,
        maxLines = 1,
        label = { Text(text = "PW")},
        singleLine = true
    )
}