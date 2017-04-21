package com.joseph.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by joseph on 3/15/17.
 * Email: developergitch@outlook.com
 */
@MappedSuperclass
public class BaseModel implements Serializable {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
