package generics.fluentbuilder;

public abstract class SelfTyped<SELF extends SelfTyped<SELF>> {

    abstract SELF self();
}
