# Heap TakeHome Project
August 2, 2021

### SDK
- The SDK was built trying to follow a clean architecture, similar to MVVM.

logEvent(application: Application, location: String, action: String)
- Use this function to track an action in a particular location in the code
i.e. logEvent(applicationContext, "MyActivity", "button pressed")

uploadEvents(application: Application)
- Use this function when you want to upload your events to the backend service.
i.e. uploadEvents(applicationContext)

### Usage
- The core of my SDK is to log events via the SDK object, and then store them in a Room DB. The user
then has the choice to upload them on demand (I decided to just have it on a button). This could be
extended to use WorkManager or some other network-scheduler so that the events could be uploaded to the
network automatically on a cadence.
- In the theme of automatically gathering events, I decided it would be useful to create an Abstract
Fragment that would track all lifecycle events. The user simply needs to extend their fragment with
Analytics Fragment, and we will track the lifecycle events that occur. This paradigm could be extended
to other simple types of UI components (Activity, View etc). The events gathered right now are a
Fragment's onCreate, onResume, onPause, onStop, onDestroy.
- The user has the ability to use the SDK.logEvent call to track any other non-lifecycle related
events if they want. For these calls, it is on the user to provide a CoroutineScope (or other async
method if not using coroutines) to run the logEvent operation.

##
Libraries
- Networking: OKHttp, Retrofit
- Database: Room
- UI Code: Mostly default Android Studio App

## Things I would have added with more time
### Dependency Injection
- This is something I wanted to add as it would help with decoupling some code and making things
cleaner (i.e. not passing application contexts and repositories around via constructors) but I was
having a tough time setting up Toothpick (the DI library I am familiar with). If I had a couple more
hours to spend, this is something I would have added. As it makes things a lot easier to test + readable

###Testing
- I decide to leave out tests for the sake of time. Without a DI library, objects get difficult to mock.

