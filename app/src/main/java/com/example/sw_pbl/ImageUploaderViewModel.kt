package com.example.sw_pbl

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class ImageUploaderViewModel: ViewModel() {
    private val _uploadState = mutableStateOf<UploadState>(UploadState.Idle)
    val uploadState: State<UploadState> = _uploadState

    fun uploadImage(contentResolver: ContentResolver, imageUri: Uri, elem: String) {
        viewModelScope.launch {
            _uploadState.value = UploadState.Uploading
            val storagePath = "${elem}/foodImage.png"
            val storageReference = FirebaseStorage.getInstance().getReference(storagePath)
            val inputStream = contentResolver.openInputStream(imageUri)

            if (inputStream != null) {
                // Load the original bitmap
                val originalBitmap = BitmapFactory.decodeStream(inputStream)

                // Scale the bitmap
                val widthPx = 326  // Modify this as needed
                val heightPx = 180  // Modify this as needed
                val scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, widthPx, heightPx, true)

                // Convert the scaled bitmap to byte array
                val baos = ByteArrayOutputStream()
                scaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
                val data = baos.toByteArray()

                storageReference.putBytes(data)
                    .addOnSuccessListener {
                        _uploadState.value = UploadState.Success
                    }
                    .addOnFailureListener {
                        _uploadState.value = UploadState.Failed
                    }
            } else {
                _uploadState.value = UploadState.Failed
            }
        }
    }
}

enum class UploadState {
    Idle,
    Uploading,
    Completed,
    Failed,
    Success
}