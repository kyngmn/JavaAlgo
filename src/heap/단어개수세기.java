package heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vocab implements Comparable<Vocab> {
	String word;
	int count;

	public Vocab() {
	}

	public Vocab(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public String toString() {
//		return word + "    " + count;
		return "Vocab [word=" + word + ", count=" + count + "]";
	}

	@Override
	public int compareTo(Vocab o) {
		// 개수가 같으면 알파벳순
		if (this.count == o.count) {
			return this.word.compareTo(o.word);
		}
		// 기본적으로 오름차순
		return o.count - this.count;
	}
}

public class 단어개수세기 {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> wordMap = new HashMap<>();
		Scanner sc;
		try (BufferedReader br = new BufferedReader(new FileReader("word.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				// a 97, z 122
				sc = new Scanner(line.toLowerCase());
				while (sc.hasNext()) {
					String s = sc.next().replaceAll("[^a-z]*", "");
					wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
//					
//					StringBuilder sb = new StringBuilder();
//					for (char c : s.toCharArray()) {
//						if ((int) c < 97 || (int) c > 122)
//							continue;
//						sb.append(c);
//					}
//					String res = sb.toString();
//					wordMap.put(res, wordMap.get(res) == null ? 1 : wordMap.get(res) + 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 맵 정렬!!!!
		List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
		list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

//		System.out.println(wordMap);

		PriorityQueue<Vocab> pq = new PriorityQueue<>();
		for (String word : wordMap.keySet()) {
//			System.out.println(word);
			pq.add(new Vocab(word, wordMap.get(word)));
		}

//		System.out.println("단어 빈도수");
//		System.out.println("--------------------------");
//		while (!pq.isEmpty()) {
//			Vocab v = pq.poll();
//			System.out.printf("%-4s", v.word);
//			System.out.printf("%4s\n", v.count);
//		}

		try (FileWriter fw = new FileWriter("결과.txt")) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("결과.txt"));
					PrintWriter pw = new PrintWriter(bw);) {
				pw.println("단어 빈도수");
				pw.println("--------------------------");
				while (!pq.isEmpty()) {
					Vocab v = pq.poll();
					pw.printf("%-4s", v.word);
					pw.printf("%4s\n", v.count);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
