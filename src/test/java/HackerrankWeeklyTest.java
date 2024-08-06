import org.hackerrank.weekly.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HackerrankWeeklyTest {

    @Test
    public void plusMinusTest(){
        PlusMinus.plusMinus(Arrays.asList(1, 1, 0, -1, -1));
    }

    @Test
    public void timeConversionTest(){
        System.out.println(TimeConversion.timeConversion("07:05:45PM"));
    }

    @Test
    public void lonelyIntegerTest(){
        LonelyInteger.lonelyinteger(Arrays.asList(1,2,3,4,3,2,1));
    }

    @Test
    public void diagonalDifferenceTest(){
        System.out.println(DiagonalDifference.diagonalDifference(Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(9,8,9)
        )));
    }

    @Test
    public void caesarCipher(){
        String[] case1 = {"Hello_World!", "4", "Lipps_Asvph!"};
        String[] case2 = {"Ciphering.", "26", "Ciphering."};
        String[] case3 = {"www.abc.xy", "87", "fff.jkl.gh"};
        String[] case4 = {"159357lcfd", "98", "159357fwzx"};

        String result = CaesarCipher.caesarCipher("There's-a-starman-waiting-in-the-sky", 3);
        System.out.println(result);
        String result1 = CaesarCipher.caesarCipher(case1[0], Integer.parseInt(case1[1]));
        String result2 = CaesarCipher.caesarCipher(case2[0], Integer.parseInt(case2[1]));
        String result3 = CaesarCipher.caesarCipher(case3[0], Integer.parseInt(case3[1]));
        String result4 = CaesarCipher.caesarCipher(case4[0], Integer.parseInt(case4[1]));

        Assertions.assertEquals(case1[2], result1);
        Assertions.assertEquals(case2[2], result2);
        Assertions.assertEquals(case3[2], result3);
        Assertions.assertEquals(case4[2], result4);
    }

    @Test
    public void findingZigZagSequence(){
        ZigZagSequence.findZigZagSequence(new int[]{2,3,5,1,4} , 5);
    }

    @Test
    public void superDigit(){
        System.out.println(SuperDigit.superDigit("9875", 4));
        System.out.println(SuperDigit.superDigit("861568688536788", 1000));
    }

    @Test
    public void mergeLists(){
        Solution.SinglyLinkedListNode head1 = new Solution.SinglyLinkedListNode(1);
        head1.next = new Solution.SinglyLinkedListNode(3);
        head1.next.next = new Solution.SinglyLinkedListNode(7);

        Solution.SinglyLinkedListNode head2 = new Solution.SinglyLinkedListNode(1);
        head2.next = new Solution.SinglyLinkedListNode(2);

        Solution.SinglyLinkedListNode result = Solution.mergeLists(head1, head2);

        while (result != null){
            System.out.println(result.data);
            result = result.next;
        }

    }


    @Test
    public void balancedString(){
        System.out.println(BalancedString.isBalanced("{[()]}"));
        System.out.println(BalancedString.isBalanced("{{[[(())]]}}"));
    }


    @Test
    public void binaryTreePreOrder(){
        BinaryTree.Node parent = new BinaryTree.Node();
        parent.data = 1;

        parent.right = new BinaryTree.Node();
        parent.right.data = 2;
        parent.right.right = new BinaryTree.Node();
        parent.right.right.data = 5;
        parent.right.right.left = new BinaryTree.Node();
        parent.right.right.left.data = 3;
        parent.right.right.right = new BinaryTree.Node();
        parent.right.right.right.data = 6;
        parent.right.right.right.right = new BinaryTree.Node();
        parent.right.right.right.right.data = 4;

        BinaryTree.preOrder(parent);
    }

    /**
     *
     *     Binary Tree

              1
         2        5
     3     4    6    7

     */

    BinaryTree.Node buildTree(){
        BinaryTree.Node parent = new BinaryTree.Node();
        parent.data = 1;

        parent.left = new BinaryTree.Node();
        parent.left.left = new BinaryTree.Node();
        parent.left.right = new BinaryTree.Node();

        parent.right = new BinaryTree.Node();
        parent.right.left = new BinaryTree.Node();
        parent.right.right = new BinaryTree.Node();

        parent.left.data = 2;
        parent.left.left.data = 3;
        parent.left.right.data = 4;

        parent.right.data = 5;
        parent.right.left.data = 6;
        parent.right.right.data = 7;

        return parent;
    }

    @Test
    public void preOrder(){
        BinaryTree.preOrder(buildTree());
    }

    @Test
    public void postOrder(){
        BinaryTree.postOrder(buildTree());
    }

    @Test
    public void inOrder(){
        BinaryTree.inOrder(buildTree());
    }

    @Test
    public void rightToLeft(){
        BinaryTree.rightToLeftPreOrder(buildTree());
    }

}
