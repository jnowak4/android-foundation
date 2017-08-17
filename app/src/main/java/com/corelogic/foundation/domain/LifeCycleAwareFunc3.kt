package com.doapps.android.domain.usecase


import com.corelogic.foundation.presentation.view.LifeCycle
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by seth bourget on 6/22/17.
 */
abstract class LifeCycleAwareFunc3<in T1, in T2, in T3, R>: LifeCycleAwareFunc() {

    protected abstract fun buildUseCaseObservable(t1: T1, t2: T2, t3: T3 ): Observable<R>

    open fun execute(t1: T1, t2: T2, t3: T3, useCaseSubscriber: Subscriber<R>, lifeCycleObservable: Observable<LifeCycle>, lifeCycle: LifeCycle) {
                this.subscription = this.buildUseCaseObservable(t1, t2, t3)
                                        .takeUntil(lifeCycleObservable.filter { lc -> lc == lifeCycle })
                                        .subscribeOn(Schedulers.newThread())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(useCaseSubscriber)
    }
}