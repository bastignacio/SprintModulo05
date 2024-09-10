

document.getElementById('userType').addEventListener('change', function() {
    var clienteFields = document.getElementById('clienteFields');
    var administrativoFields = document.getElementById('administrativoFields');
    var profesionalFields = document.getElementById('profesionalFields');

    // Ocultar todos los campos adicionales
    clienteFields.classList.add('d-none');
    administrativoFields.classList.add('d-none');
    profesionalFields.classList.add('d-none');

    // Limpiar atributos de required
    clearRequiredFields();

    // Mostrar los campos adicionales correspondientes
    if (this.value === 'cliente') {
        clienteFields.classList.remove('d-none');
        setRequiredFields(clienteFields);
    } else if (this.value === 'administrativo') {
        administrativoFields.classList.remove('d-none');
        setRequiredFields(administrativoFields);
    } else if (this.value === 'profesional') {
        profesionalFields.classList.remove('d-none');
        setRequiredFields(profesionalFields);
    }
});

// Limpiar los campos requeridos
function clearRequiredFields() {
    var fields = document.querySelectorAll('#clienteFields input, #administrativoFields input, #profesionalFields input');
    fields.forEach(function(field) {
        field.removeAttribute('required');
        field.classList.remove('is-invalid'); // Quitar clase de error
    });
}

// Establecer los campos requeridos
function setRequiredFields(container) {
    var fields = container.querySelectorAll('input');
    fields.forEach(function(field) {
        field.setAttribute('required', 'true');
    });
}

// Validar el formulario al enviarlo
document.getElementById('userForm').addEventListener('submit', function(event) {
    var form = this;
    var isValid = true;
    
    // Validar todos los campos visibles
    var requiredFields = form.querySelectorAll('input[required]');
    requiredFields.forEach(function(field) {
        if (!field.value) {
            field.classList.add('is-invalid');
            isValid = false;
        } else {
            field.classList.remove('is-invalid');
        }
    });

    if (!isValid) {
        event.preventDefault();
        event.stopPropagation();
        alert('Por favor, complete todos los campos requeridos.');
    }
});

const cambiarTema = () => {
    console.log("Cambiando tema"); // Esto debería aparecer en la consola al hacer clic
    document.querySelector("body").getAttribute("data-bs-theme") === "light" ? temaOscuro() : temaClaro();
};
