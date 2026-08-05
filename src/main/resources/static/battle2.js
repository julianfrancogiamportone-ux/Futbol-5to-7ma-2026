//Variables Globales
//api de base de datos, gestionado en el controller
const API_AMERICA = 'http://localhost:8080/api/characters';
// const API_EUROPA = 'http://localhost:8081/api/characters';

const FALLBACK_AMERICA = [
    { nombre: 'Messi', club: 'Inter Miami', nivelDePoder: 9000, url_imagen: 'imagenes/messi.png' },
    { nombre: 'Beltran', club: 'River Plate', nivelDePoder: 3000, url_imagen: 'imagenes/beltran.jpg' },
    { nombre: 'Janson', club: 'Boca Juniors', nivelDePoder: 6500, url_imagen: 'imagenes/pibejanson.png' }
];

// const FALLBACK_EUROPA = [
//     { nombre: 'Haaland', club: 'Manchester City', nivelDePoder: 8000, url_imagen: 'imagenes/haaland.png' },
//     { nombre: 'Kane', club: 'Bayern Munich', nivelDePoder: 7800, url_imagen: 'imagenes/kane.png' },
//     { nombre: 'Cristiano Ronaldo', club: 'Al Nassr', nivelDePoder: 8500, url_imagen: 'imagenes/cr7.png' }   
// ];

//elementos del html
const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');

//guardamos los datos obtenidos
let america = [];
let europa = [];

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

//Traer a los luchadores
async function fetchData() {
    america = await loadFromApi(API_AMERICA, FALLBACK_AMERICA);
    //europa = await loadFromApi(API_EUROPA, FALLBACK_EUROPA);
    loadFighters();
}
//Llenar las listas
//por cada peleador creamos un option en el selector
function loadFighters() {
    [...america, ...europa].forEach(fighter => {
        const option1 = document.createElement('option');
        option1.value = JSON.stringify(fighter);
        option1.text = `${fighter.nombre} — ${fighter.club}`;
        fighter1Select.appendChild(option1);
        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter);
        option2.text = `${fighter.nombre} — ${fighter.club}`;
        fighter2Select.appendChild(option2);
    });
    const selected = JSON.parse(fighter1Select.value);
    fighter1Image.src = selected.url_imagen || 'placeholder1.png';
    const selected2 = JSON.parse(fighter2Select.value);
    fighter2Image.src = selected2.url_imagen || 'placeholder2.png';
}
//Reaccionar a los cambios
// Actualizar la imagen al seleccionar un personaje
fighter1Select.addEventListener('change', () => {
    const selected = JSON.parse(fighter1Select.value);
    fighter1Image.src = selected.url_imagen || 'placeholder1.png';
});
fighter2Select.addEventListener('change', () => {
    const selected = JSON.parse(fighter2Select.value);
    fighter2Image.src = selected.url_imagen || 'placeholder2.png';
});
//La Lógica de Batalla
fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(fighter1Select.value);
    const fighter2 = JSON.parse(fighter2Select.value);
    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos luchadores.');
        return;
    }
    // Simular "nivelDePoder"
    const power1 = fighter1.nivelDePoder || (Math.floor(Math.random() * 1000) + 500);
    const power2 = fighter2.nivelDePoder || (Math.floor(Math.random() * 1000) +
        500);
    let winner;
    if (power1 > power2) {
        winner = fighter1.nombre;
    } else if (power2 > power1) {
        winner = fighter2.nombre;
    } else {
        winner = "¡Empate!";
    }
    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
    resultDiv.classList.remove('hidden');
});
fetchData();