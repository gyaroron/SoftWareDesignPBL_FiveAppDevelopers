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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.example.sw_pbl.CustomDataaram
import com.example.sw_pbl.ImageUploaderViewModel
import com.example.sw_pbl.cen.CustomDatacen
import com.example.sw_pbl.customlogin.CustomLoginviewS8
import com.example.sw_pbl.edu.CustomDataedu
import com.example.sw_pbl.user.CustomPageview

val LocalTargetName = compositionLocalOf { mutableStateOf("") }

@Composable
fun CustomNavi() {

    val navController = rememberNavController()
    var newstext by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    val targetName = LocalTargetName.current

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
                        onMenuJA = { navController.navigate("Ja") },
                        onMenuAram = { navController.navigate("Aram") },
                        onMenuEdu1 = { navController.navigate("Edu1") },
                        onMenuEdu2 = { navController.navigate("Edu2") },
                        modifier = Modifier
                            .rowWeight(1.0f)
                            .columnWeight(1.0f)
                    )
                }
            }

        }
        // 관리자 로그인 페이지
        composable("CustomLoginviewS8") {
            MaterialTheme {
                RelayContainer {
                    var idtext by remember { mutableStateOf("") }
                    var pwtext by remember { mutableStateOf("") }
                    val onidValueChange = { it: String ->
                        idtext = it
                        targetName.value = it
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

        // 관리자 공지사항 및 사진 업로드 페이지
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
                                imageUri = selectedImageUri,
                                elem = targetName.value
                            )
                        }
                    }
                }

            val collectionName = "Upload_news"
            var documentName = targetName.value
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
                newstext = newstext,
                onnewsValueChange = { value ->
                    newstext = value },
                onUploadPicTapped = { launcher.launch(createOpenDocumentIntent()) },
                onUploadNewsTapped = {
                    upNews.update(fieldName, newstext) },
                onResetAllTapped2 = {
                    upNews.update(fieldName, "")
                }
            )


        }


        composable("Ja") {
            CustomPageview(
                // 건물 외관 버튼
                onLocPg1Tapped = {
                    navController.navigate("Datacen")
                },
                newsadmin = "JA1",
                breakfastFirestoreValue = "JA1",
                lunchFirestoreValue = "JA1",
                dinnerFirestoreValue = "JA1"
            )
        }


        composable("Aram") {
            CustomPageview(
                onLocPg1Tapped = {
                    navController.navigate("DataAram")
                },
                newsadmin = "ARAM",
                breakfastFirestoreValue = "ARAM",
                lunchFirestoreValue = "ARAM",
                dinnerFirestoreValue = "ARAM"
            )
        }


        composable("Edu1") {
            CustomPageview(
                onLocPg1Tapped = {
                    navController.navigate("DataEdu")
                },
                newsadmin = "EDU1",
                breakfastFirestoreValue = "EDU1",
                lunchFirestoreValue = "EDU1",
                dinnerFirestoreValue = "EDU1"
            )
        }


        composable("Edu2") {
            CustomPageview(
                onLocPg1Tapped = {
                    navController.navigate("DataEdu")
                },
                newsadmin = "EDU2",
                breakfastFirestoreValue = "EDU2",
                lunchFirestoreValue = "EDU2",
                dinnerFirestoreValue = "EDU2"
            )
        }


        composable("Datacen") {
            CustomDatacen()
        }


        composable("DataAram") {
            CustomDataaram()
        }


        composable("DataEdu") {
            CustomDataedu()
        }


    }

    @Composable
    fun UploadName(targetName: String, updateState: (String) -> Unit) {
        // 상태 업데이트 로직
        updateState(targetName)
    }

    @Composable
    fun ChangeName(
        name: String
    ) {

        // ProducerComposable을 호출하고, text 값을 업데이트한다
        UploadName(
            targetName = name
        ) { updatedText ->
            text = updatedText
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
        delay(1000) // simulate delay

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