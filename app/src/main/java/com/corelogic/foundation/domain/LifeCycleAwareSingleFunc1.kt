/*
 * Copyright (c) 2017. Core Logic
 */

package com.doapps.android.domain.usecase


import com.corelogic.foundation.presentation.view.LifeCycle
import rx.Observable
import rx.Single
import rx.SingleSubscriber
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created on 6/22/17.
 */
abstract class LifeCycleAwareSingleFunc1<in T,R>: LifeCycleAwareFunc() {

    protected abstract fun buildUseCaseObservable(t: T): Single<R>

    open fun execute(t: T, useCaseSubscriber: SingleSubscriber<R>, lifeCycleObservable: Observable<LifeCycle>, lifeCycle: LifeCycle) {
        this.subscription = this.buildUseCaseObservable(t)
                                .takeUntil(lifeCycleObservable.filter { lc -> lc == lifeCycle })
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(useCaseSubscriber)
    }

}