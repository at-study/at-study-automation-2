package at.study.redmine.model;

public interface Creatable<T extends Entity> {

    T create();

}
