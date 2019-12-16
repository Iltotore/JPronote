package fr.jpronote.auth;

public enum CAS {

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

    CAS(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}