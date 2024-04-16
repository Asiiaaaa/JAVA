import java.util.*;

public class PhoneBook {
    private TreeMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>(Collections.reverseOrder());
    }

    public void addContact(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public TreeMap<String, HashSet<String>> getPhoneBook() {
        return phoneBook;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Alice", "1234567890");
        phoneBook.addContact("Bob", "5555555555");
        phoneBook.addContact("Alice", "9876543210");
        phoneBook.addContact("Charlie", "9999999999");

        // Создаем компаратор для сортировки по убыванию количества телефонных номеров
        Comparator<Map.Entry<String, HashSet<String>>> byPhoneNumberCount = (entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size());
        
        // Создаем список для сортировки контактов
        List<Map.Entry<String, HashSet<String>>> sortedContactsByPhoneNumberCount = new ArrayList<>(phoneBook.getPhoneBook().entrySet());
        sortedContactsByPhoneNumberCount.sort(byPhoneNumberCount);

        System.out.println("All contacts in the phone book sorted by the number of phone numbers:");
        for (Map.Entry<String, HashSet<String>> entry : sortedContactsByPhoneNumberCount) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

