package hr.ferit.mmfabing.birdcount.model

import kotlin.math.absoluteValue

class BirdCounter {

    var yellowBirdsSeen: Int = 0
        private set

    var redBirdsSeen: Int = 0
        private set

    var grayBirdsSeen: Int = 0
        private set

    var blueBirdsSeen: Int = 0
        private set

    var reset: Int = 0
        private set

    val birdsSeen
        get() = yellowBirdsSeen + redBirdsSeen + grayBirdsSeen + blueBirdsSeen


    fun seeYellowBird() = yellowBirdsSeen++
    fun seeRedBird() = redBirdsSeen++
    fun seeGrayBird() = grayBirdsSeen++
    fun seeBlueBird() = blueBirdsSeen++
    fun reset() = 0
}