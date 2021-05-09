package hr.ferit.mmfabing.birdcount.ui

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.ferit.mmfabing.birdcount.model.BirdCounter

class BirdCounterViewModel (private val birdCounter: BirdCounter): ViewModel() {

    private val counter = MutableLiveData<BirdCounter>(BirdCounter())

    private val _yellowBirdsSeen = MutableLiveData(birdCounter.yellowBirdsSeen)
     val yellowBirdsSeen: LiveData<Int> = _yellowBirdsSeen

    private val _redBirdsSeen = MutableLiveData(birdCounter.redBirdsSeen)
    val redBirdsSeen: LiveData<Int> = _redBirdsSeen

    private val _grayBirdsSeen = MutableLiveData(birdCounter.yellowBirdsSeen)
    val grayBirdsSeen: LiveData<Int> = _grayBirdsSeen

    private val _blueBirdsSeen = MutableLiveData(birdCounter.yellowBirdsSeen)
    val blueBirdsSeen: LiveData<Int> = _blueBirdsSeen

    private val _birdsSeen = MutableLiveData(birdCounter.birdsSeen)
    val birdsSeen: LiveData<Int> = _birdsSeen

    private val _reset = MutableLiveData(birdCounter.reset)
    val reset: LiveData<Int> = _reset

    fun seeYellowBird(){
        birdCounter.seeYellowBird()
        _yellowBirdsSeen.postValue(birdCounter.yellowBirdsSeen)
        _birdsSeen.postValue(Color.parseColor("#FDFF00"))
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun seeRedBird(){
        birdCounter.seeRedBird()
        _redBirdsSeen.postValue(birdCounter.redBirdsSeen)
        //_birdsSeen.postValue(Color.WHITE)
        _birdsSeen.postValue(birdCounter.birdsSeen)

    }

    fun seeGrayBird(){
        birdCounter.seeGrayBird()
        _grayBirdsSeen.postValue(birdCounter.grayBirdsSeen)
        //_birdsSeen.postValue(Color.GRAY)
        _birdsSeen.postValue(birdCounter.birdsSeen)


    }

    fun seeBlueBird(){
        birdCounter.seeBlueBird()
        _blueBirdsSeen.postValue(birdCounter.blueBirdsSeen)
        //_birdsSeen.postValue(Color.BLUE)
        _birdsSeen.postValue(birdCounter.birdsSeen)

    }

    fun reset(){
        birdCounter.reset()
        _reset.postValue(birdCounter.reset)
        _birdsSeen.postValue(0)
    }



}
