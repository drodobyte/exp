package drodobytecom.mathexpression.presenter

import drodobytecom.mathexpression.view.View

abstract class Presenter<V extends View> {

    protected V view

    Presenter(V view) {
        this.view = view
    }

    abstract void present(Closure response)
}