import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
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
import com.google.firebase.storage.FirebaseStorage
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import com.example.sw_pbl.ImageUploaderViewModel

@Composable
fun CustomNavi() {

    val navController = rememberNavController()
    val newstext = remember { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = "Loading"
    ) {
        composable("Loading") {
            CustomDelayLoadingView(
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f),
                navController = navController
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
                    )
                }
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
            val context = LocalContext.current
            val viewModel = remember { ImageUploaderViewModel() }
            val launcher =
                rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    if (result.resultCode == Activity.RESULT_OK) {
                        val selectedImageUri = result.data?.data
                        if (selectedImageUri != null) {
                            viewModel.uploadImage(
                                context.contentResolver,
                                imageUri = selectedImageUri
                            )
                        }
                    }
                }

            val collectionName = "Upload_news"
            val documentName = "ARAM"
            val fieldName = "news"
            // FirebaseApp.initializeApp(context)
            val db = FirebaseFirestore.getInstance()
            val upNews = db.collection(collectionName).document(documentName)

            CustomAdmin(

                context = context,
                collectionName = collectionName,
                documentName = documentName,
                fieldName = fieldName,
                db = db,
                upNews = upNews,
                newstext = newstext.value,
                onnewsValueChange = { value -> newstext.value = value },
                onUploadPicTapped = { launcher.launch(createOpenDocumentIntent()) },
                onUploadNewsTapped = { upNews.update(fieldName, newstext) }
            )


    }

            composable("LoginPage") {

            }

    }

}
private fun createOpenDocumentIntent(): Intent {
    return Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
        addCategory(Intent.CATEGORY_OPENABLE)
        type = "image/*"
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


