package entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by alexanderlerma on 10/17/16.
 */
@Document
public class Category implements Serializable{
    @Id
    private ObjectId id;
    private String name;
    private ObjectId parent;
    private String slug;
    private List<Category> ancestors;

    public Category() {}


    public Category(String name, ObjectId parent, String slug, List<Category> ancestors) {
        this.name = name;
        this.parent = parent;
        this.slug = slug;
        this.ancestors = ancestors;
    }

    public Category(String name, ObjectId parent, String slug) {
        this(name, parent, slug, new ArrayList<>());
    }

    public void addAncestorCategory(Category category) {
        if (category != null)
            ancestors.add(category);
    }

    public List<Category> getAncestors() {
        return new ArrayList<>(ancestors);
    }

    public ObjectId getId() {
        return id;
    }

}
