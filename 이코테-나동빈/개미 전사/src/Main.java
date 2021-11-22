//     <문제> 개미 전사

//      메뚜기 마을에의 식량창고들은 일직선으로 이어져 있다.
//      각 식량창고에는 정해진 수의 식량을 저장하고 있으며
//      개미 전사는 식량창고를 선택적으로 약탈하여 식량을 빼앗는다.
//      이때 메뚜기 정찰병들은 일직선상에 존재하는 식량창고 중에서
//      서로 인접한 식량창고가 공격받으면 바로 알아챈다.
//      따라서 개미 전사가 정찰병에게 들키지 않고 식량창고를 약탈하기 위해선
//      최소 한 칸 이상 떨어진 식량창고를 약탈해야 한다.
//
//      예를 들어 식량창고가 {1, 3, 1, 5}라면 3, 5를 털어서
//      최댓값이 총 8개의 식량을 빼앗을 수 있는 것이다.
//      개미 전사가 식량창고 N개에 대한 정보가 주어졌을 때
//      얻을 수 있는 식량의 최댓값을 구하는 프로그램을 작성하시오


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        int[] storage = new int[N+1];

        for(int i=1; i<=N; i++) {
            storage[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = storage[1];

        for(int i=2; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+storage[i]);
        }

        bw.write(dp[N]+" ");

        bw.close();
    }
}