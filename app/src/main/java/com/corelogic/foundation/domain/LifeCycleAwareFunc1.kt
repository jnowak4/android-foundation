package com.doapps.android.domain.usecase


import com.corelogic.foundation.presentation.view.LifeCycle
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by seth bourget on 6/22/17.
 */

abstract class LifeCycleAwareFunc1<in T,R>: LifeCycleAwareFunc() {


    protected abstract fun buildUseCaseObservable(t: T): Observable<R>


    open fun execute(t: T, useCaseSubscriber: Subscriber<R>, lifeCycleObservable: Observable<LifeCycle>, lifeCycle: LifeCycle) {
        this.subscription = this.buildUseCaseObservable(t)
                .takeUntil(lifeCycleObservable.filter { lc -> lc == lifeCycle })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(useCaseSubscriber)
    }
}
