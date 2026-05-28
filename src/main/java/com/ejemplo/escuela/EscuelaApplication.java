package com.ejemplo.escuela;

import com.ejemplo.escuela.entidades.Arma;
import com.ejemplo.escuela.entidades.Peleador;
import com.ejemplo.escuela.entidades.Ataque;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);

		Peleador messi = new Peleador("Messi", 1300, 300, 500f, null, null, null);
		Peleador ronaldo = new Peleador("Ronaldo", 1200, 250, 600f, null, null, null);

		Arma PiernaIzquierda = new Arma("Pierna Izquierda", 200, 50);
		Arma PiernaDerecha = new Arma("Pierna Derecha", 150, 30);
		Arma Cabeza = new Arma("Cabeza", 120, 20);
		Arma ManoDerecha = new Arma("Mano Derecha", 100, 15);
		Arma ManoIzquierda = new Arma("Mano Izquierda", 90, 10);

		Ataque tiroLibre = new Ataque("Tiro libre", 300, 80);
		Ataque chilena = new Ataque("Chilena", 250, 100);
		Ataque rabona = new Ataque("Rabona", 200, 60);

		System.out.println(messi.getNombre() + " tiene " + messi.getPuntosVida() + " puntos de vida.");
		System.out.println(ronaldo.getNombre() + " tiene " + ronaldo.getPuntosVida() + " puntos de vida.");

		
		messi.setInventario(List.of(PiernaIzquierda));
		ronaldo.setInventario(List.of(PiernaDerecha));

		int bonificadorMessi = messi.getInventario().get(0).getBonificadorDanio();
		int bonificadorRonaldo = ronaldo.getInventario().get(0).getBonificadorDanio();

		if (bonificadorMessi > bonificadorRonaldo) {
			System.out.println("El pie más fuerte lo tiene " + messi.getNombre());
		} else if (bonificadorRonaldo > bonificadorMessi) {
			System.out.println("El pie más fuerte lo tiene " + ronaldo.getNombre());
		} else {
			System.out.println("Ambos tienen el mismo bonificador de daño.");
		}

		List<Arma> inventarioMessi1 = new ArrayList<>();
		List<Arma> armas = List.of(PiernaIzquierda, PiernaDerecha, Cabeza, ManoDerecha, ManoIzquierda);
		for (Arma arma : armas) {
			inventarioMessi1.add(arma);
		}


		Ataque ataqueMax = tiroLibre;
		if (chilena.getDanioBase() > ataqueMax.getDanioBase()) {
			ataqueMax = chilena;
		}
		if (rabona.getDanioBase() > ataqueMax.getDanioBase()) {
			ataqueMax = rabona;
		}
		System.out.println("El ataque con más daño base es: " + ataqueMax.getNombre());

	}

}
