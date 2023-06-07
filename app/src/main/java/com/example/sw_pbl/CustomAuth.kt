//import android.annotation.SuppressLint
//import android.util.Log
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import com.firebase.ui.auth.AuthUI.TAG
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//
//@Composable
//fun CustomAuth() {
//    // Remember the user input
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
////
////    LoginPage(
////        onID = { email = it },
////        onPW = { password = it },
////        onLoginButton = { signIn(email, password) }
////    )
//
//    // Collect user inputs
//    TextField(
//        value = email,
//        onValueChange = { newEmail -> email = newEmail },
//        label = { Text("Email") }
//    )
//    TextField(
//        value = password,
//        onValueChange = { newPassword -> password = newPassword },
//        label = { Text("Password") }
//    )
//
////    LoginPage(
////        onLoginButton = { signIn(email, password) }
////    )
//}
////
////@SuppressLint("RestrictedApi")
////private fun signIn(email: String, password: String) {
////
////    val auth = Firebase.auth
////    auth.signInWithEmailAndPassword(email, password)
////        .addOnCompleteListener { task ->
////            if (task.isSuccessful) {
////                // Sign in success, update UI with the signed-in user's information
////                Log.d(TAG, "signInWithEmail:success")
////                val user = auth.currentUser
////                // update UI here
////            } else {
////                // If sign in fails, display a message to the user.
////                Log.w(TAG, "signInWithEmail:failure", task.exception)
////                // update UI here
////            }
////        }
////}
//
//
//@SuppressLint("RestrictedApi")
//private fun signIn(email: String, password: String) {
//    val auth = Firebase.auth
//    auth.signInWithEmailAndPassword(email, password)
//        .addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                // Sign in success, update UI with the signed-in user's information
//                Log.d(TAG, "signInWithEmail:success")
//                val user = auth.currentUser
//                // update UI here
//            } else {
//                // If sign in fails, display a message to the user.
//                Log.w(TAG, "signInWithEmail:failure", task.exception)
//                // update UI here
//            }
//        }
//}