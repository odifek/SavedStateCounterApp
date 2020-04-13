package com.globalaccelerex.example.savedstateapp

import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)

}