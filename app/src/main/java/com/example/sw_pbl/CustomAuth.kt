import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.runtime.setValue

@Composable
fun CustomAuth() {
    var idtext by remember { mutableStateOf("") }
    var pwtext by remember { mutableStateOf("") }
    val onidValueChange = { it: String ->
        idtext = it
    }
    val onpwValueChange = { it: String ->
        pwtext = it
    }
    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val accountCollectionName = "login_account" // 파베 hjtestpbl 컬렉션

//    CustomLoginviewS8(
//        onBtnLoginTapped = {
//            db.collection(accountCollectionName)
//                .get()
//                .addOnSuccessListener { documents ->
//                    for (document in documents) {
//                        val id = document.getString("ID")
//                        val pw = document.getString("PW")
//                        if (id == idtext && pw == pwtext) {
//                            Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show()
//                            break
//                        }
////                                        else
////                                        {
////                                            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
////                                            break
////                                        }
//                    }
//                }
//        }//: onLoginButton
//        ,
//        idtext = idtext,
//        onidValueChange = onidValueChange,
//        pwtext = pwtext,
//        onpwValueChange = onpwValueChange
//    )
}