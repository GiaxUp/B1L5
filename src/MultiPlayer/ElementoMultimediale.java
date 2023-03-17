package MultiPlayer;

abstract class ElementoMultimediale {
	protected String titolo;

	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}

	public abstract boolean isRiproducibile();

	public abstract void play();

	public abstract void show();
}

// Immagine
class Immagine extends ElementoMultimediale {
	private int luminosita;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public boolean isRiproducibile() {
		return false;
	}

	public void play() {
		throw new UnsupportedOperationException("Un'immagine non è riproducibile");
	}

	public void show() {
		System.out.print(titolo + " ");
		for (int i = 0; i < luminosita; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}

// Audio
class RegistrazioneAudio extends ElementoMultimediale {
	private int durata;
	private int volume;

	public RegistrazioneAudio(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}

	public boolean isRiproducibile() {
		return true;
	}

	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.print(titolo + " ");
			for (int j = 0; j < volume; j++) {
				System.out.print("!");
			}
			System.out.println();
		}
	}

	public void show() {
		throw new UnsupportedOperationException("Una registrazione audio non è un'immagine");
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}
}

// Video
class Video extends ElementoMultimediale {
	private int durata;
	private int volume;
	private int luminosita;

	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
		this.luminosita = luminosita;
	}

	public boolean isRiproducibile() {
		return true;
	}

	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.print(titolo + " ");
			for (int j = 0; j < volume; j++) {
				System.out.print("!");
			}
			for (int j = 0; j < luminosita; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void show() {
		throw new UnsupportedOperationException("Un video non è un'immagine statica");
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}
	}

	public void aumentaLuminosita() {
		luminosita++;
	}
}
