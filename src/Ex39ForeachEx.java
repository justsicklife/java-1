public class Ex39ForeachEx {
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5};
        int sum = 0;
        
        for(int k : n) {
            System.out.println(k + " ");
            sum +=k;
        }

        System.out.println("합은 " + sum);

        String f[] = {"사과","배","바나나","체리","딸기","포도"};

        for (String s : f) {
            System.out.println(s + " ");            
        }
    }
}
