console.log('battle2.js cargado');

// Variables Globales
const API_AMERICA = 'http://localhost:8080/api/characters';

const FALLBACK_AMERICA = [
    { nombre: 'Messi', club: 'Inter Miami', nivelDePoder: 9000, url_imagen: 'imagenes/messi.png' },
    { nombre: 'Beltran', club: 'River Plate', nivelDePoder: 3000, url_imagen: 'imagenes/beltran.jpg' },
    { nombre: 'Janson', club: 'Boca Juniors', nivelDePoder: 6500, url_imagen: 'imagenes/pibejanson.png' }
];

// Elementos del HTML
const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fighter1Name = document.getElementById('fighter1Name');
const fighter2Name = document.getElementById('fighter2Name');
const fighter1Club = document.getElementById('fighter1Club');
const fighter2Club = document.getElementById('fighter2Club');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');

console.log('Elementos del HTML obtenidos:', { fighter1Select, fighter2Select, fightButton });

// Guardar los datos obtenidos
let america = [];

async function loadFromApi(url, fallback) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Respuesta no válida: ${response.status}`);
        }
        const data = await response.json();
        return Array.isArray(data) ? data : [data];
    } catch (error) {
        console.warn(`No se pudo cargar ${url}, usando datos locales.`, error);
        return fallback;
    }
}

// Traer a los luchadores
async function fetchData() {
    america = await loadFromApi(API_AMERICA, FALLBACK_AMERICA);
    console.log('Jugadores cargados:', america);
    loadFighters();
}

// Llenar las listas
function loadFighters() {
    if (america.length === 0) {
        console.warn('No hay jugadores cargados');
        return;
    }

    console.log('loadFighters ejecutándose, america.length:', america.length);

    america.forEach(fighter => {
        const option1 = document.createElement('option');
        option1.value = JSON.stringify(fighter);
        option1.text = `${fighter.nombre} — ${fighter.club}`;
        fighter1Select.appendChild(option1);

        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter);
        option2.text = `${fighter.nombre} — ${fighter.club}`;
        fighter2Select.appendChild(option2);
    });

    console.log('Options añadidas a los selectores');

    // Mostrar el primer jugador seleccionado
    updateFighter1();
    if (america.length > 1) {
        fighter2Select.selectedIndex = 1;
    }
    updateFighter2();
    
    console.log('updateFighter llamado');
}

// Actualizar imagen, nombre y club del jugador 1
function updateFighter1() {
    if (fighter1Select.value === '') {
        console.warn('fighter1Select.value está vacío');
        return;
    }
    
    try {
        const selected = JSON.parse(fighter1Select.value);
        fighter1Image.src = selected.url_Imagen || 'imagenes/unknown.jpeg';
        fighter1Name.textContent = selected.nombre;
        fighter1Club.textContent = selected.club;
        console.log('Fighter1 actualizado:', selected.nombre);
    } catch (e) {
        console.error('Error al parsear fighter1:', e);
    }
}

// Actualizar imagen, nombre y club del jugador 2
function updateFighter2() {
    if (fighter2Select.value === '') {
        console.warn('fighter2Select.value está vacío');
        return;
    }
    
    try {
        const selected = JSON.parse(fighter2Select.value);
        fighter2Image.src = selected.url_Imagen || 'imagenes/unknown.jpeg';
        fighter2Name.textContent = selected.nombre;
        fighter2Club.textContent = selected.club;
        console.log('Fighter2 actualizado:', selected.nombre);
    } catch (e) {
        console.error('Error al parsear fighter2:', e);
    }
}

// Reaccionar a los cambios
fighter1Select.addEventListener('change', updateFighter1);
fighter2Select.addEventListener('change', updateFighter2);

// La Lógica de Batalla
fightButton.addEventListener('click', () => {
    if (fighter1Select.value === '' || fighter2Select.value === '') {
        alert('Selecciona ambos luchadores.');
        return;
    }

    try {
        const fighter1 = JSON.parse(fighter1Select.value);
        const fighter2 = JSON.parse(fighter2Select.value);

        const power1 = fighter1.nivelDePoder || (Math.floor(Math.random() * 1000) + 500);
        const power2 = fighter2.nivelDePoder || (Math.floor(Math.random() * 1000) + 500);

        let resultText;
        if (power1 > power2) {
            resultText = `🏆 ¡${fighter1.nombre} gana la pelea! ⚽`;
        } else if (power2 > power1) {
            resultText = `🏆 ¡${fighter2.nombre} gana la pelea! ⚽`;
        } else {
            resultText = `🤝 ¡Es un empate!`;
        }

        resultDiv.textContent = resultText;
        resultDiv.classList.remove('hidden');
    } catch (e) {
        console.error('Error en la batalla:', e);
    }
});

console.log('A punto de hacer fetchData');
fetchData();