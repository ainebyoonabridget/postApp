package repository

import com.example.postsapps.api.ApiClient
import com.example.postsapps.api.ApiInterface

class PostsRepository {
class PostsRepository(val apiClient: ApiInterface = ApiClient.buildService(ApiInterface::class.java)) {
    suspend fun getPosts(): Response<Post>> =withContext(context:Dispatchers.IO+NonCancellable)
    {}
    val response = apiClient.getPosts()
    if(response.isSuccessful)
    {}
    val posts = response.body() as List<post>
    savePosts(posts)
}
    return@withContext response
}
    suspend fun savePosts(postsList: List<Post>)=WithContext(Dispartchers.IO){this:coroutineScope
     val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
    postsList.forEach {post
     database.PostDoa().insertPost(post)
    }

    }
}