package ru.netology.nmedia.activity.ru.netology.nmedia.activity.dto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.activity.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        published = "21 мая в 18:36",
        like = 100,
        likedByMe = false,
        share = 999,
        shareByMe = false
    )
    private val data = MutableLiveData(post)
    override fun get(): LiveData<Post> = data

    override fun like() {
        post = post.copy(
            likedByMe = !post.likedByMe,
            like = if (post.likedByMe) post.like - 1 else post.like + 1
        )
        data.value = post
    }

    override fun share() {
        post = post.copy(
            shareByMe = post.shareByMe,
            share = post.share + 1
        )
        data.value = post
    }
}