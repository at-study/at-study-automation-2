package at.study.redmine.db.requests;

import at.study.redmine.model.Entity;

public interface Read<T extends Entity> {

    T read(Integer id);

}
