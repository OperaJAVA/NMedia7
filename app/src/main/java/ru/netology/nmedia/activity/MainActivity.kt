package ru.netology.nmedia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.ru.netology.nmedia.activity.dto.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding
import kotlin.properties.ReadOnlyProperty


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                like.textDirection = post.likes
                share.textDirection = post.share
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )

            }
            binding.like.setOnClickListener {
                viewModel.like()
            }
            binding.share.setOnClickListener {
                viewModel.share()
            }

            //        binding.author.setOnClickListener {
//            ////сворачивает текст
//            binding.author.isSingleLine = !binding.author.isSingleLine
//        }


        }
    }

    private fun viewModels(): ReadOnlyProperty<Nothing?, PostViewModel> {

        return this.viewModels()
    }

    private fun Int.changeCountersImaging(): String {

        return when (this) {
            in 0..999 -> toString()
            in 1000..9999 ->
                if ((this % 1000) == 0) {
                    (this / 1000).toString() + "K"
                } else if (this % 1000 < 100) {
                    (this / 1000).toString() + "K"
                } else (this / 1000).toString() + "." + ((this / 100) % 10).toString() + "K"

            in 10000..999999 -> (this / 1000).toString() + "K"

            in 1000000..10000000 ->
                if ((this % 1000000) == 0) {
                    (this / 1000000).toString() + "M"
                } else if (this % 1000000 < 100000) {
                    (this / 1000000).toString() + "M"
                } else (this / 1000000).toString() + "." + ((this / 100000) % 10).toString() + "M"

            else -> "0"
        }
    }
}

