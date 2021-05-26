package rs.myexample.hilt.data

import androidx.paging.PagingSource
import retrofit2.HttpException
import rs.myexample.hilt.domain.Post
import java.io.IOException

//class PostsDataSource(
//    private val postApi: PostApi,
//    private val startId: Long
//) : PagingSource<Long, Post>() {
//    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Post> {
//        return try {
//            val items = postApi.fetchPosts(
//                startId = params.key ?: startId,
//                limit = params.loadSize
//            )
//
//            LoadResult.Page(
//                data = items.map { it.toPost() },
//                prevKey = null,
//                nextKey = items.lastOrNull()?.id ?: 0
//            )
//        } catch (e: IOException) {
//            LoadResult.Error(e)
//        } catch (e: HttpException) {
//            LoadResult.Error(e)
//        }
//    }
//}