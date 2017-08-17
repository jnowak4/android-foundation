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
abstract class LifeCycleAwareSingleFunc0<R>: LifeCycleAwareFunc() {

    protected abstract fun buildUseCaseObservable(): Single<R>

    open fun execute(useCaseSubscriber: SingleSubscriber<R>, lifeCycleObservable: Observable<LifeCycle>, lifeCycle: LifeCycle) {
        this.subscription = this.buildUseCaseObservable()
                                .takeUntil(lifeCycleObservable.filter { lc -> lc == lifeCycle })
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(useCaseSubscriber)
    }
}