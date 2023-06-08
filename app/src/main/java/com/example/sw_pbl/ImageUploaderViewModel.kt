package com.example.sw_pbl

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch

class ImageUploaderViewModel: ViewModel() {
    private val _uploadState = mutableStateOf<UploadState>(UploadState.Idle)
    val uploadState: State<UploadState> = _uploadState

    fun uploadImage(contentResolver: ContentResolver, imageUri: Uri) {
        viewModelScope.launch {
            _uploadState.value = UploadState.Uploading
            val storageReference = FirebaseStorage.getInstance().getReference("testpicture/testImage.png")
            val inputStream = contentResolver.openInputStream(imageUri)
            if (inputStream != null) {
                storageReference.putStream(inputStream)
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