package drodobytecom.mathexpression.view

abstract class View<Model> {

    protected UI ui

    View() {
        this.ui = new UI(System.out, System.in)
    }

    abstract void show(Model model)
}
