const $btnmenu = document.getElementById("menu-icon");
const $menu = document.getElementById("menu");
const $layer = document.getElementById("layer");
const $contenedorIngresos = document.getElementById("ingresosSection");


const date = new Date();
const output = String(date.getDate()).padStart(2, '0') + '/' + String(date.getMonth() + 1).padStart(2, '0') + '/' + date.getFullYear();

const $nuevoIngreso = document.getElementById("btnNuevoIngreso");

$btnmenu.addEventListener('click', () => {

    $menu.classList.toggle("active");
    $layer.classList.toggle("hidden");

})
$layer.addEventListener('click', () => {

    $menu.classList.remove('active');
    $layer.classList.add('hidden');

})

$nuevoIngreso.addEventListener('click', () => {

    $contenedorIngresos.innerHTML = `
        <h1>Sistema de gestión de Ingresos y Gastos</h1>
        <h2>Ingresos y egresos</h2>
        <a href="/ingresos"><img src="./images/flecha.png" /></a>
        <form class="">
            <fieldset>
                <legend>Crea tu movimiento</legend>
                <p class="fecha">${output}</p>
                <select>
                    <option disabled selected value="">Selecciona una empresa</option>
                </select>
                <input placeholder="Monto" type="number">
                <input placeholder="Concepto" type="text">
                <button>Crear</button>
            </fieldset>
        </form>
    `;

})
