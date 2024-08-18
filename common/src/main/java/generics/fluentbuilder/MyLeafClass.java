package generics.fluentbuilder;

public final class MyLeafClass extends MyBaseClass<MyLeafClass> {

    @Override
    MyLeafClass self() {
        return this;
    }

    public MyLeafClass leafMethod() {

        //logic
        return self(); //could also just return this
    }
}
