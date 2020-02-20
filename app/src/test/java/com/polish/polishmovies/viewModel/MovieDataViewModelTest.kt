package com.polish.polishmovies.viewModel

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class MovieDataViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()



}