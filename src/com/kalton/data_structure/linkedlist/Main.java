package com.kalton.data_structure.linkedlist;

import com.kalton.data_structure.dynamic_array.DynamicArray;
import com.kalton.data_structure.linkedlist.circle.Both_CircleLinkedList;
import com.kalton.data_structure.linkedlist.circle.CircleLinkedList;
import com.kalton.data_structure.linkedlist.circle.Intensify_Both_CircleLinkedList;
import com.kalton.data_structure.list.List;
import com.kalton.data_structure.util.Asserts;

/**
 * 数据结构 - 链表测试类
 *
 * @author 衍方
 * @date 2020/9/5 - 13:09
 * @link https://github.com/kaltons/Java-Algorithm
 */
public class Main {

    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    // 约瑟夫问题测试
    static void josephus() {
        Intensify_Both_CircleLinkedList<Integer> list = new Intensify_Both_CircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }

    public static void main(String[] args) {
        testList(new DynamicArray<>());
        testList(new LinkedList<>());
        testList(new Virtual_LinkedList<>());
        testList(new Both_LinkedList<>());
        testList(new CircleLinkedList<>());
        testList(new Both_CircleLinkedList<>());

        josephus();
    }
}
