package Annotations;
class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature.");
    }

    void newFeature() {
        System.out.println("This is the new feature.");
    }
}

class Q2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
