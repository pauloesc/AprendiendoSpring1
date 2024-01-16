In Hibernate, you can create a foreign key association between two entities using annotations or XML mappings. Here's a brief overview using annotations, which is a common approach in modern Hibernate applications.

Let's assume you have two entities, `ParentEntity` and `ChildEntity`, and you want to create a foreign key association from `ChildEntity` to `ParentEntity`.

1. **Define the ParentEntity:**

```java
@Entity
@Table(name = "parent_entity")
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    // Other fields and methods...

}
```

2. **Define the ChildEntity with a Foreign Key Association:**

```java
@Entity
@Table(name = "child_entity")
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long id;

    // Other fields...

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    private ParentEntity parent;

    // Other fields and methods...

}
```

In the `ChildEntity` class, the `@ManyToOne` annotation is used to define the many-to-one relationship, and the `@JoinColumn` annotation is used to specify the foreign key column. The `name` attribute is the name of the foreign key column in the `child_entity` table, and `referencedColumnName` is the name of the primary key column in the `parent_entity` table.
