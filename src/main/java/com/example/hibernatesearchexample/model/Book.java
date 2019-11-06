package com.example.hibernatesearchexample.model;


import lombok.Data;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Indexed
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    private String name;

    @IndexedEmbedded
    @ManyToMany
    private Set<Author> author = new HashSet<>();
}
