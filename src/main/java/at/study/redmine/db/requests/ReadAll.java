package at.study.redmine.db.requests;

import java.util.List;

import at.study.redmine.model.Entity;

public interface ReadAll<T extends Entity> {

    List<T> readAll();

}
