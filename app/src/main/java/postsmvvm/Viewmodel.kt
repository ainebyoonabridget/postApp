package postsmvvm

class Viewmodel {
class postsViewModel(val postsRepository:PostRepository): ViewModel(){
    var postsLiveData = MutableLiveData<post>>()
    var postfailedLiveData = MutableLiveData<String>()

    fun getPosts(){
        viewModelScope.launch{this:coroutineScope
        val response = PostRepository.getPosts()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
