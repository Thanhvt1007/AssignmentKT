//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import java.util.List;

public abstract class SoftwareDAO<Entity, Key> {

    abstract public void insert(Entity E);

    abstract public void update(Entity E);

    abstract public void delete(Key ID);
    
    abstract public Entity SelectByID(Key ID);
    
    abstract public List<Entity> SelectAll();
    
    abstract public List<Entity> SelectBySQL(String sql, Object... args);
}
