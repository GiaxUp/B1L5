package MultiPlayer;

import java.util.Scanner;

public class MultimediaPlayer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ElementoMultimediale[] elements = new ElementoMultimediale[5];

		// Crea 5 elementi da tastiera e inseriscili nell'array
		for (int i = 0; i < 5; i++) {
			System.out.print("Inserisci il tipo di elemento multimediale (1 = Immagine, 2 = Audio, 3 = Video): ");
			int type = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Inserisci il titolo: ");
			String title = scanner.nextLine();

			ElementoMultimediale element;
			if (type == 1) { // Caso 1 = Immagine
				System.out.print("Inserisci la luminosità: ");
				int brightness = scanner.nextInt();
				element = new Immagine(title, brightness);

			} else if (type == 2) { // Caso 2 = Audio
				System.out.print("Inserisci la durata in secondi: ");
				int duration = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Inserisci il volume: ");
				int volume = scanner.nextInt();
				element = new RegistrazioneAudio(title, duration, volume);
			} else if (type == 3) { // Caso 3 = Video
				System.out.print("Inserisci la durata in secondi: ");
				int duration = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Inserisci il volume: ");
				int volume = scanner.nextInt();
				System.out.print("Inserisci la luminosità: ");
				int brightness = scanner.nextInt();
				element = new Video(title, duration, volume, brightness);
			} else { // Caso extra = Input invalido
				System.out.println("Tipo di elemento non valido, riprova.");
				i--;
				continue;
			}

			elements[i] = element;
		}

		// Chiedi all'utente quale elemento eseguire cliccando 1-5, esci cliccando 0
		int choice;
		do {
			System.out.print("Quale elemento vuoi eseguire? (1-5 per selezionare, 0 per uscire): ");
			choice = scanner.nextInt();
			if (choice >= 1 && choice <= 5) {
				ElementoMultimediale element = elements[choice - 1];
				if (element.isRiproducibile()) {
					element.play();
				} else {
					element.show();
				}
			}
		} while (choice != 0);
	}
}