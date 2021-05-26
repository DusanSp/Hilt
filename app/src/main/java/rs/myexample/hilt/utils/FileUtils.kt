package rs.myexample.hilt.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import java.io.File
import java.io.IOException
import javax.inject.Inject

@ExperimentalCoroutinesApi
class FileUtils
@Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun write(fileName: String, data: String) {
        val file = File("${context.filesDir}/$fileName")

        val stringBuilder = StringBuilder().apply {
            if (file.exists()) {
                read(fileName)?.let {
                    append(it)
                }
            }
            append(data)
        }

        try {
            file.writer().use {
                it.write(stringBuilder.toString())
            }
        } catch (e: IOException) {
            Timber.e(e, e.localizedMessage)
        }
    }

    private fun read(fileName: String): String? {
        val file = File("${context.filesDir}/$fileName")
        val stringBuilder: StringBuilder = StringBuilder()

        if (file.exists()) {
            file.reader().use {
                it.ready()
                stringBuilder.append(it.readText())
            }
        }

        return stringBuilder.toString()
    }
}