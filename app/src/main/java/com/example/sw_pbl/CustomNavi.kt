import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sw_pbl.loadingviews8re.LoadingviewS8re

import com.example.sw_pbl.loginviews8.LoginviewS8
import com.example.sw_pbl.mainviewres8.MainviewReS8
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import kotlinx.coroutines.delay

@Composable
fun CustomNavi() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "LoadingView"
    ) {
        composable("LoadingView") {
            CustomDelayLoadingView(
                modifier= Modifier.rowWeight(1.0f).columnWeight(1.0f),
                navController= navController)
        }
        composable("Home") {
            MaterialTheme {
                RelayContainer {
                    MainviewReS8(
                            onClickToAdmin = {
                                           navController.navigate("Admin")
                            },
                            clickmenuJA = {},
                            clickmenuAram = {},
                            clickmenuEdu1 = {},
                            clickmenuEdu2 = {},
                            modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                    )                }
            }

        }

        composable("Admin") {
            MaterialTheme {
                RelayContainer {
                    LoginviewS8(
                        onLoginBtnTapped = {},
                        pwText = "PW ",
                        idText = "ID  ",
                        titleLoadingviewTextContent = buildAnnotatedString {
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
                        modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                    )
                }
            }

        }

        composable("CafeInfo"){
            //CafeInfo()
        }

        composable("LoginPage") {
            //CustomAuth()
        }

    }
}


@Composable
fun CustomDelayLoadingView(modifier: Modifier = Modifier, navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2000) // simulate delay

        navController.navigate("Home") {

            //pop up from NavigationBackStack
            popUpTo("LoadingView") {
                inclusive = true
            }
        }
    }

    LoadingviewS8re(
       modifier = modifier
   )

}

@Preview(showSystemUi = true)
@Composable
fun ShowCustomDelayLoadingView(){
    MaterialTheme {
        RelayContainer {
            MainviewReS8(
                onClickToAdmin = {
                },
                clickmenuJA = {},
                clickmenuAram = {},
                clickmenuEdu1 = {},
                clickmenuEdu2 = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )                }
    }
}