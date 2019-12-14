package fr.jpronote.auth;

public enum SessionContext {

    AC_GRENOBLE("ac-grenoble"),
    AC_MONTPELLIER("ac-montpellier"),
    AC_REIMS("ac-reims"),
    AC_ROUEN("ac-rouen"),
    ELYCEE("elycee"),
    MBN("mbn"),
    MIP("mip"),
    PARENT("parent"),
    TOUTATICE("toutatice"),
    NONE("none");

    private String id;

    SessionContext(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}