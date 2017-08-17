/*
 * Copyright (c) 2017. Core Logic
 */

package com.doapps.android.domain.usecase

import com.corelogic.foundation.presentation.view.LifeCycle
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created on 6/22/17.
 */
abstract class LifeCycleAwareFunc4<in T1, in T2, in T3, in T4, R>: LifeCycleAwareFunc() {

    protected abstract fun buildUseCaseObservable(t1: T1, t2: T2, t3: T3, t4: T4 ): Observable<R>

    open fun execute(t1: T1, t2: T2, t3: T3, t4: T4, useCaseSubscriber: Subscriber<R>, lifeCycleObservable: Observable<LifeCycle>, lifeCycle: LifeCycle) {
        this.subscription = this.buildUseCaseObservable(t1, t2, t3, t4)
                                .takeUntil(lifeCycleObservable.filter { lc -> lc == lifeCycle })
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(useCaseSubscriber)
    }
}