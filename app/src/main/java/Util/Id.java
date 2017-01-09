package Util;

/**
 * Created by Hance on 2016-12-23.
 */
public class Id {
    private static Id ourInstance = new Id();

    public static int ArtifactId = 0;

    public static Id getInstance() {
        return ourInstance;
    }

    private Id() {
    }
}
