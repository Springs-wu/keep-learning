package demo;

/**
 * 两个数用链表逆序存储，计算出相加的结果，同样逆序输出
 * 343+464=708
 * (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)
 */
public class addReverse {

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        while (null != listNode) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ins = 0;
        ListNode result = new ListNode(0);
        ListNode last = result;
        while (null != l1 || null != l2 || ins != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + ins;
            int add = sum % 10;
            ins = sum / 10;
            last.next = new ListNode(add);
            last = last.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        return result.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
        }
    }

}
