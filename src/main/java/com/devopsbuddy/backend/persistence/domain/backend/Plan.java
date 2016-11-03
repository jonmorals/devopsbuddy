package com.devopsbuddy.backend.persistence.domain.backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Jonathan on 11/2/2016.
 */
@Entity
public class Plan implements Serializable{

    /** the serial version uid for serializable classes. */
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String name;

    public Plan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
