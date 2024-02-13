package com.example.uione;
// LinearPojo.java
public class LinearPojo {

    private  String name;
    private  String address;
    private  int imageUrl;
//    private final String imageUrl;

    public LinearPojo(String name, String address, int imageUrl) {
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
//        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageUrl() {
        return imageUrl;
    }
//    public String getImageUrl() {        return imageUrl;    }
}


//public class LinearPojo {
//
//    private String versionName;
//    private String version;
//
//    public LinearPojo(String versionName, String version) {
//        this.versionName = versionName;
//        this.version = version;
//    }
//
//    public String getVersionName() {
//        return versionName;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//}

