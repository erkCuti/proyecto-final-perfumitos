const tabla = document.getElementById("miTabla");
const botonAgregar = document.getElementById("agregarFila");
const botonLimpiar = document.getElementById("limpiarFila");

// Función para agregar una fila
function agregarFila() {
  const nuevaFila = tabla.insertRow(); // Crea una nueva fila en la tabla

  const celdaDescripcion = nuevaFila.insertCell(0); // Crea una celda en la posición 0 (primera columna)
  celdaDescripcion.innerHTML = '<input type="text" class="small-input">'; // Agrega contenido a la celda

  const celdaPrUnitario = nuevaFila.insertCell(1); // Crea una celda en la posición 1 (segunda columna)
  celdaPrUnitario.innerHTML ='<input type="text" class="small-input">'; // Agrega contenido a la celda

  const celdaCantidad = nuevaFila.insertCell(2); // Crea una celda en la posición 2 (tercera columna)
  celdaCantidad.innerHTML ='<input type="text" class="small-input">'; // Agrega contenido a la celda

  const celdaSubtotal = nuevaFila.insertCell(3); // Crea una celda en la posición 3 (cuarta columna)
  celdaSubtotal.innerHTML ='<input type="text" class="small-input">'; // Agrega contenido a la celda
}

function limpiarFila() {
  while (tabla.rows.length > 1) {
    tabla.deleteRow(1); // Elimina la segunda fila (índice 1) en cada iteración
  }
}
// Agregar un evento click al botón
botonAgregar.addEventListener("click", agregarFila);
botonLimpiar.addEventListener("click", limpiarFila);