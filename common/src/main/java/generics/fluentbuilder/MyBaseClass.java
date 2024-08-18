package generics.fluentbuilder;

public abstract class MyBaseClass<SELF extends MyBaseClass<SELF>> extends SelfTyped<SELF> {

    MyBaseClass() {
    }

    public SELF baseMethod() {
        return self();
    }
}
