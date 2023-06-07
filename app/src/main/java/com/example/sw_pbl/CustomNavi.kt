import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sw_pbl.loading.Loading
import com.example.sw_pbl.mainview.Mainview
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight
import com.google.relay.compose.RelayContainer
import kotlinx.coroutines.delay

@Composable
fun CustomNavi() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Loading"
    ) {
        composable("Loading") {
            CustomDelayLoadingView(
                modifier= Modifier.rowWeight(1.0f).columnWeight(1.0f),
                navController= navController
            )
        }
        composable("Mainview") {
            MaterialTheme {
                RelayContainer {
                    Mainview(
                            onLoginAdmin = {
                                           navController.navigate("Admin")
                            },
                            onMenuJA = {},
                            onMenuAram = {},
                            onMenuEdu1 = {},
                            onMenuEdu2 = {},
                            modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                    )                }
            }

        }

        composable("Admin") {
            MaterialTheme {
                RelayContainer {
//                    LoginviewS8(
//                        onLoginBtnTapped = {},
//                        pwText = "PW ",
//                        idText = "ID  ",
//                        titleLoadingviewTextContent = buildAnnotatedString {
//                            withStyle(style = SpanStyle(fontSize = 50.0.sp)) {
//                                append("관리자")
//                            }
//                            withStyle(
//                                style = SpanStyle(
//                                    fontSize = 50.0.sp,
//                                    letterSpacing = 10.0.sp
//                                )
//                            ) {
//                                append(" ")
//                            }
//                            withStyle(style = SpanStyle(fontSize = 50.0.sp)) {
//                                append("로그인")
//                            }
//                        },
//                        modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
//                    )
//                }
                }
            }
        }

            composable("CafeInfo") {
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

        navController.navigate("Mainview") {

            //pop up from NavigationBackStack
            popUpTo("Loading") {
                inclusive = true
            }
        }
    }

    Loading(
        modifier = modifier
    )
 }


@Preview(showSystemUi = true)
@Composable
fun ShowCustomDelayLoadingView() {
    val navController = rememberNavController()

    MaterialTheme {
        RelayContainer {
            Mainview(
                onLoginAdmin = {
                    navController.navigate("Admin")
                },
                onMenuJA = {},
                onMenuAram = {},
                onMenuEdu1 = {},
                onMenuEdu2 = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}


