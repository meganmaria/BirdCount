package hr.ferit.mmfabing.birdcount.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class BirdCounterAlternative {
    private val _yellowBirdsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val yellowBirdsSeen: LiveData<Int> = _yellowBirdsSeen
    private val _redBirdsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val redBirdsSeen: LiveData<Int> = _redBirdsSeen
    private val _grayBirdsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val grayBirdsSeen: LiveData<Int> = _grayBirdsSeen
    private val _blueBirdsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val blueBirdsSeen: LiveData<Int> = _blueBirdsSeen

    private val _reset: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val reset: LiveData<Int> = _reset

    val birdsSeen: MediatorLiveData<Int> = MediatorLiveData<Int>().apply {
        fun update() =  postValue((_yellowBirdsSeen.value ?: 0) + (_redBirdsSeen.value ?: 0) + (_grayBirdsSeen.value ?: 0) + (_blueBirdsSeen.value ?: 0))
        fun up() = postValue(_reset.value?: 0)
        addSource(_yellowBirdsSeen) { update() }
        addSource(_redBirdsSeen) { update() }
        addSource(_grayBirdsSeen) { update() }
        addSource(_blueBirdsSeen) { update() }
        addSource(_reset) {up()}
    }

    fun seeYellowBird() = _yellowBirdsSeen.value?.let { _yellowBirdsSeen.postValue(it + 1) }
    fun seeWhiteBird() = _redBirdsSeen.value?.let { _redBirdsSeen.postValue(it + 1) }
    fun seeGrayBird() = _grayBirdsSeen.value?.let { _grayBirdsSeen.postValue(it + 1) }
    fun seeBlueBird() = _blueBirdsSeen.value?.let { _blueBirdsSeen.postValue(it + 1) }
    fun reset() = _reset.let { _reset.postValue(0)}
}