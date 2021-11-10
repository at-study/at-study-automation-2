package at.study.redmine.model.user;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    UNREGISTERED(0, "Не зарегистрирован"),
    ACTIVE(1, "Активен"),
    UNACCEPTED(2, "Не подтвержден"),
    LOCKED(3, "Заблокирован");

    public final int statusCode;
    public final String description;

    public static Status of(String description) {
        return Stream.of(values())
                .filter(status -> status.description.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не найдено Status по описанию " + description));
    }

}
