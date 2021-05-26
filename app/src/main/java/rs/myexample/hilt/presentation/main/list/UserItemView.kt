package rs.myexample.hilt.presentation.main.list

import rs.myexample.hilt.domain.Post

data class UserItemView(
    val id: Long,
    val title: String,
    val body: String
)

fun Post.toUserItemView() =
    UserItemView(
        id = id,
        title = title,
        body = body
    )