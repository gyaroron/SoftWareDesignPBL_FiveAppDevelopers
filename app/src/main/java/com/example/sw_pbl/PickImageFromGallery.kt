//package com.example.sw_pbl
//
//import android.net.Uri
//import android.util.Log
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.semantics.Role.Companion.Image
//import androidx.compose.ui.unit.dp
//import com.google.firebase.ktx.Firebase
//import com.google.firebase.storage.ktx.storage
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
//import java.util.UUID
//
//@Composable
//fun PickImageFromGallery() {
//
//    fun uploadImageToFirebase(uri: Uri) {
//        val current = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")
//        val formatted = current.format(formatter)
//
//        val storage = Firebase.storage
//        val storageRef = storage.reference
//        val imageRef = storageRef.child("images/$formatted")
//
//        val uploadTask = imageRef.putFile(uri)
//        uploadTask.addOnSuccessListener {
//            // get the download url
//            imageRef.downloadUrl.addOnSuccessListener { uri ->
//                // use this url to retrieve the image later
//                Log.d("DownloadUrl", uri.toString())
//            }
//        }.addOnFailureListener {
//            // Handle unsuccessful uploads
//        }
//    }
//
//    val pickImageContract = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//        uri?.let {
//            // upload to Firebase storage
//            uploadImageToFirebase(uri)
//        }
//    }
//}
//
//@Composable
//fun ImageFromFirebase(url: String) {
//    val painter = rememberAsyncImagePainter(
//        data = url,
//        builder = {
//            crossfade(true)
//        }
//    )
//
//    Image(
//        painter = painter,
//        contentDescription = "My Image",
//        modifier = Modifier.size(200.dp)
//    )
//}
