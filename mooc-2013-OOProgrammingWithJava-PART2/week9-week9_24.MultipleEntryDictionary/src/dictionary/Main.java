package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MultipleEntryDictionary dictionary = new PersonalMultipleEntryDictionary();
        dictionary.add("casa", "house");
        System.out.println(dictionary.translate("casa"));
        dictionary.add("casa", "hus");
        System.out.println(dictionary.translate("casa"));
        dictionary.remove("casa");
        System.out.println(dictionary.translate("casa"));
    }
}
