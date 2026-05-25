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

	// ejercicio 6 + 7 (67 xdxd)
	public static void realizarGolpe(Peleador atacante, Peleador defensor, Ataque ataque) {

		// Ejercicio 7
		if (atacante.getEnergia() >= ataque.getCostoEnergia()) {

			// Ejercicio 6
			int bonificador = atacante.getInventario().get(0).getBonificadorDanio();
			int danioTotal = ataque.getDanioBase() + bonificador;

			// Restar el daño al atacado
			defensor.setPuntosVida(defensor.getPuntosVida() - danioTotal);

			// Restar energía al q atacó
			atacante.setEnergia(atacante.getEnergia() - ataque.getCostoEnergia());

			System.out.println(
					defensor.getNombre() + " recibió " + danioTotal +
							" de daño. Ahora tiene: " + defensor.getPuntosVida());

		} else {
			System.out.println(atacante.getNombre() + " está demasiado cansado para atacar");
		}

	}

	// jercicio 8 función
	public static void descansoTactico(Peleador p) {

		if (p.getPuntosVida() < 200) {
			// curación pesada
			p.setPuntosVida(p.getPuntosVida() + 500);
			p.setEnergia(0);

			System.out.println(p.getNombre() + " recibió curación pesada.");

		} else {
			// descanso rápido
			p.setEnergia(p.getEnergia() + 100);

			System.out.println(p.getNombre() + " recuperó energía.");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
		// ejercicio 1
		Peleador messi = new Peleador("Messi", 1300, 300, 500f, null, null, null);
		Peleador ronaldo = new Peleador("Ronaldo", 1200, 250, 600f, null, null, null);

		Arma PiernaIzquierda = new Arma("Pierna Izquierda", 200, 50);
		Arma PiernaDerecha = new Arma("Pierna Derecha", 150, 30);
		Arma Cabeza = new Arma("Cabeza", 120, 20);
		Arma ManoDerecha = new Arma("Mano Derecha", 100, 15);
		Arma ManoIzquierda = new Arma("Mano Izquierda", 90, 10);

		Ataque tiroLibre = new Ataque("Tiro libre", 300, 80);
		Ataque chilena = new Ataque("Chilena", 6767767, 100);
		Ataque rabona = new Ataque("Rabona", 200, 60);

		System.out.println(messi.getNombre() + " tiene vida: " + messi.getPuntosVida() + " y energía: " + messi.getEnergia());
		System.out.println(ronaldo.getNombre() + " tiene vida: " + ronaldo.getPuntosVida() + " y energía: " + ronaldo.getEnergia());
		// ejercicio 2
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

		// ejercicio 3
		List<Arma> armas = new ArrayList<>();
		armas.add(PiernaIzquierda);
		armas.add(PiernaDerecha);
		armas.add(Cabeza);
		armas.add(ManoDerecha);
		armas.add(ManoIzquierda);
		List<Arma> inventarioMessi2 = new ArrayList<>();
		for (Arma arma : armas) {
			inventarioMessi2.add(arma);
		}
		messi.setInventario(inventarioMessi2);
		for (Arma arma : messi.getInventario()) {
			System.out.println("Messi tiene " + arma.getNombre());
		}

		// ejercicio 4
		List<Ataque> habilidadesMessi = new ArrayList<>();
		habilidadesMessi.add(tiroLibre);
		habilidadesMessi.add(chilena);
		habilidadesMessi.add(rabona);
		messi.setHabilidades(habilidadesMessi);

		Ataque ataqueMax = messi.getHabilidades().get(0); // arrancamos con el primero
		for (Ataque ataque : messi.getHabilidades()) {
			if (ataque.getDanioBase() > ataqueMax.getDanioBase()) {
				ataqueMax = ataque;
			}
		}
		System.out.println("El ataque más poderoso de Messi es: " + ataqueMax.getNombre());

		// ejercicio 5
		int sumaEnergia = 0;
		for (Ataque ataque : messi.getHabilidades()) {
			sumaEnergia += ataque.getCostoEnergia();
		}
		float promedio = (float) sumaEnergia / messi.getHabilidades().size();
		System.out.println("Promedio de costo de energía: " + promedio);
		if (promedio > 50) {
			System.out.println("El promedio supera los 50 de energía.");
		}

		// ejercicio 6 + 7 (67 :v)
		realizarGolpe(messi, ronaldo, chilena);

		// ejercicio 8
		descansoTactico(ronaldo);
		descansoTactico(messi);

		// ejercicio 9
		for (Ataque ataque : messi.getHabilidades()) {

			if (ataque.getCostoEnergia() <= messi.getEnergia()) {
				System.out.println("Messi puede usar: " + ataque.getNombre());
			}
		}

		// ejercicio 10
		messi.setEnergia(670);
		ronaldo.setEnergia(420);
		// acá le agregamos habilidades a ronaldo para que pueda atacar (segun la ia)
		List<Ataque> habilidadesRonaldo = new ArrayList<>();

		habilidadesRonaldo.add(rabona);
		habilidadesRonaldo.add(tiroLibre);

		ronaldo.setHabilidades(habilidadesRonaldo);

		System.out.println("PVP");
		int contadorTurno = 1;

		while (messi.getPuntosVida() > 0 && ronaldo.getPuntosVida() > 0) {
			System.out.println("\n Ronda " + contadorTurno);

			boolean messiPuedeAtacar = messi.getHabilidades().stream()
				.anyMatch(a -> a.getCostoEnergia() <= messi.getEnergia());
			boolean ronaldoPuedeAtacar = ronaldo.getHabilidades().stream()
				.anyMatch(a -> a.getCostoEnergia() <= ronaldo.getEnergia());

			if (!messiPuedeAtacar && !ronaldoPuedeAtacar) {
				System.out.println("Ambos peleadores están agotados.");
				break;
			}

			Ataque primerAtaqueMessi = messi.getHabilidades().get(0);
			realizarGolpe(messi, ronaldo, primerAtaqueMessi);
			if (ronaldo.getPuntosVida() > 0) {
				Ataque primerAtaqueRonaldo = ronaldo.getHabilidades().get(0);
				realizarGolpe(ronaldo, messi, primerAtaqueRonaldo);
			} else {
				System.out.println(ronaldo.getNombre() + " cayó.");
			}
			System.out.println("-> " + messi.getNombre() + " (vida: " + messi.getPuntosVida() + ", energía: " + messi.getEnergia() + ") | "
					+ ronaldo.getNombre() + " (vida: " + ronaldo.getPuntosVida() + ", energía: " + ronaldo.getEnergia() + ")");

			contadorTurno++;
		}
		System.out.println("fin del combate");
		if (messi.getPuntosVida() <= 0 && ronaldo.getPuntosVida() <= 0) {
			System.out.println("Empate, los 2 se mataron al mismo tiempo");
		} else if (ronaldo.getPuntosVida() <= 0) {
			System.out.println("El ganador es " + messi.getNombre());
		} else if (messi.getPuntosVida() <= 0) {
			System.out.println("El ganador es " + ronaldo.getNombre());
		}

	}

}
