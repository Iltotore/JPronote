package fr.jpronote.handler;

public enum Subject
{

    MATH("MATHEMATIQUES"),
    ANG("ANGLAIS LV1"),
    ESP("ESPAGNOL LV2"),
    ALL("ALLEMAND LV2"),
    FR("FRANCAIS"),
    HG("HISTOIRE_GEOGRAPHIE"),
    PHILO("PHILOSOHPIE"),
    PC("SC.PHYSIQ.ET CHIMIQ."),
    SI("SCIENCES INGENIEUR"),
    CONSTRU("CONSTRUCTION"),
    SVT("SCIENCES VIE & TERRE"),
    SPORT("ED.PHYSIQUE & SPORT. > ED.PHYSIQUE & SPORT.");

    private String name;

    Subject(String name) {
        this.name = name;
    }
}
