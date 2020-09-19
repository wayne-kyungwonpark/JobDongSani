package programmers.blindtest2021;

public class A {
    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^.";
//        String new_id = "=.=";
//        String new_id = "123_.def";
        String new_id = "abcdefghijklmn.p";
        System.out.println(solution(new_id));
    }

    private static char a = 'a';
    private static char z = 'z';

    public static String solution(String new_id) {
        String answer = "";

        // 1.
        answer = new_id.toLowerCase();

        // 2.
        char[] chArr = answer.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] >= a && chArr[i] <=z){
                step2.append(chArr[i]);
                continue;
            }

            try{
                Integer.parseInt(String.valueOf(chArr[i]));
                step2.append(chArr[i]);
                continue;
            }catch(Exception e){
                if(chArr[i] == '-' || chArr[i] == '_' || chArr[i] == '.'){
                    step2.append(chArr[i]);
                    continue;
                }
            }
        }

        // 3.
        chArr = step2.toString().toCharArray();
        StringBuilder step3 = new StringBuilder();
        int index = -1;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '.' && index == -1){
                index = i;
                continue;
            }else if(chArr[i] == '.' && index != -1){
                if(i != chArr.length - 1 && chArr[i + 1] == '.'){
                    continue;
                }else{
                    step3.append('.');
                    index = -1;
                }
            }else if(chArr[i] != '.' && index != -1){
                step3.append('.');
                step3.append(chArr[i]);
                index = -1;
            }else{
                step3.append(chArr[i]);
            }
        }
        if(index != -1){
            step3.append('.');
        }

        // 4.
        answer = step3.toString();
        if(answer.length() >= 1 && answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }
        if(answer.length() >= 1 && answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5.
        if("".equals(answer)){
            answer = "a";
        }

        // 6.
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7.
        while(answer.length() <= 2){
            answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
        }

        return answer;
    }
}
