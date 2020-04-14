Saved State App (Demo)
======================

Android [ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel) normally takes care of configuration changes for us, so that we do not need to bother with saving of state during configuration change.

But when it comes to system initiated process death, we have to intentionally handle this else our app might behave inconsistently when the user returns to it, say from recent apps list.

So we need [viewmodel-savedstate](https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate) to take care of things for us.

This demo app demonstrate how this can be done while still using Dagger as dependency injection tool. Unfortunately, we still have to manually create a Factory for each ViewModel. Well, everything good thing comes with one compromise or the other

Inspired by [This article](https://proandroiddev.com/saving-ui-state-with-viewmodel-savedstate-and-dagger-f77bcaeb8b08) and this [Video](https://www.youtube.com/watch?v=9fn5s8_CYJI)