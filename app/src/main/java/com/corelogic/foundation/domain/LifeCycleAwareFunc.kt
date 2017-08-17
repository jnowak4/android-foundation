package com.doapps.android.domain.usecase

import rx.Subscription
import rx.subscriptions.Subscriptions

/**
 * Created by seth bourget on 6/22/17.
 */
abstract class LifeCycleAwareFunc {
    protected var subscription: Subscription? = Subscriptions.empty()
    /**
     * Unsubscribes from current subscription.
     */
    open fun unsubscribe() {
        subscription?.unsubscribe()
    }
}