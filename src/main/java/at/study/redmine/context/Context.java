package at.study.redmine.context;

public class Context {
    // TODO: Заменить на ThreadLocal
    private static ThreadLocal<Stash> stash = new ThreadLocal<>();

    public static Stash getStash() {
        if (stash.get() == null) {
            stash.set(new Stash());
        }
        return stash.get();
    }

    public static void clearStash() {
        stash.set(null);
    }

}