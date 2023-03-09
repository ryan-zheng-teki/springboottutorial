public class TestString {
    public static void main(String... args) {
        long free1 = free();
        String s = "";
        long free2 = free();
        String s2 = new String("");
        long free3 = free();
        if (free3 == free1) System.err.println("You need to use -XX:-UseTLAB");
        System.out.println("\"\" took " + (free1 - free2) + " bytes and new String(\"\") took " + (free2
                - free3) + " bytes.");
    }

    private static long free() {
        return Runtime.getRuntime().freeMemory();
    }
}
