package ru.netology.nmedia.activity.dto

data class Post(
    val id:Long,
    val author:String,
    val content:String,
    val published:String,
    var likes:Int,
    var likedByMe:Boolean,
    var share:Int,
    var shareByMe:Boolean
)