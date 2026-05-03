package week_01;

import java.util.LinkedList;
import java.util.Queue;

public class Mappractice {
	public static void main(String[] args) {
		
		// FIFO 원칙을 지키기 위해 Queue 인터페이스 사용
		Queue<String> waitingList = new LinkedList<>();
	
		
		// 학생 접수
		System.out.println("===학생 접수 시작(선착순)===");
		waitingList.offer("동훈이");
		waitingList.offer("t수완이");
		
		System.out.println("현재 대기열: " + waitingList);
		System.out.println("현재 총 대기 인원: " + waitingList.size());
		
		System.out.println("\n=== 수강 승인 및 처리 시작===");
		
		// 먼저 온 순서대로 처리
		while (!waitingList.isEmpty()) {
			// poll()은 가장 먼저 들어온 데이터를 꺼내고 리스트에서 삭제함
			String processedStudent = waitingList.poll();
			System.out.println("접수 처리 완료: " + processedStudent);
			System.out.println("남은 대기열: " + waitingList);
		}
		
		System.out.println("\n모든 접수가 완료되었습니다.");
		
			
		}
	}

