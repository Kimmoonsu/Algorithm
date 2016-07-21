import java.util.Scanner;

public class no2578 {
	
	// check method
	public static boolean checkBingo(int map[][]) {
		int bingo_cnt = 0; // 빙고 횟수
		// 가로 검사
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += map[i][j];
			}
			// 그 줄이 전부 지워졌을 경우
			if (sum == -5)
				bingo_cnt++;
		}
		// 세로 검사
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += map[j][i];
			}
			// 그 줄이 전부 지워졌을 경우
			if (sum == -5)
				bingo_cnt++;
		}

		// 대각선 검사
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			sum += map[j][j];
		}
		// 그 줄이 전부 지워졌을 경우
		if (sum == -5)
			bingo_cnt++;
		sum = 0;

		for (int j = 0; j < 5; j++) {
			sum += map[4 - j][j];
		}
		if (sum == -5)
			bingo_cnt++;
		sum = 0;
		if (bingo_cnt >= 3) return true;
		return false;
	}

	public static void main(String[] args) {
		int map[][] = new int[5][5];
		int announce[] = new int[25];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				map[i][j] = sc.nextInt();
		for (int i = 0; i < 25; i++)
			announce[i] = sc.nextInt();
		boolean state = true;
		int index = 0;
		// 게임 시작
		while (state) {
			// 빙고판 안에 있는 숫자 확인 후 지우기 (-1로 셋팅)
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == announce[index])// 사회자가 부른 수 비교
					{
						map[i][j] = -1;
					}
				}
			}
			index++;
			if (index >= 12 && checkBingo(map))
				state = false;
		}
		System.out.println(index);
	}
}
