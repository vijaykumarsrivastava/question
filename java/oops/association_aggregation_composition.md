**association, aggregation and composition?**

For two objects, Foo and Bar the relationships can be defined

**Composition** - I own an object and I am responsible for its lifetime. When Foo dies, so does Bar
```
public class Foo {
    private Bar bar = new Bar(); 
}
```

**Aggregation** - I have an object which I've borrowed from someone else. When Foo dies, Bar may live on.
```
public class Foo { 
    private Bar bar; 
    Foo(Bar bar) { 
       this.bar = bar; 
    }
}
```

**Association** - I have a relationship with an object. Foo uses Bar
```
public class Foo {         
    private Bar bar;
};
```
the key is that Bar is semantically related to Foo rather than just a dependency (like an int or string).
