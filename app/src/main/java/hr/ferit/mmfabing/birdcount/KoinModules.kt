package hr.ferit.mmfabing.birdcount

import hr.ferit.mmfabing.birdcount.model.BirdCounter
import hr.ferit.mmfabing.birdcount.ui.BirdCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<BirdCounter> { BirdCounter() }
}

val viewModelModule = module {
    viewModel<BirdCounterViewModel> { BirdCounterViewModel(get()) }
}