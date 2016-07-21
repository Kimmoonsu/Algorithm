import java.util.Scanner;

public class no2578 {
	
	// check method
	public static boolean checkBingo(int map[][]) {
		int bingo_cnt = 0; // ���� Ƚ��
		// ���� �˻�
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += map[i][j];
			}
			// �� ���� ���� �������� ���
			if (sum == -5)
				bingo_cnt++;
		}
		// ���� �˻�
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += map[j][i];
			}
			// �� ���� ���� �������� ���
			if (sum == -5)
				bingo_cnt++;
		}

		// �밢�� �˻�
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			sum += map[j][j];
		}
		// �� ���� ���� �������� ���
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
		// ���� ����
		while (state) {
			// ������ �ȿ� �ִ� ���� Ȯ�� �� ����� (-1�� ����)
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == announce[index])// ��ȸ�ڰ� �θ� �� ��
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
