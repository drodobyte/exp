package drodobytecom.core.creation

abstract class NodeAdapterBuilder<T> extends NodeBuilder {

    private int calls

    abstract protected T adapt(Node node)


    @Override
    protected Object doInvokeMethod(String methodName, Object name, Object args) {
        doInvokeMethodAndCallDoneOnEnd methodName, name, args
    }

    private Object doInvokeMethodAndCallDoneOnEnd(String methodName, name, args) {
        calls++
        Node node = super.doInvokeMethod(methodName, name, args) as Node
        calls--
        if (calls == 0)
            return adapt(node)
        return node
    }
}
