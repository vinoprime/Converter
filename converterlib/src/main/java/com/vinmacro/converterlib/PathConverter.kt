package com.vinmacro.converterlib

import android.content.Context
import android.content.CursorLoader
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import java.io.File

class PathConverter(internal var mContext: Context) {


    fun UriReturnFromExternalActivity(intent: Intent): Uri? {
        //Uri return from external activity
        val orgUri: Uri?
        orgUri = intent.data
        return orgUri
    }


    fun PathConvertedFromUri(intent: Intent): String {
        //path converted from Uri
        val orgUri: Uri?
        orgUri = intent.data

        val proj = arrayOf(MediaStore.Images.Media.DATA)

        //This method was deprecated in API level 11
        //Cursor cursor = managedQuery(contentUri, proj, null, null, null);

        val cursorLoader = CursorLoader(mContext, orgUri, proj, null, null, null)
        val cursor = cursorLoader.loadInBackground()

        val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(column_index)
    }

    fun UriFromPath(intent: Intent): Uri {
        //Uri convert back again from path
        return Uri.fromFile(File(PathConvertedFromUri(intent)))
    }


}