package at.study.redmine.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreatableEntity extends Entity {

    protected LocalDateTime createdOn = LocalDateTime.now();
    protected LocalDateTime updatedOn = LocalDateTime.now();

}
