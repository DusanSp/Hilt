package rs.myexample.hilt.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import rs.myexample.hilt.di.IoDispatcher
import javax.inject.Inject

@ExperimentalCoroutinesApi
class FileLogger
@Inject constructor(
    private val fileUtils: FileUtils,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) {
    private val channel = Channel<String>(Channel.UNLIMITED)
    private var fileName: String = "default.txt"
    private val scope = CoroutineScope(ioDispatcher)

    init {
        scope.launch {
            channel.consumeEach {
                fileUtils.write(fileName, it)
            }
        }
    }

    fun writeMessage(fileName: String, data: String) {
        this.fileName = fileName
        channel.offer(data)
    }
}