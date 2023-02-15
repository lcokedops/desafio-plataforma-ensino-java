package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> lessons = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i=0; i<n; i++) {
			System.out.printf("Dados da %da aula:%n", i+1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if(type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				lessons.add(new Video(title, url, duration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				Integer questionCount = sc.nextInt();
				lessons.add(new Task(title, description, questionCount));
			}
			System.out.println();
		}
		
		int totalDuration = 0;
		for (Lesson l : lessons) {
			totalDuration += l.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", totalDuration);
		
		sc.close();
		
	}

}
