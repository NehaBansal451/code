class Solution {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public int findDuplicate(int[] nums) {

        Node head = null;
        Node tail = null;

        // Create Linked List
        for (int num : nums) {
            Node node = new Node(num);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        Node first = head;

        while (first != null) {

            Node second = first.next;

            while (second != null) {

                if (first.value == second.value) {
                    return first.value;
                }

                second = second.next;
            }

            first = first.next;
        }

        return -1;
    }
}
