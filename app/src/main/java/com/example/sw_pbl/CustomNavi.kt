import android.content.Intent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.sw_pbl.customadmin.CustomAdmin
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CustomNavi() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Loading"
    ) {
        composable("Loading") {
            CustomDelayLoadingView(
                modifier= Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f),
                navController= navController
            )
        }
        composable("Mainview") {
            MaterialTheme {
                RelayContainer {
                    Mainview(
                            onLoginAdmin = {
                                           navController.navigate("CustomLoginviewS8")
                            },
                            onMenuJA = {},
                            onMenuAram = {},
                            onMenuEdu1 = {},
                            onMenuEdu2 = {},
                            modifier = Modifier
                                .rowWeight(1.0f)
                                .columnWeight(1.0f)
                    )                }
            }

        }

        composable("CustomLoginviewS8") {
            MaterialTheme {
                RelayContainer {
                    var idtext by remember { mutableStateOf("") }
                    var pwtext by remember { mutableStateOf("") }
                    val onidValueChange = { it: String ->
                        idtext = it
                    }
                    val onpwValueChange = { it: String ->
                        pwtext = it
                    }
                    CustomAuth(
                        idtext = idtext,
                        pwtext = pwtext,
                        onidValueChange = onidValueChange,
                        onpwValueChange = onpwValueChange,
                        navController = navController
                    )
                }
            }
        }

            composable("Admin") {
                val context = LocalContext.current                val collectionName = "Upload_news"
                val documentName = "ARAM"
                val fieldName = "news"
                FirebaseApp.initializeApp(context)
                val db = FirebaseFirestore.getInstance()
                val upNews = db.collection(collectionName).document(documentName)
                var newstext by remember { mutableStateOf("") }
                val onnewsValueChange = { it: String ->
                    newstext = it
                }
                CustomAdmin(

                    newstext = newstext,
                    onnewsValueChange = onnewsValueChange,
                    onUploadPicTapped = {launcher.launch(createOpenDocumentIntent())},
                    onUploadNewsTapped = {upNews.update(fieldName, newstext)}
                )
            }
    }
}
private fun createOpenDocumentIntent(): Intent {
    return Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
        addCategory(Intent.CATEGORY_OPENABLE)
        type = "image/*"
    }
}

}

            composable("LoginPage") {

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
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}


