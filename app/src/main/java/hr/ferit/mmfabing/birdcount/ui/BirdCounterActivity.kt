package hr.ferit.mmfabing.birdcount.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hr.ferit.mmfabing.birdcount.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BirdCounterActivity : AppCompatActivity() {

    private val viewModel by viewModel<BirdCounterViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.yellowBird.setOnClickListener { viewModel.seeYellowBird() }
            it.redBird.setOnClickListener { viewModel.seeRedBird() }
            it.grayBird.setOnClickListener { viewModel.seeGrayBird() }
            it.blueBird.setOnClickListener { viewModel.seeBlueBird() }
            it.resetCount.setOnClickListener { viewModel.reset() }

        }
        setContentView(binding.root)

        viewModel.birdsSeen.observe(this, { binding.birds.text = it.toString()})

        viewModel.yellowBirdsSeen.observe(this, {binding.birds.setBackgroundColor(Color.YELLOW) })
        viewModel.redBirdsSeen.observe(this, {binding.birds.setBackgroundColor(Color.RED)})
        viewModel.grayBirdsSeen.observe(this, {binding.birds.setBackgroundColor(Color.GRAY)})
        viewModel.blueBirdsSeen.observe(this, {binding.birds.setBackgroundColor(Color.BLUE)})

        viewModel.reset.observe(this, {binding.birds.setText("0")})
        viewModel.reset.observe(this, {binding.birds.setBackgroundColor(Color.WHITE)})



    }
}