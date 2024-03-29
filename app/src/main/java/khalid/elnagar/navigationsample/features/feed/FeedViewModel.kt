package khalid.elnagar.navigationsample.features.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import khalid.elnagar.navigationsample.entities.Boat
import java.lang.Thread.sleep

class FeedViewModel : ViewModel() {
    private val bootsLiveData =
        MutableLiveData<MutableList<Boat>>().apply { value = mutableListOf() }
    private val disposable: CompositeDisposable = CompositeDisposable()

    private val boatsObservable: Observable<Boat> by lazy {

        Observable
            .create<Boat> { emitter ->
                //make fake data
                val boats = mutableListOf<Boat>()
                Boat("khalid", "Egypt", "200 $")
                    .also { boats.add(it) }
                    .copy(name = "yousef")
                    .also { boats.add(it) }
                    .copy(name = "mohamed")
                    .also { boats.add(it) }
                //emit it
                for (boat in boats) {
                    sleep(100)
                    emitter.onNext(boat)
                }
                //complete
                emitter.onComplete()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    fun getBoatsLiveData(): LiveData<List<Boat>> {
        return Transformations.map(bootsLiveData) {
            it.toList()
        }
    }

    fun startLoading() {
        with(bootsLiveData) {
            if (value.isNullOrEmpty())
                disposable.add(boatsObservable.subscribe { boat ->
                    value = value?.also { it.add(boat) }
                })
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    fun findBoat(index: Int): Boat = //dummy business logic
        bootsLiveData.value?.getOrNull(index) ?: Boat("khalid", "Egypt", "200 $")


}
