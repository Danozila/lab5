import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Main {


    public static List<Integer> inputList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.print("Введите количество элементов': ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент " + i + ": ");
            list.add(scanner.nextInt());
        }

        return list;
    }
    public static Queue<Integer> inputQueue() {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент " + i + ": ");
            queue.add(scanner.nextInt());
        }

        return queue;
    }
    public static void main(String[] args) {
        int len;
        List<Integer> list1, list2, mergedList;
        System.out.println("Введите номер задачи(в формате: 1.1, где " +
                "первая цифра номер задачи, а вторая - номер подзадачи):");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        switch (s){
            case "1.1":
                System.out.println("Введите числитель и знаменатель первой дроби");
                int chis1 = scanner.nextInt();
                int znam1 = scanner.nextInt();
                FractionCashed f1 = new FractionCashed(chis1, znam1);
                System.out.println("Введите числитель и знаменатель второй дроби");
                int chis2 = scanner.nextInt();
                int znam2 = scanner.nextInt();
                FractionCashed f2 = new FractionCashed(chis2, znam2);
                System.out.println("Первая дробь: " + f1.toString());
                System.out.println("Вторая дробь: " + f2.toString());
                System.out.println("Десятичное значение первой дроби "  + f1.getDecimalValue());
                System.out.println("Десятичное значение первой дроби "  + f2.getDecimalValue());
                System.out.println("Равны ли дроби: " + f1.equals(f2));
                break;

            case "3.1":

                list1 = inputList();
                list2 = inputList();
                mergedList = mergeLists(list1, list2);
                System.out.println(mergedList);
                break;
            case "5.3":
                String filename = "C:\\Users\\Chucha\\IdeaProjects\\lab5\\src\\text.txt";
                Set<Character> uniqueConsonants = findUniqueConsonants(filename);
                List<Character> sortedConsonants = new ArrayList<>(uniqueConsonants);
                Collections.sort(sortedConsonants);
                System.out.println("Согласные буквы, которые входят ровно в одно слово: " + sortedConsonants);
                break;
            case "6.3":
                Queue<Integer> queue = inputQueue();
                System.out.println("Есть ли элемент, равный следующему за ним по кругу: " +
                        hasEqualInCircle(queue));
                break;
            default:
                System.out.println("нет задания с таким номером");
        }

    }
    public static <T extends Comparable<T>> List<T> mergeLists(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) <= 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
    public static <T> boolean hasEqualInCircle(Queue<T> queue) {
        if (queue.isEmpty()) {
            return false;
        }

        T firstElement = queue.remove();
        if (queue.isEmpty()) {
            return false;
        }
        T prevEl = firstElement;

        for (T currEl : queue) {
            if (currEl.equals(prevEl)) {
                return true;
            }
            prevEl = currEl;
        }

        if (firstElement.equals(prevEl)) {
            return true;
        }

        return false;
    }
    private static Set<Character> findUniqueConsonants(String filename) {
        Set<Character> ans = new HashSet<>();
        Set<Character> foundConsonants = new HashSet<>();
        Set<Character> notUniqueConsonants = new HashSet<>();
        String consonantChars = "бвгджзйлмнпрстфхцчшщ";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;


            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    Set<Character> foundConsonantsInWord = new HashSet<>();
                    for (char c : word.toLowerCase().toCharArray()) {
                        if (consonantChars.contains(Character.toString(c))) {
                            foundConsonantsInWord.add(c);
                            if(foundConsonants.contains(c)){
                                notUniqueConsonants.add(c);
                            }
                        }
                    }
                    foundConsonants.addAll(foundConsonantsInWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(char c: foundConsonants){
            if(notUniqueConsonants.contains(c) == false){
                ans.add(c);
            }
        }

        return ans;
    }
}