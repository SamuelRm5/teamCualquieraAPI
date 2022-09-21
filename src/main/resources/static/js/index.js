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

    `;

})
