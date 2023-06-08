import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.firestore.FirebaseFirestore
import androidx.navigation.NavController
import com.example.sw_pbl.customlogin.CustomLoginviewS8

@Composable
fun CustomAuth(
    idtext: String,
    pwtext: String,
    onidValueChange: (String) -> Unit,
    onpwValueChange: (String) -> Unit,
    navController: NavController
    ) {

    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val accountCollectionName = "login_account" // 파베 hjtestpbl 컬렉션

    CustomLoginviewS8(
        onBtnLogin = {
            db.collection(accountCollectionName)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val id = document.getString("ID")
                        val pw = document.getString("PW")
                        if (id == idtext && pw == pwtext) {
                            //(,document.getString("route"))

                            Toast.makeText(
                                context,
                                document.getString("route"),
                                Toast.LENGTH_SHORT
                            ).show()

                            navController.navigate("Admin")
                        }
                    }
                }
        }//: onLoginButton
        ,
        idtext = idtext,
        onidValueChange = onidValueChange,
        pwtext = pwtext,
        onpwValueChange = onpwValueChange
    )
}