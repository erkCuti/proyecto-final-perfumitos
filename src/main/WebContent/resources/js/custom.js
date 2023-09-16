document.addEventListener("DOMContentLoaded", function () {
    const formLinks = document.querySelectorAll("[data-form]");
    const formContainer = document.getElementById("formContainer");

    // Función para mostrar un formulario específico
    function showForm(formId) {
        const forms = formContainer.querySelectorAll("div[id$='Form']");
        forms.forEach((form) => {
            form.style.display = "none";
        });

        const targetForm = document.getElementById(formId);
        if (targetForm) {
            targetForm.style.display = "block";
        }
    }

    // Agregar evento de clic a los enlaces de categoría
    formLinks.forEach((link) => {
        link.addEventListener("click", function (event) {
            event.preventDefault();
            const formId = link.getAttribute("data-form");
            showForm(formId);
        });
    });
});