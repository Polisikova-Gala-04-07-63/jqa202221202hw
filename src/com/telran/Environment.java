package com.telran;

public class Environment {
    private long lastDeployTime;
    private long upDuration;
    private String currentUri;
    private final String type;
    public static final String QA = "QA";
    public static final String DEV = "DEV";
    public static final String PROD = "PROD";

    private String currentVersion;

    private Environment( long lastDeployTime,
                        long upDuration,
                        String currentUri,
                        String type,
                        String currentVersion){
        this.lastDeployTime = lastDeployTime;
        this.upDuration = upDuration;
        this.currentUri = currentUri;
        this.type = type;
        this.currentVersion = currentVersion;
    }

    public long getLastDeployTime() {
        return lastDeployTime;
    }

    public long getUpDuration() {
        return upDuration;
    }

    public String getCurrentUri() {
        return currentUri;
    }

    public String getType() {
        return type;
    }

    public void deploy(String version) throws NotOwnerException {
        if (type.equals("PROD")) {
            throw new NotOwnerException();
        }

        currentVersion = version;
        lastDeployTime = lastDeployTime + upDuration;
        //lastDeployTime = System.currentTimeMillis();
        upDuration = 0;
        System.out.println("New version deployed" + version);
    }

    public static String[] listEnvs(){

        return new String[]{QA, PROD, DEV};
    }

    public static Environment createEnvironment (long lastDeployTime,
                                                long upDuration,
                                                String currentUri,
                                                String type,
                                                String currentVersion){
        if(type != QA || type != DEV || type != PROD){
            throw new IllegalArgumentException();
        }
        Environment newEnvironment = new Environment(lastDeployTime,
                                                     upDuration,
                                                     currentUri,
                                                     type,
                                                     currentVersion);
        return newEnvironment;
    }
}

